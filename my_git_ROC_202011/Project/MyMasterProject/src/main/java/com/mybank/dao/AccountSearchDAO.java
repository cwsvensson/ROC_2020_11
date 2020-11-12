package com.mybank.dao;

import java.sql.PreparedStatement;
import java.util.List;

import com.mybank.exception.BankingException;
import com.mybank.model.Account;

public interface AccountSearchDAO {

	public List<Account> getAllAccounts(PreparedStatement preparedStatement) throws BankingException;
	public int putNewAccount(PreparedStatement preparedStatement) throws BankingException;
	public int updateAcntById(PreparedStatement preparedStatement) throws BankingException;
}