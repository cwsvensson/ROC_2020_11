package com.mybank.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mybank.dao.TelephoneSearchDAO;
import com.mybank.dao.dbutil.TelephoneStatics;
import com.mybank.exception.BankingException;
import com.mybank.model.Telephone;
import com.mybank.service.menu.Sv;

public class TelephoneSearchDAOImpl implements TelephoneSearchDAO {

	@Override
	public List<Telephone> getAllTelephones(PreparedStatement preparedStatement) throws BankingException {
		
		List<Telephone> telephoneList = new ArrayList<>();
		
		try {
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Telephone telephone = new Telephone(resultSet.getInt(TelephoneStatics.T4F1), resultSet.getLong(TelephoneStatics.T4F2),
						resultSet.getString(TelephoneStatics.T4F3), resultSet.getString(TelephoneStatics.T4F4),
						resultSet.getDate(TelephoneStatics.T4F5) );
				telephoneList.add(telephone);
			}
			if(telephoneList.size()==0) {
				throw new BankingException("No Login Records Available");
			}

		} catch (SQLException e) {
			Sv.log.debug("Error inside EntranceSearchDAOImpl = ",e);
			throw new BankingException("Internal error occurred.. Kindly contact SYSADMIN");

		}
		return telephoneList;
	}
}