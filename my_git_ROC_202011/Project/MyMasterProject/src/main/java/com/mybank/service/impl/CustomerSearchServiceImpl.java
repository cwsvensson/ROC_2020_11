package com.mybank.service.impl;

import java.sql.PreparedStatement;
import java.util.List;

import com.mybank.dao.CustomerSearchDAO;
import com.mybank.dao.impl.CustomerSearchDAOImpl;
import com.mybank.exception.BankingException;
import com.mybank.model.Customer;
import com.mybank.service.CustomerSearchService;

public class CustomerSearchServiceImpl implements CustomerSearchService {

	private CustomerSearchDAO searchDAO = new CustomerSearchDAOImpl();

	@Override
	public List<Customer> getAllCustomers(PreparedStatement preparedStatement) throws BankingException {
		List<Customer> customerList = null;
		customerList = searchDAO.getAllCustomers(preparedStatement);

		return customerList;
	}

	@Override
	public int addNewCustomer(PreparedStatement preparedStatement) throws BankingException {
		int addCnt = searchDAO.addNewCustomer(preparedStatement);
		return addCnt;
	}
}