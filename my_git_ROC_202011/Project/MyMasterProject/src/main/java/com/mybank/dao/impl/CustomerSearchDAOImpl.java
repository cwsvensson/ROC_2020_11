package com.mybank.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mybank.dao.CustomerSearchDAO;
import com.mybank.dao.dbutil.CustomerStatics;
import com.mybank.exception.BankingException;
import com.mybank.model.Customer;
import com.mybank.service.menu.Sv;

public class CustomerSearchDAOImpl implements CustomerSearchDAO {

	@Override
	public List<Customer> getAllCustomers(PreparedStatement preparedStatement) throws BankingException {
		List<Customer> customerList = new ArrayList<>();
		
		try {
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				Customer customer = new Customer(resultSet.getInt(CustomerStatics.T1F1), resultSet.getString(CustomerStatics.T1F2),
						resultSet.getString(CustomerStatics.T1F3), resultSet.getString(CustomerStatics.T1F4),
						resultSet.getString(CustomerStatics.T1F5), resultSet.getString(CustomerStatics.T1F6),
						resultSet.getString(CustomerStatics.T1F7), resultSet.getString(CustomerStatics.T1F8),
						resultSet.getString(CustomerStatics.T1F9), resultSet.getDate(CustomerStatics.T1F10) );
				customerList.add(customer);
			}
			
			if(customerList.size()==0) {
				throw new BankingException("No Customer Records Available");
			}
			
		} catch (SQLException e) {
			Sv.log.debug("Error inside CustomerSearchDAOImpl = ",e);
			throw new BankingException("Internal error occured.. Kindly contact SYSADMIN");
		}
		return customerList;
	}

	@Override
	public int addNewCustomer(PreparedStatement preparedStatement) throws BankingException {
		int addCnt = 0;
	
		try {
			addCnt = preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			Sv.log.debug("Error inside EntranceSearchDAOImpl = ",e);
			throw new BankingException("Internal error occurred.. Kindly contact SYSADMIN");
		}
	
		return addCnt;
	}
}