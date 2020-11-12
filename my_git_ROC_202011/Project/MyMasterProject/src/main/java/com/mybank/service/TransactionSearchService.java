package com.mybank.service;

import java.sql.PreparedStatement;
import java.util.List;

import com.mybank.exception.BankingException;
import com.mybank.model.Transaction;

public interface TransactionSearchService {
	
	public List<Transaction> getAllTransactions(PreparedStatement preparedStatement) throws BankingException;
}