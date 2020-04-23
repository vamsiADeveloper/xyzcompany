package com.xyzcompany.xyzcompanyrewards.service;

import org.springframework.stereotype.Service;

@Service
public interface LoginService {

	boolean checkLoginCredentials(String userName, String pwd) throws Exception;
}
