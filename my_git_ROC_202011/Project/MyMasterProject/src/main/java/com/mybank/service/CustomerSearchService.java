package com.mybank.service;

import java.sql.PreparedStatement;
import java.util.List;

import com.mybank.exception.BankingException;
import com.mybank.model.Customer;

public interface CustomerSearchService {
	
	public List<Customer> getAllCustomers(PreparedStatement preparedStatement) throws BankingException;
	public int addNewCustomer(PreparedStatement preparedStatement) throws BankingException;
}