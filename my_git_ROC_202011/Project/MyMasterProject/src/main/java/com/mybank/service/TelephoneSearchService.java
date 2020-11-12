package com.mybank.service;

import java.sql.PreparedStatement;
import java.util.List;

import com.mybank.exception.BankingException;
import com.mybank.model.Telephone;

public interface TelephoneSearchService {

	public List<Telephone> getAllTelephones(PreparedStatement preparedStatement) throws BankingException;
}