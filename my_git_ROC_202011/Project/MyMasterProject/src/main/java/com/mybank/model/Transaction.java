package com.mybank.model;

import java.math.BigDecimal;
import java.sql.Time;
import java.util.Date;

public class Transaction {
	
//  Table 5 = 'transaction' table in 'banking'

	private long transId;
	private int  transUserId;
	private String transType;
	private long transFromAcntId;
	private long transToAcntId;
	private Date transDate;
	private Time transTime;
	private BigDecimal transAmnt;
	

	public Transaction() {
		// Never to be used...
	}

	public Transaction(long transId, int transUserId, String transType, long transFromAcntId, long transToAcntId,
			Date transDate, Time transTime, BigDecimal transAmnt) {
		this.transId = transId;
		this.transUserId = transUserId;
		this.transType = transType;
		this.transFromAcntId = transFromAcntId;
		this.transToAcntId = transToAcntId;
		this.transDate = transDate;
		this.transTime = transTime;
		this.transAmnt = transAmnt;
	}

	@Override
	public String toString() {
		return "Transaction [transId=" + transId + ", transUserId=" + transUserId + ", transType=" + transType
				+ ", transFromAcntId=" + transFromAcntId + ", transToAcntId=" + transToAcntId + ", transDate="
				+ transDate + ", transTime=" + transTime + ", transAmnt=" + transAmnt + "]";
	}

	/**
	 * @return get the transaction ID
	 */
	public long getTransId() {
		return transId;
	}

	/*
	 * @param get the transaction ID - Can only be set in the database
	 */
//	public void setTransId(long transId) {
//		this.transId = transId;
//	}

	/**
	 * @return get the transaction User Id
	 */
	public int getTransUserId() {
		return transUserId;
	}

	/**
	 * @param set the transaction User Id
	 */
	public void setTransUserId(int transUserId) {
		this.transUserId = transUserId;
	}

	/**
	 * @return get the transaction Type
	 */
	public String getTransType() {
		return transType;
	}

	/**
	 * @param set the transaction Type
	 */
	public void setTransType(String transType) {
		this.transType = transType;
	}

	/**
	 * @return get the transaction From Account Id
	 */
	public long getTransFromAcntId() {
		return transFromAcntId;
	}

	/**
	 * @param set the transaction From Account Id
	 */
	public void setTransFromAcntId(int transFromAcntId) {
		this.transFromAcntId = transFromAcntId;
	}

	/**
	 * @return get the transaction To Account Id
	 */
	public long getTransToAcntId() {
		return transToAcntId;
	}

	/**
	 * @param set the transaction To Account Id
	 */
	public void setTransToAcntId(int transToAcntId) {
		this.transToAcntId = transToAcntId;
	}

	/**
	 * @return get the transaction Date
	 */
	public Date getTransDate() {
		return transDate;
	}

	/*
	 * @param set the transaction Date - Can only be set in the database
	 */
//	public void setTransDate(Date transDate) {
//		this.transDate = transDate;
//	}

	/**
	 * @return get the transaction Time
	 */
	public Time getTransTime() {
		return transTime;
	}

	/*
	 * @param set the transaction Time - Can only be set in the database
	 */
//	public void setTransTime(LocalTime transTime) {
//		this.transTime = transTime;
//	}

	/**
	 * @return get the transaction Amount
	 */
	public BigDecimal getTransAmnt() {
		return transAmnt;
	}

	/**
	 * @param set the transaction Amount
	 */
	public void setTransAmnt(BigDecimal transAmnt) {
		this.transAmnt = transAmnt;
	}
}
