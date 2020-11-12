package com.mybank.dao.dbutil;

public class CustomerStatics {
	
	// Statics that match the name in the database for the 'customer' table.
	// As the only table with no foreign keys, it is table #1
	// The static for the 'user_id' (field 1) won't be used in an UPDATE
	// statement as it can only be set in the database, and the same for
	// 'user_lastupdate' (field 10).
	
	public static final String T1F1 = "user_id";
	public static final String T1F2 = "user_status";
	public static final String T1F3 = "user_fname";
	public static final String T1F4 = "user_initial";
	public static final String T1F5 = "user_lname";
	public static final String T1F6 = "user_street";
	public static final String T1F7 = "user_city";
	public static final String T1F8 = "user_state";
	public static final String T1F9 = "user_zip";
	public static final String T1F10 ="user_lastupdate";
}