package com.xyzcompany.xyzcompanyrewards.resource;

import java.util.List;

public class CustomerResourceBuilder {
	
	private String customerName;
	private List<RewardDetailsResource> rewardDetailsList;

private CustomerResourceBuilder () {
		
	}
	
	public static CustomerResourceBuilder builder() {
		return new CustomerResourceBuilder();
	}
	
	public CustomerResourceBuilder withCustomerName(String customerName) {
		this.customerName = customerName;
		return this;
	}
	
	public CustomerResourceBuilder withRewardDetailsList(List<RewardDetailsResource> rewardDetailsList) {
		this.rewardDetailsList = rewardDetailsList;
		return this;
	}
	
	public CustomerResource build() {
		return new CustomerResource(customerName, rewardDetailsList);
	}
}
