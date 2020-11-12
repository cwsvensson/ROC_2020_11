package com.mybank.dao.dbutil;

public class AccountSearchQueries {

	public static final String GET_ALL_ACCOUNTS = "SELECT acnt_id, acnt_type, acnt_user_id, acnt_status, "
			                      + " acnt_balance, acnt_lastupdate  FROM banking.account";
	
	public static final String GET_ALL_ACCOUNTS_BY_CUSTOMER = "Select acnt_id, acnt_type, acnt_user_id, acnt_status, " +
	                     "acnt_balance, acnt_lastupdate from banking.account where acnt_user_id=?;";
	
	public static final String PUT_NEW_ACCOUNT = 
			"Insert into banking.account (acnt_type, acnt_user_id, acnt_status, acnt_balance) " +
	        " Values (?, ?, ?, ?);";
	
	public static final String UPDATE_ACCOUNT_BY_ID = "Update banking.account Set acnt_balance=? where "
			 + "acnt_id=?;";
}