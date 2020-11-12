package com.mybank.dao.dbutil;

public class EntranceSearchQueries {

	public static final String GET_ALL_LOGINS = "SELECT login_id, login_username, login_password, login_user_id, "
			+"login_creation, login_lastlogin FROM banking.entrance;";
	
	public static final String GET_LOGIN_BY_USERNAME = "SELECT login_id, login_username, login_password, login_user_id, "
			+"login_creation, login_lastlogin FROM banking.entrance WHERE login_username = ?";
	
	public static final String GET_FULL_LOGIN = "SELECT login_id, login_username, login_password, login_user_id, "
			+"login_creation, login_lastlogin FROM banking.entrance WHERE login_username = ? and login_password = ?";
	
	public static final String CREATE_NEW_LOGIN = "INSERT into banking.entrance (login_username, login_password, login_user_id) " +
	                                              "VALUES (?, ?, ?);";
	
	public static final String  LINK_ENTRANCE_TO_CUSTOMER = "UPDATE banking.entrance SET login_user_id=?"
			                                       + " WHERE login_id=?";
}