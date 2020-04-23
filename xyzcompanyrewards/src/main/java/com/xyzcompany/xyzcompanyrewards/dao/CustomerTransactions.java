package com.xyzcompany.xyzcompanyrewards.dao;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="customer_transactions")
public class CustomerTransactions {
	
	@Id
	@GeneratedValue
	private Integer customerTransactionId;
	
	@Column(name="customer_name", nullable=false)
	private String customerName;
	
	@Column(name="transactions_for_month", nullable=false)
	private String transactionsForMonth;

	@Column(name="transactions_for_year", nullable=false)
	private String transactionsForYear;

	@Column(name="transaction_amt", nullable=false)
	private BigDecimal transactionAmount;

	public Integer getCustomerTransactionId() {
		return customerTransactionId;
	}

	public void setCustomerTransactionId(Integer customerTransactionId) {
		this.customerTransactionId = customerTransactionId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getTransactionsForMonth() {
		return transactionsForMonth;
	}

	public void setTransactionsForMonth(String transactionsForMonth) {
		this.transactionsForMonth = transactionsForMonth;
	}

	public String getTransactionsForYear() {
		return transactionsForYear;
	}

	public void setTransactionsForYear(String transactionsForYear) {
		this.transactionsForYear = transactionsForYear;
	}

	public BigDecimal getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(BigDecimal transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customerTransactionId == null) ? 0 : customerTransactionId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerTransactions other = (CustomerTransactions) obj;
		if (customerTransactionId == null) {
			if (other.customerTransactionId != null)
				return false;
		} else if (!customerTransactionId.equals(other.customerTransactionId))
			return false;
		return true;
	}
	

	
}
