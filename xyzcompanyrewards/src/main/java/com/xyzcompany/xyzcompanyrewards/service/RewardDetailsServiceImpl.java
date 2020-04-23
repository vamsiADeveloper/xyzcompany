package com.xyzcompany.xyzcompanyrewards.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xyzcompany.xyzcompanyrewards.dao.CustomerTransactions;
import com.xyzcompany.xyzcompanyrewards.dao.CustomerTransactionsDAO;
import com.xyzcompany.xyzcompanyrewards.helper.RewardsCalculationHelper;
import com.xyzcompany.xyzcompanyrewards.model.UserMonthlyStatementData;
import com.xyzcompany.xyzcompanyrewards.resource.RewardDetailsResource;
import com.xyzcompany.xyzcompanyrewards.resource.RewardDetailsResourceBuilder;

@Component
public class RewardDetailsServiceImpl implements RewardDetailsService{

	@Autowired
	CustomerTransactionsDAO customerTransactionsDAO;
	
	@Override
	public List<RewardDetailsResource> getRewardDetaislOfAllCustomers() {
		List<CustomerTransactions> txs = customerTransactionsDAO.findAll();
		List<RewardDetailsResource> rewardDetailsList = new ArrayList<RewardDetailsResource>();
		
		for(CustomerTransactions customerTransaction : txs) {
				RewardDetailsResource resource  =  RewardDetailsResourceBuilder.builder()
						.withCustomerName(customerTransaction.getCustomerName())
						.withTranscationAmount(customerTransaction.getTransactionAmount())
						.withRewardPointsEarned(RewardsCalculationHelper.calculateRewardPointsPerTx(customerTransaction.getTransactionAmount()))
						.withRewardsForMonth(customerTransaction.getTransactionsForMonth())
						.withRewardsForyear(customerTransaction.getTransactionsForYear())
						.build();
				rewardDetailsList.add(resource);
			}
		return rewardDetailsList;
	}

	@Override
	public List<RewardDetailsResource> getRewardDetails(String customerName) {
		List<CustomerTransactions> txs = customerTransactionsDAO.findByCustomerName(customerName);
		List<RewardDetailsResource> rewardDetailsList = new ArrayList<RewardDetailsResource>();
		Map<String, Long> monthTxCountsMap = txs.stream().collect(
                Collectors.groupingBy(CustomerTransactions::getTransactionsForMonth, Collectors.counting()));
		Map<String, BigDecimal> monthTxAmntMap = new HashMap<String, BigDecimal>();
		getMonthAmtConsolidatedMap(txs, monthTxAmntMap);
		 
		
		for(CustomerTransactions customerTransaction : txs) {
			if (monthTxCountsMap.get(customerTransaction.getTransactionsForMonth()) != null 
					&& monthTxCountsMap.get(customerTransaction.getTransactionsForMonth()) > 1L
					&& rewardDetailsList.stream()
					  .filter(customer -> customerTransaction.getCustomerName().equals(customer.getCustomerName()))
					  .findAny()
					  .orElse(null) != null) {
					continue;
			} else {
				RewardDetailsResource resource  =  RewardDetailsResourceBuilder.builder()
						.withCustomerName(customerTransaction.getCustomerName())
						.withTranscationAmount(monthTxAmntMap.get(customerTransaction.getTransactionsForMonth()))
						.withRewardPointsEarned(RewardsCalculationHelper.calculateRewardPointsPerTx(customerTransaction.getTransactionAmount()))
						.withRewardsForMonth(customerTransaction.getTransactionsForMonth())
						.withRewardsForyear(customerTransaction.getTransactionsForYear())
						.withNumberOfTranscations(Math.toIntExact(monthTxCountsMap.get(customerTransaction.getTransactionsForMonth())))
						.build();
				rewardDetailsList.add(resource);
			}
				
		}
		return rewardDetailsList;
	}

	@Override
	public UserMonthlyStatementData getSpecificEomData(String customerName, String rewardsMonth) {
	 
		List<BigDecimal> txPointsList = new ArrayList<BigDecimal>();
		List<CustomerTransactions> txs = customerTransactionsDAO.findByCustomerNameAndTransactionsForMonth(customerName, rewardsMonth);
		UserMonthlyStatementData monthlyData = new UserMonthlyStatementData();
		monthlyData.setCustomerName(customerName);
		monthlyData.setRewardsForMonth(rewardsMonth);
		monthlyData.setNumberOfTransactions(txs.size());
		monthlyData.setRewardsForyear(txs.stream().map(CustomerTransactions::getTransactionsForYear).collect(Collectors.toList()).get(0));
		List<BigDecimal> amountsPerTx = txs.stream().map(CustomerTransactions::getTransactionAmount).collect(Collectors.toList());
		for(BigDecimal amt: amountsPerTx) {
			txPointsList.add(RewardsCalculationHelper.calculateRewardPointsPerTx(amt));
		}
		monthlyData.setAmountPerTx(amountsPerTx);
		monthlyData.setRewardPointsPerTx(txPointsList);
		return monthlyData;
	}

	private void getMonthAmtConsolidatedMap(List<CustomerTransactions> txs, Map<String, BigDecimal> monthTxAmntMap) {
		for (int i=0; i<txs.size(); i++) {
				if (!monthTxAmntMap.containsKey(txs.get(i).getTransactionsForMonth())) {
					monthTxAmntMap.put(txs.get(i).getTransactionsForMonth(), txs.get(i).getTransactionAmount());
				} else {
					BigDecimal amount = monthTxAmntMap.get(txs.get(i).getTransactionsForMonth());
					amount = amount.add(txs.get(i).getTransactionAmount());
					monthTxAmntMap.put(txs.get(i).getTransactionsForMonth(), amount);
				}
		}
	}
}
