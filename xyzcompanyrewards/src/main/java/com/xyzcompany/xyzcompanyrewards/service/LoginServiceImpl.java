package com.xyzcompany.xyzcompanyrewards.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.xyzcompany.xyzcompanyrewards.dao.LoginDAO;
import com.xyzcompany.xyzcompanyrewards.dao.User;

@Component
public class LoginServiceImpl implements LoginService{

	@Autowired 
	LoginDAO loginDao;
	
	@Override
	public boolean checkLoginCredentials(String userName, String pwd)
			throws Exception {
		if (!StringUtils.isEmpty(userName) && !StringUtils.isEmpty(pwd)  ) {
			User user = loginDao.findByUserName(userName);
			return (user.getUserName().equalsIgnoreCase(userName) 
						&& user.getPassword().equalsIgnoreCase(pwd));
		} 
		
		return false;
	}
}
