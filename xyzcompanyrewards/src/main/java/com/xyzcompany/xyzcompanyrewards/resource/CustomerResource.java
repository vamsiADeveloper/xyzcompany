package com.xyzcompany.xyzcompanyrewards.resource;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CustomerResource implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String customerName;
	private List<RewardDetailsResource> rewardDetailsList;
	
	@JsonCreator
	public CustomerResource(@JsonProperty("customerName") String customerName,
			@JsonProperty("rewardDetailsList") List<RewardDetailsResource> rewardDetailsList) {
		
		this.customerName = customerName;
		this.rewardDetailsList = rewardDetailsList;
	}

	public String getCustomerName() {
		return customerName;
	}


	public List<RewardDetailsResource> getRewardDetailsList() {
		return rewardDetailsList;
	}


}
