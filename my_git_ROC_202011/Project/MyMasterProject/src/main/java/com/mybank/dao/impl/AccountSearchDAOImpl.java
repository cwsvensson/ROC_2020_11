package com.mybank.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mybank.dao.AccountSearchDAO;
import com.mybank.dao.dbutil.AccountStatics;
import com.mybank.exception.BankingException;
import com.mybank.model.Account;
import com.mybank.service.menu.Sv;

public class AccountSearchDAOImpl implements AccountSearchDAO {

	@Override
	public List<Account> getAllAccounts(PreparedStatement preparedStatement) throws BankingException {

		List<Account> accountList = new ArrayList<>();
		
		try {
			
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Sv.log.debug("AccountStatics.T3F5 = " + AccountStatics.T3F5);
				Account account = new Account(resultSet.getLong(AccountStatics.T3F1), resultSet.getString(AccountStatics.T3F2),
						resultSet.getInt(AccountStatics.T3F3), resultSet.getString(AccountStatics.T3F4),
						resultSet.getBigDecimal(AccountStatics.T3F5), resultSet.getDate(AccountStatics.T3F6) );
				accountList.add(account);
			}
			if(accountList.size()==0) {
				throw new BankingException("No Customer Records Available");
			}

		} catch (SQLException e) {
			Sv.log.debug("Error inside AccountSearchDAOImpl = ",e);
			throw new BankingException("Internal error occurred.. Kindly contact SYSADMIN");


		}
		return accountList;
	}

	@Override
	public int putNewAccount(PreparedStatement preparedStatement) throws BankingException {
		int addCnt = 0;
	
		try {
			addCnt = preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			Sv.log.debug("Error inside AccountSearchDAOImpl = ",e);
			throw new BankingException("Internal error occurred.. Kindly contact SYSADMIN");
		}
		
		return addCnt;
	}

	@Override
	public int updateAcntById(PreparedStatement preparedStatement) throws BankingException {
		
			int updCnt = 0;
		
			try {
				updCnt = preparedStatement.executeUpdate();
				
			} catch (SQLException e) {
				Sv.log.debug("Error inside AccountSearchDAOImpl = ",e);
				throw new BankingException("Internal error occurred.. Kindly contact SYSADMIN");
			}
			
			return updCnt;
	}
}