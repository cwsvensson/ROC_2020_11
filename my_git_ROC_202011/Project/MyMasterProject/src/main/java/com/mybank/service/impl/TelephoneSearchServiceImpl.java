package com.mybank.service.impl;

import java.sql.PreparedStatement;
import java.util.List;

import com.mybank.dao.TelephoneSearchDAO;
import com.mybank.dao.impl.TelephoneSearchDAOImpl;
import com.mybank.exception.BankingException;
import com.mybank.model.Telephone;
import com.mybank.service.TelephoneSearchService;

public class TelephoneSearchServiceImpl implements TelephoneSearchService {

	private TelephoneSearchDAO searchDAO = new TelephoneSearchDAOImpl();
	
	@Override
	public List<Telephone> getAllTelephones(PreparedStatement preparedStatement) throws BankingException {
		List<Telephone> telephoneList = null;
		telephoneList = searchDAO.getAllTelephones(preparedStatement);

		return telephoneList;
	}

}
