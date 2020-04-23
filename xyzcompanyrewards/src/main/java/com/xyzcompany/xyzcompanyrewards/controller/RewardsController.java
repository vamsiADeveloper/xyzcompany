package com.xyzcompany.xyzcompanyrewards.controller;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.management.RuntimeErrorException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xyzcompany.xyzcompanyrewards.model.UserMonthlyStatementData;
import com.xyzcompany.xyzcompanyrewards.resource.RewardDetailsResource;
import com.xyzcompany.xyzcompanyrewards.service.RewardDetailsService;


@Controller
public class RewardsController {

	private Log logger = LogFactory.getLog(RewardsController.class);
	
	@Autowired
	RewardDetailsService rewardDetailsService;
	
	@RequestMapping(value="/rewardDetails/{userName:.+}", method = RequestMethod.GET)
	public String rewardDetails(HttpServletRequest request, HttpServletResponse response, ModelMap mp,
			@PathVariable("userName") String userName) throws Exception {
		Boolean isAuthenticated = (Boolean) request.getSession().getAttribute("isAuthenticated");
		
		if (isAuthenticated != null && isAuthenticated) {
			logger.info(userName);
			List<RewardDetailsResource> rewardDetailsList  = rewardDetailsService.getRewardDetaislOfAllCustomers();
			Set<String> customerNames = (rewardDetailsList!= null && !rewardDetailsList.isEmpty()) ? rewardDetailsList.stream().map(RewardDetailsResource::getCustomerName).collect(Collectors.toSet()): null;
			mp.addAttribute("customerNames", customerNames );
			mp.addAttribute("rewardDetailsList", rewardDetailsList );
			return "rewardDetails";
		}
			logger.error("Invalid access to the rewards page");
			return "redirect:/home";
	}
	
	
	@RequestMapping(value="/customerRewardDetails/{userName:.+}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<RewardDetailsResource>> rewardDetailsJson(HttpServletRequest request, HttpServletResponse response, ModelMap mp,
			@PathVariable("userName") String userName) throws Exception {
		
			logger.info(userName);
			List<RewardDetailsResource> rewardDetailsList  = rewardDetailsService.getRewardDetails(userName);
			if (rewardDetailsList != null && !rewardDetailsList.isEmpty()) {
				return ResponseEntity.status(HttpStatus.OK)
				        .body(rewardDetailsList);
			}
			logger.error("Invalid access to the rewards page");
			return ResponseEntity.status(HttpStatus.NO_CONTENT)
			        .body(null);
	}
	
	@RequestMapping(value="/eomSummary" , method = RequestMethod.GET)
	public String account(ModelMap mp,@RequestParam("customerName") String customerName, @RequestParam("rewardsMonth") String rewardsMonth) throws Exception {
		UserMonthlyStatementData eomData = rewardDetailsService.getSpecificEomData(customerName, rewardsMonth);
		mp.addAttribute("customerName", customerName );
		mp.addAttribute("rewardsMonth", rewardsMonth );
		mp.addAttribute("eomData", eomData );
		return "eomDetails";
	}

}
