package com.mybank.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mybank.dao.EntranceSearchDAO;
import com.mybank.exception.BankingException;
import com.mybank.model.Entrance;
import com.mybank.service.menu.Sv;

public class EntranceSearchDAOImpl implements EntranceSearchDAO {

	@Override
	public List<Entrance> getLogins(PreparedStatement preparedStatement) throws BankingException {
		
		List<Entrance> entranceList = new ArrayList<>();
		
		try {
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Entrance entrance = new Entrance(resultSet.getInt("login_id"), resultSet.getString("login_username"), resultSet.getString("login_password"),
						                         resultSet.getLong("login_user_id"), resultSet.getDate("login_creation"), resultSet.getDate("login_lastlogin") );
				entranceList.add(entrance);
			}

		} catch (SQLException e) {
			Sv.log.debug("Error inside EntranceSearchDAOImpl = ",e);
			throw new BankingException("Internal error occurred.. Kindly contact SYSADMIN");

		}
		return entranceList;
	}

	@Override
	public int addNewLogin(PreparedStatement preparedStatement) throws BankingException {
		int addCnt = 0;
		
		try {
			addCnt = preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			Sv.log.debug("Error inside EntranceSearchDAOImpl = ",e);
			throw new BankingException("Internal error occurred.. Kindly contact SYSADMIN");
		}
		
		return addCnt;
	}

	@Override
	public int updateLoginWithCustomer(PreparedStatement preparedStatement) throws BankingException {
       int updateCnt = 0;
		
		try {
			updateCnt = preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			Sv.log.debug("Error inside EntranceSearchDAOImpl = ",e);
			throw new BankingException("Internal error occurred.. Kindly contact SYSADMIN");
		}
		
		return updateCnt;
	}
}