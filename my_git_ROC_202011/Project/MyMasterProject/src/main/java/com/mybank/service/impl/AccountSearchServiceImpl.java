package com.mybank.service.impl;

import java.sql.PreparedStatement;
import java.util.List;

import com.mybank.dao.AccountSearchDAO;
import com.mybank.dao.impl.AccountSearchDAOImpl;
import com.mybank.exception.BankingException;
import com.mybank.model.Account;
import com.mybank.service.AccountSearchService;

public class AccountSearchServiceImpl implements AccountSearchService {
	
	private AccountSearchDAO searchDAO = new AccountSearchDAOImpl();

	@Override
	public List<Account> getAllAccounts(PreparedStatement preparedStatement) throws BankingException {
		List<Account> accountList = null;
		accountList = searchDAO.getAllAccounts(preparedStatement);

		return accountList;
	}

	@Override
	public int putNewAccount(PreparedStatement preparedStatement) throws BankingException {
		int addCnt = searchDAO.putNewAccount(preparedStatement);
		return addCnt;
	}

	@Override
	public int updateAcntById(PreparedStatement preparedStatement) throws BankingException {
		int updCnt = searchDAO.updateAcntById(preparedStatement);
		return updCnt;
	}
}