package com.mybank.dao;

import java.sql.PreparedStatement;
import java.util.List;

import com.mybank.exception.BankingException;
import com.mybank.model.Transaction;

public interface TransactionSearchDAO {
	
	public List<Transaction> getAllTransactions(PreparedStatement preparedStatement) throws BankingException;

}