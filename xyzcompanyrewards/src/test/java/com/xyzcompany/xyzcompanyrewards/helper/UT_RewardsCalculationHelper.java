package com.xyzcompany.xyzcompanyrewards.helper;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UT_RewardsCalculationHelper {
	
	@InjectMocks
	RewardsCalculationHelper underTest; 
	
	@Test
	public void testCalculateRewardPointsPerTx()  
	{
		BigDecimal testAmt = new BigDecimal(120);
		BigDecimal result = RewardsCalculationHelper.calculateRewardPointsPerTx(testAmt);
	 
	    //Verify request succeed
	    Assert.assertEquals(new BigDecimal(90), result);
	}
	
	@Test
	public void testCalculateRewardPointsPerTxWhenNull()  
	{
		BigDecimal testAmt = null;
		BigDecimal result = RewardsCalculationHelper.calculateRewardPointsPerTx(testAmt);
	 
	    Assert.assertEquals(BigDecimal.ZERO, result);
	}
	
	@Test
	public void calculateRewardPointsTotal()  
	{
		BigDecimal testReward1 = new BigDecimal(120);
		BigDecimal testReward2 = new BigDecimal(40);
		List<BigDecimal> testRewards = new ArrayList<BigDecimal>();
		testRewards.add(testReward1);
		testRewards.add(testReward2);
		BigDecimal result = RewardsCalculationHelper.calculateRewardPointsTotal(testRewards);
	    Assert.assertEquals(new BigDecimal(160), result);
	}
	
	@Test
	public void calculateRewardPointsTotalWhenNull()  
	{
		BigDecimal result = RewardsCalculationHelper.calculateRewardPointsTotal(null);
	    Assert.assertEquals(BigDecimal.ZERO, result);
	}
}
