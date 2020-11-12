package com.mybank.service.impl;

import java.sql.PreparedStatement;
import java.util.List;

import com.mybank.dao.TransactionSearchDAO;
import com.mybank.dao.impl.TransactionSearchDAOImpl;
import com.mybank.exception.BankingException;
import com.mybank.model.Transaction;
import com.mybank.service.TransactionSearchService;

public class TransactionSearchServiceImpl implements TransactionSearchService {

	private TransactionSearchDAO searchDAO = new TransactionSearchDAOImpl();
	
	@Override
	public List<Transaction> getAllTransactions(PreparedStatement preparedStatement) throws BankingException {
		List<Transaction> transactionList = null;
		transactionList = searchDAO.getAllTransactions(preparedStatement);

		return transactionList;
	}

}
