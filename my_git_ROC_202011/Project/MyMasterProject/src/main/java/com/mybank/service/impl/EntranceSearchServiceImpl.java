package com.mybank.service.impl;

import java.sql.PreparedStatement;
import java.util.List;

import com.mybank.dao.EntranceSearchDAO;
import com.mybank.dao.impl.EntranceSearchDAOImpl;
import com.mybank.exception.BankingException;
import com.mybank.model.Entrance;
import com.mybank.service.EntranceSearchService;

public class EntranceSearchServiceImpl implements EntranceSearchService {

	private EntranceSearchDAO searchDAO = new EntranceSearchDAOImpl();
	
	@Override
	public List<Entrance> getLogins(PreparedStatement preparedStatement) throws BankingException {
		
		List<Entrance> entranceList = null;
		entranceList = searchDAO.getLogins(preparedStatement);
		return entranceList;
	}

	@Override
	public int addNewLogin(PreparedStatement preparedStatement) throws BankingException {
		int addCnt = searchDAO.addNewLogin(preparedStatement);
		return addCnt;
	}

	@Override
	public int updateLoginWithCustomer(PreparedStatement preparedStatement) throws BankingException {
		int addCnt = searchDAO.updateLoginWithCustomer(preparedStatement);
		return addCnt;
	}
}