package com.mybank.dao;

import java.sql.PreparedStatement;
import java.util.List;

import com.mybank.exception.BankingException;
import com.mybank.model.Telephone;

public interface TelephoneSearchDAO {
	
	public List<Telephone> getAllTelephones(PreparedStatement preparedStatement) throws BankingException;

}