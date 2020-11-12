package com.mybank.model;

import java.util.Date;

public class Telephone {
	
//  Table 4 = 'telephone' table in 'banking'

	private int telUserId;
	private long telNum;
	private String telType;
	private String telText;
	private Date   telLastUpdate;
	
	public Telephone() {
		// Never to be used...
	}

	public Telephone(int telUserId, long telNum, String telType, String telText, Date telLastUpdate) {
		this.telUserId = telUserId;
		this.telNum = telNum;
		this.telType = telType;
		this.telText = telText;
		this.telLastUpdate = telLastUpdate;
	}

	@Override
	public String toString() {
		return "Telephone [telUserId=" + telUserId + ", telNum=" + telNum + ", telType=" + telType + ", telText="
				+ telText + ", telLastUpdate=" + telLastUpdate + "]";
	}

	/**
	 * @return get the telephone user ID
	 */
	public int getTelUserId() {
		return telUserId;
	}

	/**
	 * @param set the telephone user ID
	 */
	public void setTelUserId(int telUserId) {
		this.telUserId = telUserId;
	}

	/**
	 * @return get the telephone Number
	 */
	public long getTelNum() {
		return telNum;
	}

	/**
	 * @param set the telephone Number
	 */
	public void setTelNum(int telNum) {
		this.telNum = telNum;
	}

	/**
	 * @return get the telephone Type
	 */
	public String getTelType() {
		return telType;
	}

	/**
	 * @param set the telephone Type
	 */
	public void setTelType(String telType) {
		this.telType = telType;
	}

	/**
	 * @return get the telephone Text status
	 */
	public String getTelText() {
		return telText;
	}

	/**
	 * @param set the telephone Text status
	 */
	public void setTelText(String telText) {
		this.telText = telText;
	}

	/**
	 * @return get the telephone Last Update date
	 */
	public Date getTelLastUpdate() {
		return telLastUpdate;
	}

	/*
	 * @param set the Last Update date - Can only be set in the database
	 */
//	public void setTelLastUpdate(Date telLastUpdate) {
//		this.telLastUpdate = telLastUpdate;
//	}

}