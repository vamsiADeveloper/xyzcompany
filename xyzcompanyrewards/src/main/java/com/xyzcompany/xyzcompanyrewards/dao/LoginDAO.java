package com.xyzcompany.xyzcompanyrewards.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginDAO extends CrudRepository<User, Integer>{
	
	User findByUserName(String userName);
}
