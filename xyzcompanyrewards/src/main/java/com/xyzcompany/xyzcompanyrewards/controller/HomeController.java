package com.xyzcompany.xyzcompanyrewards.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xyzcompany.xyzcompanyrewards.model.JsonResponse;
import com.xyzcompany.xyzcompanyrewards.dao.User;
import com.xyzcompany.xyzcompanyrewards.service.LoginService;


@Controller
public class HomeController {
	
	@Autowired
	LoginService loginService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcome(ModelMap mp) {
		return "redirect:home";
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(ModelMap mp) {
		return "home";
	}
	
	@RequestMapping(value="/login" , method = RequestMethod.GET)
	@ResponseBody
	public JsonResponse login (@ModelAttribute User user, BindingResult result , HttpSession session) throws Exception {
		JsonResponse jResponse = new JsonResponse();
		boolean isAuthenticated = loginService.checkLoginCredentials(user.getUserName(), user.getPassword());
		jResponse.setAuthenticated(isAuthenticated);
		jResponse.setUserName(user.getUserName());
		session.setAttribute("isAuthenticated", isAuthenticated);
		return jResponse;
	}
	
}
