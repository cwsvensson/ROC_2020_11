package com.mybank.service.menu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mybank.dao.dbutil.CustomerSearchQueries;
import com.mybank.dao.dbutil.EntranceSearchQueries;
import com.mybank.dao.dbutil.PostgreSqlConnection;
import com.mybank.exception.BankingException;
import com.mybank.model.Customer;
import com.mybank.model.Entrance;
import com.mybank.service.CustomerSearchService;
import com.mybank.service.EntranceSearchService;
import com.mybank.service.impl.CustomerSearchServiceImpl;
import com.mybank.service.impl.EntranceSearchServiceImpl;

public class ReturningLogin {

	public Entrance oldLogin(Scanner scanner) throws BankingException {

		CheckInputs ci = new CheckInputs();
		int cntr = 0;
		String userName="";
		boolean goodLogin = false;
		String userPassword = "";
		List<Entrance> entranceList = new ArrayList<>();
		Entrance snglLogin = new Entrance();
		List<Customer> customerList = new ArrayList<>();
		Customer snglCustomer = new Customer();
		EntranceSearchService entranceSearchService = new EntranceSearchServiceImpl();
		CustomerSearchService customerSearchService = new CustomerSearchServiceImpl();

		while (!goodLogin && cntr <= 5) {
			userName = ci.getStringInput(scanner, "Please enter your user name (7 to 12 characters) > ", 7, 12, 'U');
			if (userName=="") {
				Entrance badInput = new Entrance("bad");
				return badInput;
			}
			Sv.log.debug("Recieved User Name = "+userName);

			userName = ci.fixedLengthString(userName, 12).toUpperCase();

			userPassword = ci.getStringInput(scanner, "Please enter your new password (8 to 15 characters) > ", 8, 15, 'U');
			if (userPassword=="") {
				Entrance badInput = new Entrance("bad");
				return badInput;
			}
			Sv.log.debug("Recieved Password = "+userPassword);

			//  Check for a good login

			try (Connection connection = PostgreSqlConnection.getConnection()) {

				String sql = EntranceSearchQueries.GET_FULL_LOGIN;
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				Sv.log.debug("Returning Customer: sql = " + sql);
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, userName);
				preparedStatement.setString(2, userPassword);

				entranceList = entranceSearchService.getLogins(preparedStatement);
				if (entranceList == null || entranceList.size() == 0) {
					Sv.log.info("No such Account / Password combination.");
					Sv.log.info("Please check type carefully and try again.");
					cntr++;
				} else {
					snglLogin = entranceList.get(0);
					goodLogin = true;	
				}

			} catch (ClassNotFoundException | SQLException e) {
				Sv.log.debug("Error inside EntranceSearchDAOImpl = ",e);
				throw new BankingException("Internal error occurred.. Kindly contact SYSADMIN");
			}
		}

		if (!goodLogin) {
			Sv.log.info("");
			Sv.log.info("Too many attempts - Exiting");
			return null;
		}
		
		OtherMenus om = new OtherMenus();
		Sv.log.info("Welcome " + snglLogin.getLoginUsername());
		
		if (snglLogin.getLoginUserId() == 0) {  // Customer information is not yet on file
			Sv.log.info("");
			Sv.log.info("We still need your personal information before your banking with us.");
			Sv.log.info("");
			snglCustomer = om.newCustomerMenu(scanner, snglLogin);
		} else {
			
			try (Connection connection = PostgreSqlConnection.getConnection()) {

				String sql = CustomerSearchQueries.GET_CUSTOMER_BY_LOGIN;
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				Sv.log.debug("Returning Customer: sql = " + sql);
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setLong(1, snglLogin.getLoginUserId());

				customerList = customerSearchService.getAllCustomers(preparedStatement);
				if (customerList == null || customerList.size() == 0) {
					Sv.log.info("ReturningLogin Error - Required Customer Not Found");
					Sv.log.info("");
				} else {
					snglCustomer = customerList.get(0);
				}

			} catch (ClassNotFoundException | SQLException e) {
				Sv.log.debug("Error inside EntranceSearchDAOImpl = ",e);
				throw new BankingException("Internal error occurred.. Kindly contact SYSADMIN");
			}
		}

		if (snglCustomer != null ) {
			Sv.log.debug("");
			Sv.log.debug("Customer number = "+ snglCustomer.getUserId() +" - Login ID = " + snglLogin.getLoginId());

			Sv.log.debug("snglCustomer.getUserStatus() = " + snglCustomer.getUserStatus());
			om.activeCustomerMenu(scanner, snglCustomer, snglLogin);
		} else {
			return null;
		}

		return snglLogin;
	}
}