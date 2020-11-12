package com.mybank.model;

import java.math.BigDecimal;
import java.util.Date;

public class Account {
	
	//  Table 3 = 'account' table in 'banking'

	private long acntId;
	private String anctType;
	private long acntUserId;
	private String acntStatus;
	private BigDecimal acntBalance;
	private Date acntLastUpdate;
	
	public Account() {
		// Never to be used...
	}

	public Account(long acntId, String anctType, long acntUserId, String acntStatus, BigDecimal acntBalance,
			Date acntLastUpdate) {
		super();
		this.acntId = acntId;
		this.anctType = anctType;
		this.acntUserId = acntUserId;
		this.acntStatus = acntStatus;
		this.acntBalance = acntBalance;
		this.acntLastUpdate = acntLastUpdate;
	}
	
	@Override
	public String toString() {
		return "Account [acntId=" + acntId + ", anctType=" + anctType + ", acntUserId=" + acntUserId + ", acntStatus="
				+ acntStatus + ", acntBalance=" + acntBalance + ", acntLastUpdate=" + acntLastUpdate + "]";
	}

	/**
	 * @return get the account ID
	 */
	public long getAcntId() {
		return acntId;
	}

	/*
	 * @param set the account ID - Can only be set in the database
	 */
//	public void setAcntId(long acntId) {
//		this.acntId = acntId;
//	}

	/**
	 * @return get the account type
	 */
	public String getAnctType() {
		return anctType;
	}

	/**
	 * @param set the account type
	 */
	public void setAnctType(String anctType) {
		this.anctType = anctType;
	}

	/**
	 * @return get the account user ID (foreign key to customer user ID)
	 */
	public long getAcntUserId() {
		return acntUserId;
	}

	/**
	 * @param set the account user ID (foreign key to customer user ID)
	 */
	public void setAcntUserId(long acntUserId) {
		this.acntUserId = acntUserId;
	}

	/**
	 * @return get the account status
	 */
	public String getAcntStatus() {
		return acntStatus;
	}

	/**
	 * @param set the account status
	 */
	public void setAcntStatus(String acntStatus) {
		this.acntStatus = acntStatus;
	}

	/**
	 * @return get the account balance
	 */
	public BigDecimal getAcntBalance() {
		return acntBalance;
	}

	/**
	 * @param set the new account balance (often used)
	 */
	public void setAcntBalance(BigDecimal acntBalance) {
		this.acntBalance = acntBalance;
	}

	/**
	 * @return get the last date when an update occurred
	 */
	public Date getAcntLastUpdate() {
		return acntLastUpdate;
	}

	/*
	 * @param set the account date - can only be set in the database
	 */
//		public void setAcntLastUpdate(Date acntLastUpdate) {
//		this.acntLastUpdate = acntLastUpdate;
//	}
}