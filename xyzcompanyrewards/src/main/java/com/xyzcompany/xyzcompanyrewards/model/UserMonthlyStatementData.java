package com.xyzcompany.xyzcompanyrewards.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class UserMonthlyStatementData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private String customerName;
	private Integer numberOfTransactions;
	private Integer rewardPointsEarned;
	private String rewardsForMonth;
	private String rewardsForyear;
	private List<BigDecimal> amountPerTx;
	private List<BigDecimal> rewardPointsPerTx;
	private BigDecimal rewardPointsTotal;
	
	
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public Integer getNumberOfTransactions() {
		return numberOfTransactions;
	}
	public void setNumberOfTransactions(Integer numberOfTransactions) {
		this.numberOfTransactions = numberOfTransactions;
	}
	public Integer getRewardPointsEarned() {
		return rewardPointsEarned;
	}
	public void setRewardPointsEarned(Integer rewardPointsEarned) {
		this.rewardPointsEarned = rewardPointsEarned;
	}
	public String getRewardsForMonth() {
		return rewardsForMonth;
	}
	public void setRewardsForMonth(String rewardsForMonth) {
		this.rewardsForMonth = rewardsForMonth;
	}
	public String getRewardsForyear() {
		return rewardsForyear;
	}
	public void setRewardsForyear(String rewardsForyear) {
		this.rewardsForyear = rewardsForyear;
	}
	public List<BigDecimal> getRewardPointsPerTx() {
		return rewardPointsPerTx;
	}
	public void setRewardPointsPerTx(List<BigDecimal> rewardPointsPerTx) {
		this.rewardPointsPerTx = rewardPointsPerTx;
	}
	public BigDecimal getRewardPointsTotal() {
		return rewardPointsTotal;
	}
	public void setRewardPointsTotal(BigDecimal rewardPointsTotal) {
		this.rewardPointsTotal = rewardPointsTotal;
	}
	public List<BigDecimal> getAmountPerTx() {
		return amountPerTx;
	}
	public void setAmountPerTx(List<BigDecimal> amountPerTx) {
		this.amountPerTx = amountPerTx;
	}
	
}
