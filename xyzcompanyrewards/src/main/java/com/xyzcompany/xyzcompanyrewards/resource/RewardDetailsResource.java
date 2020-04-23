package com.xyzcompany.xyzcompanyrewards.resource;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RewardDetailsResource implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String customerName;
	private Integer numberOfTransactions;
	private BigDecimal rewardPointsEarned;
	private String rewardsForMonth;
	private String rewardsForyear;
	private BigDecimal rewardAmount;
	
	@JsonCreator
	public RewardDetailsResource(@JsonProperty("customerName") String customerName,
			@JsonProperty("numberOfTransactions") Integer numberOfTransactions,
			@JsonProperty("rewardPointsEarned") BigDecimal rewardPointsEarned,
			@JsonProperty("rewardsForMonth") String rewardsForMonth,
			@JsonProperty("rewardsForyear") String rewardsForyear,
			@JsonProperty("rewardAmount") BigDecimal rewardAmount) {
		
		this.customerName = customerName;
		this.numberOfTransactions = numberOfTransactions;
		this.rewardPointsEarned = rewardPointsEarned;
		this.rewardsForMonth = rewardsForMonth;
		this.rewardsForyear = rewardsForyear;
		this.rewardAmount = rewardAmount;
	}

	public String getCustomerName() {
		return customerName;
	}

	public Integer getNumberOfTransactions() {
		return numberOfTransactions;
	}

	public BigDecimal getRewardPointsEarned() {
		return rewardPointsEarned;
	}

	public String getRewardsForMonth() {
		return rewardsForMonth;
	}

	public String getRewardsForyear() {
		return rewardsForyear;
	}

	public BigDecimal getRewardAmount() {
		return rewardAmount;
	}
	
	

}
