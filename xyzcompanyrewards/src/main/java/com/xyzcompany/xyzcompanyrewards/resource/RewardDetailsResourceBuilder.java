package com.xyzcompany.xyzcompanyrewards.resource;

import java.math.BigDecimal;

public class RewardDetailsResourceBuilder {

	private String customerName;
	private Integer numberOfTransactions;
	private BigDecimal rewardPointsEarned;
	private String rewardsForMonth;
	private String rewardsForyear;
	private BigDecimal transcationAmount;
	
	private RewardDetailsResourceBuilder () {
		
	}
	
	public static RewardDetailsResourceBuilder builder() {
		return new RewardDetailsResourceBuilder();
	}
	
	public RewardDetailsResourceBuilder withCustomerName(String customerName) {
		this.customerName = customerName;
		return this;
	}
	public RewardDetailsResourceBuilder withNumberOfTranscations(Integer numberOfTransactions) {
		this.numberOfTransactions = numberOfTransactions;
		return this;
	}
	
	public RewardDetailsResourceBuilder withRewardPointsEarned(BigDecimal rewardPointsEarned) {
		this.rewardPointsEarned = rewardPointsEarned;
		return this;
	}
	public RewardDetailsResourceBuilder withRewardsForMonth(String rewardsForMonth) {
		this.rewardsForMonth = rewardsForMonth;
		return this;
	}
	public RewardDetailsResourceBuilder withRewardsForyear(String rewardsForyear) {
		this.rewardsForyear = rewardsForyear;
		return this;
	}
	public RewardDetailsResourceBuilder withTranscationAmount(BigDecimal transcationAmount) {
		this.transcationAmount = transcationAmount;
		return this;
	}
	
	public RewardDetailsResource build() {
		return new RewardDetailsResource(customerName, numberOfTransactions, rewardPointsEarned, rewardsForMonth, rewardsForyear, transcationAmount);
	}
}
