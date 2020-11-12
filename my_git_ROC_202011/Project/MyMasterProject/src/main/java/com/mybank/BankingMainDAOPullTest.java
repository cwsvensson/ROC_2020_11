package com.mybank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.mybank.dao.dbutil.AccountSearchQueries;
import com.mybank.dao.dbutil.CustomerSearchQueries;
import com.mybank.dao.dbutil.EntranceSearchQueries;
import com.mybank.dao.dbutil.PostgreSqlConnection;
import com.mybank.dao.dbutil.TelephoneSearchQueries;
import com.mybank.dao.dbutil.TransactionSearchQueries;
import com.mybank.exception.BankingException;
import com.mybank.model.Account;
import com.mybank.model.Customer;
import com.mybank.model.Entrance;
import com.mybank.model.Telephone;
import com.mybank.model.Transaction;
import com.mybank.service.AccountSearchService;
import com.mybank.service.CustomerSearchService;
import com.mybank.service.EntranceSearchService;
import com.mybank.service.TelephoneSearchService;
import com.mybank.service.TransactionSearchService;
import com.mybank.service.impl.AccountSearchServiceImpl;
import com.mybank.service.impl.CustomerSearchServiceImpl;
import com.mybank.service.impl.EntranceSearchServiceImpl;
import com.mybank.service.impl.TelephoneSearchServiceImpl;
import com.mybank.service.impl.TransactionSearchServiceImpl;
import com.mybank.service.menu.Sv;

public class BankingMainDAOPullTest {

	public static void main(String[] args) {
		
		Sv.log.info("Main DAO Pull Test Program");
		//		String tag = "Hello From Main";
		//		Service.srvs(tag);

		CustomerSearchService customerSearchService = new CustomerSearchServiceImpl();

		Sv.log.info("");
		Sv.log.info("Fetching All The Customers From the DB");
		try (Connection connection = PostgreSqlConnection.getConnection()) {
			String sql = CustomerSearchQueries.GET_ALL_CUSTOMERS;
			Sv.log.info("sql = " + sql);
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			List<Customer> customerList = customerSearchService.getAllCustomers(preparedStatement);
			if(customerList!=null && customerList.size()>0) {
				Sv.log.info("We Found " + customerList.size()+" customer/s in the DB.. Details are");
				for(Customer cc:customerList) {
					Sv.log.info(cc);
				}
			}
		} catch (BankingException e) {
			Sv.log.debug(e.getMessage());
			
		} catch (ClassNotFoundException | SQLException e) {
			Sv.log.debug("Error inside EntranceSearchDAOImpl = ",e);
		}
		
		AccountSearchService accountSearchService = new AccountSearchServiceImpl();

		Sv.log.info("");
		Sv.log.info("Fetching All The Accounts From the DB");
		
		try (Connection connection = PostgreSqlConnection.getConnection()) {
			String sql = AccountSearchQueries.GET_ALL_ACCOUNTS;
			Sv.log.debug("sql = " + sql);
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			List<Account> accountList = accountSearchService.getAllAccounts(preparedStatement);
			if(accountList!=null && accountList.size()>0) {
				Sv.log.info("We Found " + accountList.size()+" customer/s in the DB.. Details are");
				for(Account aa:accountList) {
					Sv.log.info(aa);
				}
			}
		} catch (ClassNotFoundException | SQLException e) {
			Sv.log.debug("Error inside EntranceSearchDAOImpl = ",e);
		
		} catch (BankingException e) {
			Sv.log.debug(e.getMessage());
		}
		
		EntranceSearchService entranceSearchService = new EntranceSearchServiceImpl();
		
		Sv.log.info("");
		Sv.log.info("Fetching All The Logins From the DB");
		
		try (Connection connection = PostgreSqlConnection.getConnection()) {
			
			String sql = EntranceSearchQueries.GET_ALL_LOGINS;
			Sv.log.debug("sql = " + sql);
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
		
			List<Entrance> entranceList = entranceSearchService.getLogins(preparedStatement);
			if(entranceList!=null && entranceList.size()>0) {
				Sv.log.info("We Found " + entranceList.size()+" customer/s in the DB.. Details are");
				for(Entrance ee:entranceList) {
					Sv.log.info(ee);
				}
			}
		} catch (ClassNotFoundException | SQLException e) {
			Sv.log.debug("Error inside EntranceSearchDAOImpl = ",e);
		
		} catch (BankingException e) {
			Sv.log.debug(e.getMessage());
		}
		
		TelephoneSearchService telephoneSearchService = new TelephoneSearchServiceImpl();
		
		Sv.log.info("");
		Sv.log.info("Fetching All The Telephone Numbers From the DB");
		try (Connection connection = PostgreSqlConnection.getConnection()) {
			String sql = TelephoneSearchQueries.GET_ALL_TELEPHONES;
			Sv.log.debug("sql = " + sql);
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			List<Telephone> telephoneList = telephoneSearchService.getAllTelephones(preparedStatement);
			if(telephoneList!=null && telephoneList.size()>0) {
				Sv.log.info("We Found " + telephoneList.size()+" customer/s in the DB.. Details are");
				for(Telephone tt:telephoneList) {
					Sv.log.info(tt);
				}
			}
		} catch (ClassNotFoundException | SQLException e) {
			Sv.log.debug("Error inside EntranceSearchDAOImpl = ",e);
		
		} catch (BankingException e) {
			Sv.log.debug(e.getMessage());
		}

		TransactionSearchService transactionSearchService = new TransactionSearchServiceImpl();
		
		Sv.log.info("");
		Sv.log.info("Fetching All The Transactions From the DB");
		
		try (Connection connection = PostgreSqlConnection.getConnection()){
			
			String sql = TransactionSearchQueries.GET_ALL_TRANSACTIONS;
			Sv.log.debug("sql = " + sql);
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			List<Transaction> transactionList = transactionSearchService.getAllTransactions(preparedStatement);
			
			if(transactionList!=null && transactionList.size()>0) {
				Sv.log.info("We Found " + transactionList.size()+" customer/s in the DB.. Details are");
				for(Transaction tt:transactionList) {
					Sv.log.info(tt);
				}
			}
		} catch (ClassNotFoundException | SQLException e) {
			Sv.log.debug("Error inside EntranceSearchDAOImpl = ",e);
		
		} catch (BankingException e) {
			Sv.log.debug(e.getMessage());
		}
	}
	
}
