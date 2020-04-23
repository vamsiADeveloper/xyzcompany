package com.xyzcompany.xyzcompanyrewards.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.xyzcompany.xyzcompanyrewards.model.UserMonthlyStatementData;
import com.xyzcompany.xyzcompanyrewards.resource.RewardDetailsResource;


@Service
public interface RewardDetailsService {

	List<RewardDetailsResource> getRewardDetaislOfAllCustomers();
	List<RewardDetailsResource> getRewardDetails(String customerName);
	UserMonthlyStatementData getSpecificEomData(String customerName, String rewardsMonth);
}
