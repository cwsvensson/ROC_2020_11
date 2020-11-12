package com.mybank.model;

import java.util.Date;

public class Entrance {
	
//  Table 2 = 'entrance' table in 'banking'

	private int loginId;
	private String loginUsername;
	private String loginPassword;
	private long loginUserId;
	private Date loginCreation;
	private Date loginLastLogin;
	
	public Entrance() {
		// Never to be used...
	}
	
	public Entrance(String loginUsername) {
		this.loginUsername = loginUsername;
	}

	public Entrance(int loginId, String loginUsername, String loginPassword, long loginUserId, Date loginCreation,
			Date loginLastLogin) {
		super();
		this.loginId = loginId;
		this.loginUsername = loginUsername;
		this.loginPassword = loginPassword;
		this.loginUserId = loginUserId;
		this.loginCreation = loginCreation;
		this.loginLastLogin = loginLastLogin;
	}

	@Override
	public String toString() {
		return "Entrance [loginId=" + loginId + ", loginUsername=" + loginUsername + ", loginPassword=" + loginPassword
				+ ", loginUserId=" + loginUserId + ", loginCreation=" + loginCreation + ", loginLastLogin="
				+ loginLastLogin + "]";
	}

	/**
	 * @return get the login ID
	 */
	public int getLoginId() {
		return loginId;
	}

	/*
	 * @param set the login ID - Can only be set in the database
	 */
//	public void setLoginId(int loginId) {
//		this.loginId = loginId;
//	}

	/**
	 * @return get the login user name
	 */
	public String getLoginUsername() {
		return loginUsername;
	}

	/**
	 * @param set the login user name
	 */
	public void setLoginUsername(String loginUsername) {
		this.loginUsername = loginUsername;
	}

	/**
	 * @return get the login Password
	 */
	public String getLoginPassword() {
		return loginPassword;
	}

	/**
	 * @param set the login Password
	 */
	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	/**
	 * @return get the login User Id
	 */
	public long getLoginUserId() {
		return loginUserId;
	}

	/**
	 * @param set the login User Id
	 */
	public void setLoginUserId(long loginUserId) {
		this.loginUserId = loginUserId;
	}

	/**
	 * @return get the login creation date 
	 */
	public Date getLoginCreation() {
		return loginCreation;
	}

	/*
	 * @param set the login credential creation date - Can only be set in the database
	 */
//	public void setLoginCreation(Date loginCreation) {
//		this.loginCreation = loginCreation;
//	}

	/**
	 * @return get the login last login date
	 */
	public Date getLoginLastLogin() {
		return loginLastLogin;
	}

	/*
	 * @param set the last login date - Can only be set in the database
	 */
//	public void setLoginLastLogin(Date loginLastLogin) {
//		this.loginLastLogin = loginLastLogin;
//	}
	
	
	
}
