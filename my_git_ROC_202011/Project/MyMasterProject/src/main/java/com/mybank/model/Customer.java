package com.mybank.model;

import java.util.Date;

public class Customer {
	
//  Table 1 = 'customer' table in 'banking'

	private int userId;
	private String userStatus;
	private String userFName;
	private String userInitial;
	private String userLName;
	private String userStreet;
	private String userCity;
	private String userState;
	private String userZipCode;
	private Date   userLastUpdate;
	
	public Customer() {
		this.userId = 0;
	}

	public Customer(int userId, String userStatus, String userFName, String userInitial, String userLName,
			String userStreet, String userCity, String userState, String userZipCode, Date userLastUpdate) {
		this.userId = userId;
		this.userStatus = userStatus;
		this.userFName = userFName;
		this.userInitial = userInitial;
		this.userLName = userLName;
		this.userStreet = userStreet;
		this.userCity = userCity;
		this.userState = userState;
		this.userZipCode = userZipCode;
		this.userLastUpdate = userLastUpdate;
	}

	@Override
	public String toString() {
		return ("Customer [userId=" + userId + ", userStatus=" + userStatus + ", userFName=" + userFName
				+ ", userInitial=" + userInitial + ", userLName=" + userLName + ", userStreet=" + userStreet
				+ ", userCity=" + userCity + ", userState=" + userState + ", userZipCode=" + userZipCode
				+ ", userLastUpdate=" + userLastUpdate + "]");
	}

	/**
	 * @return get the user ID
	 */
	public int getUserId() {
		return userId;
	}

	/*
	 * @param set the user ID - Can only be set in the database
	 */
//	public void setUserId(int userId) {
//		this.userId = userId;
//	}

	/**
	 * @return get the user Status
	 */
	public String getUserStatus() {
		return userStatus;
	}

	/**
	 * @param set the user Status
	 */
	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	/**
	 * @return get the user's First Name
	 */
	public String getUserFName() {
		return userFName;
	}

	/**
	 * @param set the user's First Name
	 */
	public void setUserFName(String userFName) {
		this.userFName = userFName;
	}

	/**
	 * @return get the user's Initial
	 */
	public String getUserInitial() {
		return userInitial;
	}

	/**
	 * @param set the user's Initial
	 */
	public void setUserInitial(String userInitial) {
		this.userInitial = userInitial;
	}

	/**
	 * @return get the user's Last Name
	 */
	public String getUserLName() {
		return userLName;
	}

	/**
	 * @param set the user's Last Name
	 */
	public void setUserLName(String userLName) {
		this.userLName = userLName;
	}

	/**
	 * @return get the user's Street
	 */
	public String getUserStreet() {
		return userStreet;
	}

	/**
	 * @param set the user's Street
	 */
	public void setUserStreet(String userStreet) {
		this.userStreet = userStreet;
	}

	/**
	 * @return get the user's City
	 */
	public String getUserCity() {
		return userCity;
	}

	/**
	 * @param set the user's City
	 */
	public void setUserCity(String userCity) {
		this.userCity = userCity;
	}

	/**
	 * @return get the user's State
	 */
	public String getUserState() {
		return userState;
	}

	/**
	 * @param set the user's State
	 */
	public void setUserState(String userState) {
		this.userState = userState;
	}

	/**
	 * @return get the user's ZipCode
	 */
	public String getUserZipCode() {
		return userZipCode;
	}

	/**
	 * @param set the user's ZipCode
	 */
	public void setUserZipCode(String userZipCode) {
		this.userZipCode = userZipCode;
	}

	/**
	 * @return get the user Last Update date
	 */
	public Date getUserLastUpdate() {
		return userLastUpdate;
	}

	/*
	 * @param set the user Last Update date - Can only be set in the database
	 */
//	public void setUserLastUpdate(Date userLastUpdate) {
//		this.userLastUpdate = userLastUpdate;
//	}
	
	
	
}
