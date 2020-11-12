package com.mybank.dao.dbutil;

public class TelephoneSearchQueries {

	public static final String GET_ALL_TELEPHONES = "SELECT "  + TelephoneStatics.T4F1 +", " + TelephoneStatics.T4F2 +", "
			+ TelephoneStatics.T4F3 +", " + TelephoneStatics.T4F4 +", " + TelephoneStatics.T4F5 
			+ " FROM banking.telephone";
}