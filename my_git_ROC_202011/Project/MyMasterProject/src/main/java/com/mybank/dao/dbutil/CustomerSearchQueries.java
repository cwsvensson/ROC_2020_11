package com.mybank.dao.dbutil;

public class CustomerSearchQueries {
	
	public static final String GET_ALL_CUSTOMERS = "SELECT user_id, user_status, user_fname, user_initial, " +
	        " user_lname, user_street, user_city, user_state, user_zip, user_lastupdate " +
	        " FROM banking.customer";
	
	public static final String GET_CUSTOMER_BY_LOGIN = "SELECT user_id, user_status, user_fname, user_initial, " +
	        " user_lname, user_street, user_city, user_state, user_zip, user_lastupdate " +
	        " FROM banking.customer where user_id = ?";
	
	public static final String CREATE_NEW_CUSTOMER = "INSERT into banking.customer (user_status, user_fname, user_initial,"
			+ " user_lname, user_street, user_city, user_state, user_zip) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
	
	public static final String READ_BACK_CUSTOMER = "SELECT user_id, user_status, user_fname, user_initial, " +
	        " user_lname, user_street, user_city, user_state, user_zip, user_lastupdate " +
	        " FROM banking.customer WHERE user_status= ? AND user_fname=? AND user_initial=? AND user_lname=?" +
	        " AND user_street=? AND user_city=? AND user_state=? AND user_zip=?;";
}