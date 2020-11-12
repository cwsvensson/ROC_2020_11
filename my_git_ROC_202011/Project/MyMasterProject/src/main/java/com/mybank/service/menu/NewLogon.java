package com.mybank.service.menu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mybank.dao.dbutil.EntranceSearchQueries;
import com.mybank.dao.dbutil.PostgreSqlConnection;
import com.mybank.exception.BankingException;
import com.mybank.model.Customer;
import com.mybank.model.Entrance;
import com.mybank.service.EntranceSearchService;
import com.mybank.service.impl.EntranceSearchServiceImpl;

public class NewLogon {

	public Entrance makeNewLogin(Scanner scanner) throws BankingException {

		CheckInputs ci = new CheckInputs();
		String userName="";
		boolean goodNewUserName = false;
		boolean goodLogin = false;
		String userPassword = "";
		List<Entrance> entranceList = new ArrayList<>();
		Entrance snglLogin = new Entrance();
		EntranceSearchService entranceSearchService = new EntranceSearchServiceImpl();

		while (!goodNewUserName ) {
			userName = ci.getStringInput(scanner, "Please enter your new user name (7 to 12 characters) > ", 7, 12, 'U');
			if (userName==null) {
				Entrance badInput = new Entrance("bad");
				return badInput;
			}

			Sv.log.debug("Recieved User Name = "+userName);
			userName = ci.fixedLengthString(userName, 12).toUpperCase();

			try (Connection connection = PostgreSqlConnection.getConnection()) {
				String sql = EntranceSearchQueries.GET_LOGIN_BY_USERNAME;
				Sv.log.debug("sql = " + sql);
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, userName);

				entranceList = entranceSearchService.getLogins(preparedStatement);

			} catch (ClassNotFoundException | SQLException e) {
				Sv.log.debug("Error inside EntranceSearchDAOImpl = ",e);
				throw new BankingException("Internal error occurred.. Kindly contact SYSADMIN");
			}
			
			if (entranceList!=null) {
				Sv.log.debug("Size of List returned = " + entranceList.size());	
			}

			if(entranceList!=null && entranceList.size()>0) {  // A login with this user name already exists
				Sv.log.info("I'm sorry, but that username is already taken.  Please try a new one.");
			} else {
				goodNewUserName = true;
			}

			if (goodNewUserName) {
				userPassword = ci.getStringInput(scanner, "Please enter your new password (8 to 15 characters) > ", 8, 15, 'U');
				if (userPassword=="            ") {
					Entrance badInput = new Entrance("bad");
					return badInput;
				}
			}
			Sv.log.debug("Recieved Password = "+userPassword);
		}

		//  Make a new Login in the Entrance Table

		try (Connection connection = PostgreSqlConnection.getConnection()) {
			String sql = EntranceSearchQueries.CREATE_NEW_LOGIN;
			Sv.log.debug("sql = " + sql);
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, userName);
			preparedStatement.setString(2, userPassword);
			preparedStatement.setNull(3,0);
			int addCnt = entranceSearchService.addNewLogin(preparedStatement);

			if (addCnt != 1) {
				Sv.log.warn("Warning from NewLogin - Add to entrance = "+addCnt+"and not 1");
				throw new BankingException("Internal error occurred.. Kindly contact SYSADMIN");
			}
			
			sql = EntranceSearchQueries.GET_LOGIN_BY_USERNAME;
			Sv.log.debug("sql = " + sql);
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, userName);

			entranceList = entranceSearchService.getLogins(preparedStatement);
			if (entranceList == null) {
				Sv.log.fatal("Logical Error - Null list for new user login in NewLogin = ");
				throw new BankingException("Internal error occurred.. Kindly contact SYSADMIN");
			}
			if (entranceList.size() != 1) {
				Sv.log.fatal("Logical Error - Large list for new user login in NewLogin = ");
				throw new BankingException("Internal error occurred.. Kindly contact SYSADMIN");
			}
			
			snglLogin = entranceList.get(0);
			goodLogin = true;

		} catch (ClassNotFoundException | SQLException e) {
			Sv.log.debug("Error inside EntranceSearchDAOImpl = ",e);
			throw new BankingException("Internal error occurred.. Kindly contact SYSADMIN");
		}

		if (goodLogin) {
			Sv.log.info("");
			Sv.log.info("Welcome " + snglLogin.getLoginUsername());
			Sv.log.info("Let's get started with some information about you");
		}
		
		OtherMenus om = new OtherMenus();
		Customer validCustomer = om.newCustomerMenu(scanner, snglLogin);
		
		Sv.log.debug("");
		//Sv.log.debug("Customer number = "+ validCustomer.getUserId() +"Login ID = " + snglLogin.getLoginId());
		
		om.activeCustomerMenu(scanner, validCustomer, snglLogin);
		
		return snglLogin;
	}
}