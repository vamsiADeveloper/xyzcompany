package com.xyzcompany.xyzcompanyrewards.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerTransactionsDAO extends CrudRepository<CustomerTransactions, Integer>{
	
	List<CustomerTransactions> findAll();
	List<CustomerTransactions> findByCustomerName(String customerName);
	List<CustomerTransactions> findByCustomerNameAndTransactionsForMonth(String customerName, String transactionsForMonth);

}
