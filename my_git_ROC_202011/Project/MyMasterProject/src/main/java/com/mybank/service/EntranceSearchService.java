package com.mybank.service;

import java.sql.PreparedStatement;
import java.util.List;

import com.mybank.exception.BankingException;
import com.mybank.model.Entrance;

public interface EntranceSearchService {
	
	public List<Entrance> getLogins(PreparedStatement preparedStatement) throws BankingException;
	public int addNewLogin(PreparedStatement preparedStatement) throws BankingException;
	public int updateLoginWithCustomer(PreparedStatement preparedStatement) throws BankingException;
	
}