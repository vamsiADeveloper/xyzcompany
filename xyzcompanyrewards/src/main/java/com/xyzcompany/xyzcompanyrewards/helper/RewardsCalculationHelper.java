package com.xyzcompany.xyzcompanyrewards.helper;

import java.math.BigDecimal;
import java.util.List;

public class RewardsCalculationHelper {
	
	public static BigDecimal calculateRewardPointsPerTx(BigDecimal totalTxAmt) {
		BigDecimal rewardpoints = BigDecimal.ZERO;
		if (totalTxAmt != null) {
			if (totalTxAmt.compareTo(new BigDecimal(50)) > 0 && totalTxAmt.compareTo(new BigDecimal(100)) <= 0) {
				 rewardpoints = totalTxAmt.subtract(new BigDecimal(50));
				}
			if (totalTxAmt.compareTo(new BigDecimal(100)) > 0) {
			 rewardpoints = totalTxAmt.subtract(new BigDecimal(100)).multiply(new BigDecimal(2));
			}
			if (totalTxAmt.compareTo(new BigDecimal(100)) > 0 && totalTxAmt.compareTo(new BigDecimal(50)) >= 0) {
			 rewardpoints = rewardpoints.add(new BigDecimal(50));
			}
		}
		return rewardpoints;
	}
	
	
	
	public static BigDecimal calculateRewardPointsTotal(List<BigDecimal> rewardPointsPerTxList) {
		BigDecimal totalRewardPoint = BigDecimal.ZERO;
		if (rewardPointsPerTxList != null && !rewardPointsPerTxList.isEmpty()) {
			for (BigDecimal amt:rewardPointsPerTxList) {
				totalRewardPoint = totalRewardPoint.add(amt);
			}
		}
		return totalRewardPoint;
		
	}


}
