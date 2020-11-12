package com.mybank.service.menu;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mybank.dao.dbutil.AccountSearchQueries;
import com.mybank.dao.dbutil.CustomerSearchQueries;
import com.mybank.dao.dbutil.EntranceSearchQueries;
import com.mybank.dao.dbutil.PostgreSqlConnection;
import com.mybank.exception.BankingException;
import com.mybank.model.Account;
import com.mybank.model.Customer;
import com.mybank.model.Entrance;
import com.mybank.service.AccountSearchService;
import com.mybank.service.CustomerSearchService;
import com.mybank.service.impl.AccountSearchServiceImpl;
import com.mybank.service.impl.CustomerSearchServiceImpl;

public class OtherMenus {

	public Customer newCustomerMenu(Scanner scanner, Entrance uLogin) throws BankingException {
		
		CheckInputs ci = new CheckInputs();
		Customer cust = new Customer();
		boolean chain = true;
		String checkedString = null;
		String msg = "";
		CustomerSearchService customerSearchService = new CustomerSearchServiceImpl();
		
		try {
			msg = "Please enter your first name > ";	// First Name
			checkedString = ci.getStringInput(scanner, msg, 1, 22, 'A');
			if (checkedString == null) {
				Sv.log.info("Perhaps another time...");
				chain = false;
			}

			if (chain) {
				cust.setUserFName(checkedString);		// Middle Initial
				msg = "(Optional) Please enter a middle initial > ";
				checkedString = ci.getStringInput(scanner, msg, 0, 1, 'A');
				if (checkedString == null) {
					checkedString = " ";
				}
				cust.setUserInitial(checkedString);
			}

			if (chain) {
				msg = "Please enter your last name > ";
				checkedString = ci.getStringInput(scanner, msg, 2, 28, 'A');
				if (checkedString == null) {
					Sv.log.info("Perhaps another time...");
					chain = false;
				}
			}

			if (chain) {
				cust.setUserLName(checkedString);
				msg = "Please enter your street address > ";
				checkedString = ci.getStringInput(scanner, msg, 2, 36, 'U');
				if (checkedString == null) {
					Sv.log.info("Perhaps another time...");
					chain = false;
				}
			}

			if (chain) {
				cust.setUserStreet(checkedString);
				msg = "Please enter your city / town > ";
				checkedString = ci.getStringInput(scanner, msg, 2, 27, 'A');
				if (checkedString == null) {
					Sv.log.info("Perhaps another time...");
					chain = false;
				}
			}
			if (chain) {
				cust.setUserCity(checkedString);
				msg = "Please enter your state code > ";
				checkedString = ci.getStringInput(scanner, msg, 2, 2, 'A');
				if (checkedString == null) {
					Sv.log.info("Perhaps another time...");
					chain = false;
				}
			}
			if (chain) {
				cust.setUserState(checkedString);
				msg = "Please enter your zip code > ";
				checkedString = ci.getStringInput(scanner, msg, 5, 9, 'N');
				if (checkedString == null) {
					Sv.log.info("Perhaps another time...");
					chain = false;
				}
			}

			if (chain) {
				cust.setUserZipCode(checkedString);
				cust.setUserStatus("P");

				try (Connection connection = PostgreSqlConnection.getConnection()) {
					String sql = CustomerSearchQueries.CREATE_NEW_CUSTOMER;
					Sv.log.debug("sql = " + sql);
					PreparedStatement preparedStatement = connection.prepareStatement(sql);
					preparedStatement.setString(1, cust.getUserStatus());
					preparedStatement.setString(2, cust.getUserFName());
					preparedStatement.setString(3, cust.getUserInitial());
					preparedStatement.setString(4, cust.getUserLName());
					preparedStatement.setString(5, cust.getUserStreet());
					preparedStatement.setString(6, cust.getUserCity());
					preparedStatement.setString(7, cust.getUserState());
					preparedStatement.setString(8, cust.getUserZipCode());

					int addCnt = customerSearchService.addNewCustomer(preparedStatement);

					if (addCnt != 1) {
						Sv.log.warn("Warning from NewLogin - Add to entrance = "+addCnt+"and not 1");
						throw new BankingException("Internal error occurred.. Kindly contact SYSADMIN");
					}
					
					sql = CustomerSearchQueries.READ_BACK_CUSTOMER;
					Sv.log.debug("sql = " + sql);
					preparedStatement = connection.prepareStatement(sql);
					preparedStatement.setString(1, cust.getUserStatus());
					preparedStatement.setString(2, cust.getUserFName());
					preparedStatement.setString(3, cust.getUserInitial());
					preparedStatement.setString(4, cust.getUserLName());
					preparedStatement.setString(5, cust.getUserStreet());
					preparedStatement.setString(6, cust.getUserCity());
					preparedStatement.setString(7, cust.getUserState());
					preparedStatement.setString(8, cust.getUserZipCode());
					
					List<Customer> customerList = customerSearchService.getAllCustomers(preparedStatement);

					if(customerList!=null && customerList.size()!=1) {
						if(customerList!=null) {
							Sv.log.fatal("customerList.size() = " + customerList.size());
						}
						Sv.log.fatal("Fatal from OtherMenus - Only 1 new customer should be returned");
						throw new BankingException("Internal error occurred.. Kindly contact SYSADMIN");
					}
					cust = customerList.get(0);

					Sv.log.info("Thank you, your user information is stored.");
					Sv.log.debug("Updating login link to the new customer.");

					uLogin.setLoginUserId(cust.getUserId());
					Sv.log.debug("Login userID "+ uLogin.getLoginId() +" is being set to customerID = "+ cust.getUserId());

					sql = EntranceSearchQueries.LINK_ENTRANCE_TO_CUSTOMER;
					Sv.log.debug("sql = " + sql);
					preparedStatement = connection.prepareStatement(sql);
					preparedStatement.setLong(1, uLogin.getLoginUserId());
					preparedStatement.setLong(2, uLogin.getLoginId());

					int updCnt = customerSearchService.addNewCustomer(preparedStatement);

					if (updCnt != 1) {
						Sv.log.warn("Warning from NewLogin - Add to entrance = "+updCnt+"and not 1");
						throw new BankingException("Internal error occurred.. Kindly contact SYSADMIN");
					}

					Sv.log.debug("Link to the new customer updated.");


				} catch (ClassNotFoundException | SQLException err) {
					throw new BankingException("Internal error occurred.. Kindly contact SYSADMIN");
				}
			} else {
				return null;
			}
		} catch (BankingException err) {
			throw new BankingException("Error in OtherMenus");
		}
		Sv.log.info("Thank you, your user information is stored.");
		Sv.log.debug("Updating login link to the new customer.");

		uLogin.setLoginUserId(cust.getUserId());
		Sv.log.debug("Login userID "+ uLogin.getLoginUserId() +" is being set to customerID = "+ cust.getUserId());

		try (Connection connection = PostgreSqlConnection.getConnection()) {

			String sql = EntranceSearchQueries.LINK_ENTRANCE_TO_CUSTOMER;
			Sv.log.debug("sql = " + sql);
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, uLogin.getLoginUserId());
			preparedStatement.setLong(2, uLogin.getLoginId());

			int updCnt = customerSearchService.addNewCustomer(preparedStatement);

			if (updCnt != 1) {
				Sv.log.warn("Warning from NewLogin - Add to entrance = "+updCnt+"and not 1");
				throw new BankingException("Internal error occurred.. Kindly contact SYSADMIN");
			}

		} catch(ClassNotFoundException | SQLException err) {
			throw new BankingException("Internal error occurred.. Kindly contact SYSADMIN");
		}

		Sv.log.debug("Link to the new customer updated.");

		return cust;
	}
	
	public void activeCustomerMenu(Scanner scanner, Customer cust, Entrance login) throws BankingException {
		
		Sv.log.debug("Now inside activeCustomerMenu");
		OtherMenus om = new OtherMenus();
		Sv.log.debug("cust.getUserStatus().toUpperCase() = " + cust.getUserStatus().toUpperCase());
		boolean employee = (cust.getUserStatus().toUpperCase().equals("E"));
		boolean fullCustomer = (cust.getUserStatus().toUpperCase().equals("C"));
		Sv.log.debug("employee = " + employee + " - fullcustomer = " + fullCustomer );
		
		if (employee) {
			om.employeeMenu(scanner, cust, login);
		} else {
			om.fullCustomerMenu(scanner, cust, login);
			//om.pendingCustomerMenu(scanner, cust, login);
		}
		return;
	}
	
	public void employeeMenu(Scanner scanner, Customer cust, Entrance login) throws BankingException {
		
		String MenuName = "Employee_Menu.txt";
		List<String> wholeMenu = new ArrayList<>();
		FileActions ff = new FileActions();
		
				
		try {
			wholeMenu = ff.fileReads(MenuName);
			
		} catch(BankingException err) {
			throw new BankingException("Rethrown from First Employee Menu");
		}
		
		int cnt, cntr, slct= 0;
		
		slct = 99;
		while (slct > 0) {

			cntr = 0;
			cnt = ff.printMenu(wholeMenu, cntr) - 1;
			slct = ff.getMenuSelection(scanner, cnt);
			
		
			if (slct > 0) {
				
				switch (slct) {
				
				case 1:
					Sv.log.info("");
					Sv.log.info("This feature is under development.  Please check back later.");
					Sv.log.info("");
					break;
				case 2:
					Sv.log.info("");
					Sv.log.info("This feature is under development.  Please check back later.");
					Sv.log.info("");
					break;
				case 3: 
					Sv.log.info("");
					Sv.log.info("This feature is under development.  Please check back later.");
					Sv.log.info("");
					break;
				}

			} else {
				break;
			}
		}
	}
	
	public void fullCustomerMenu(Scanner scanner, Customer cust, Entrance login) throws BankingException {
		
		String MenuName = "Full_Customer_Menu.txt";
		FileActions ff = new FileActions();
		List<String> wholeMenu = new ArrayList<>();
		AccountSearchService accountSearchService = new AccountSearchServiceImpl();
		List<Account> accountList = new ArrayList<>();
		int acntCnt = 0;
		int pendCnt = 0;
		BigDecimal bd;

		try (Connection connection = PostgreSqlConnection.getConnection()) {
			String sql = AccountSearchQueries.GET_ALL_ACCOUNTS_BY_CUSTOMER;
			Sv.log.debug("sql = " + sql);
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, cust.getUserId());

			accountList = accountSearchService.getAllAccounts(preparedStatement);

		} catch (ClassNotFoundException | SQLException e) {
			Sv.log.debug("Error inside EntranceSearchDAOImpl = ",e);

		} catch (BankingException e) {
			Sv.log.debug(e.getMessage());
		}
		
		if (accountList==null || accountList.size() == 0)
			MenuName = "Short_Customer_Menu.txt";
		else {
			for (Account aa:accountList) {
				if (aa.getAcntStatus().equals("C")) {
					acntCnt++;
				} else if (aa.getAcntStatus().equals("P")) {
					pendCnt++;
				}
			}
			if (acntCnt == 0 && pendCnt > 0) {
				MenuName = "Mid_Customer_Menu.txt";
			}
		}
		
		try {
			wholeMenu = ff.fileReads(MenuName);
			
		} catch(BankingException err) {
			throw new BankingException("Rethrown from First Customer Menu");
		}
		
		int cnt, cntr, slct= 0;
		
		slct = 99;
		while (slct > 0) {

			cntr = 0;
			cnt = ff.printMenu(wholeMenu, cntr) - 1;
			slct = ff.getMenuSelection(scanner, cnt);
			CheckInputs ci = new CheckInputs();
		
			if (slct > 0) {
				
				switch (slct) {
				
				case 1:  // Open a new account
					
					Sv.log.info("Application to open an account");
					// boolean abort = false;
					Sv.log.info("What kind of an account would you like to open?");
					String bankType = ci.getAccountType(scanner, "'C' for Checking - 'S' for Savings - 'B' for Business (C/S/B) > ",1,1);
					if (bankType.equals(" ")) {
						Sv.log.info("Aborting new account.");
						break;
					}
					//Sv.log.info("What is your starting deposit? >");
					String amnt = ci.getStringInput(scanner, "What is your starting deposit? >", 4, 9, 'U');
					try {
						bd = new BigDecimal(amnt);
					} catch (Exception err) {
						Sv.log.info("Aborting new account.");
						break;
					}
					
					try (Connection connection = PostgreSqlConnection.getConnection()) {
						String sql = AccountSearchQueries.PUT_NEW_ACCOUNT;
						Sv.log.debug("sql = " + sql);
						PreparedStatement preparedStatement = connection.prepareStatement(sql);
						preparedStatement.setString(1, bankType);
						preparedStatement.setLong(2, cust.getUserId());
						preparedStatement.setString(3, "P");
						preparedStatement.setBigDecimal(4, bd);

						int addCnt = accountSearchService.putNewAccount(preparedStatement);

					} catch (ClassNotFoundException | SQLException e) {
						Sv.log.debug("Error inside EntranceSearchDAOImpl = ",e);

					} catch (BankingException e) {
						Sv.log.debug(e.getMessage());
					}
					Sv.log.info("Thank you.  We will be in touch.");
					Sv.log.info("");
					break;
					
				case 2:  // List accounts
					
					Sv.log.info("Available Accounts:");
					if (accountList==null || accountList.size() < 1) {
						Sv.log.info("You have no open accounts at this time");
					} else {
						for (Account aa:accountList) {
							if (aa.getAcntStatus().equals("P")) {
								Sv.log.info("Account: "+ aa.getAcntId() + " - Pending");
							} else {
							Sv.log.info("Account: "+ aa.getAcntId());
							}
						}
					}
					Sv.log.info("");
					break;
					
				case 3: // List the balance of an account
					
					boolean output = false;
					long accountNum = 0;
					Sv.log.info("Balance display:");;
					String accountString = ci.getStringInput(scanner, "Which account would you like to see? > ", 12, 12, 'N');
					try {
						accountNum = Long.parseLong(accountString);
					} catch (Exception err) {
						Sv.log.info("Not a valid account number.");
						break;
					}
					for (Account aa:accountList) {
						if (aa.getAcntId() == accountNum) {
							Sv.log.info("Account balance = " + aa.getAcntBalance() );
							output = true;
							break;
						}
					}
					if (!output) {
						Sv.log.info("No account matches that number");	
					}
					break;
					
				case 4:  //  Deposit or withdraw
					
					boolean withdrawal = false;
					BigDecimal bdBalance = new BigDecimal(0.00);
					BigDecimal finalBalance = new BigDecimal(0.00);
					BigDecimal bdXfer = new BigDecimal(0.00);
					BigDecimal bdZero = new BigDecimal(0.00);
					int testBd = 0;
					Long actualAccount = 0L;
					
					String DorW = "Would you like to Deposit or Withdraw (D / W)? ";
					String msg = "";
					
					Sv.log.info("Deposit and withdrawal:");
					DorW = ci.getStringInput(scanner, DorW, 1, 1, 'A');
					if (DorW.equals(" ")) {
						Sv.log.info("Transaction aborted...");
						break;
					}
					withdrawal = DorW.equals("W");
					if (withdrawal) {
						msg = "Which account would you like to withdraw from? > ";
					} else {
						msg = "Which account would you like to have the deposit? > ";
					}
					accountString = ci.getStringInput(scanner, msg, 12, 12, 'N');
					try {
						accountNum = Long.parseLong(accountString);
					} catch (Exception err) {
						Sv.log.info("Not a valid account number.");
						break;
					}
					for (Account aa:accountList) {
						if (aa.getAcntId() == accountNum) {
							bdBalance = aa.getAcntBalance();
							actualAccount = aa.getAcntId();
							break;
						}
					}
					msg = "What amount would you like? > ";
					amnt = ci.getStringInput(scanner, msg, 4, 9, 'U');
					try {
						bdXfer = new BigDecimal(amnt);
						testBd = bdXfer.compareTo(bdZero);
						if (testBd <= 0) {
							Sv.log.info("");
							Sv.log.info("Please make amounts greater than zero." );
							Sv.log.info("Aborting transaction" );
							Sv.log.info("");
						}
					} catch (Exception err) {
						Sv.log.info("Bad input - Aborting transaction");
						break;
					}
					if (withdrawal) {
						finalBalance = bdBalance.subtract(bdXfer);
					} else {
						finalBalance = bdBalance.add(bdXfer);
					}
					
					testBd = finalBalance.compareTo(bdZero);
					if (testBd < 0) {
						Sv.log.info("You do not have enough money in your account for that withdrawal");
						Sv.log.info("Aborting transaction");
						break;
					}
					
					try (Connection connection = PostgreSqlConnection.getConnection()) {
						String sql = AccountSearchQueries.UPDATE_ACCOUNT_BY_ID;
						Sv.log.debug("sql = " + sql);
						PreparedStatement preparedStatement = connection.prepareStatement(sql);
						preparedStatement.setBigDecimal(1, finalBalance);
						preparedStatement.setLong(2, actualAccount);

						int updCnt = accountSearchService.updateAcntById(preparedStatement);
						Sv.log.info("Records updates = " + updCnt);

					} catch (ClassNotFoundException | SQLException e) {
						Sv.log.debug("Error inside EntranceSearchDAOImpl = ",e);

					} catch (BankingException e) {
						Sv.log.debug(e.getMessage());
					}
					
					break;
				case 5:
					Sv.log.info("");
					Sv.log.info("This feature is under development.  Please check back later.");
					Sv.log.info("");
					break;
				case 6:
					Sv.log.info("");
					Sv.log.info("This feature is under development.  Please check back later.");
					Sv.log.info("");
					break;
				}

			} else {
				break;
			}
		}
	}
}