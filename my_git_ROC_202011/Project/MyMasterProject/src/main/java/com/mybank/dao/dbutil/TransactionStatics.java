package com.mybank.dao.dbutil;

public class TransactionStatics {

	// Statics that match the name in the database for the 'transaction' table.
	// It is table #5, with 3 foreign keys.  One to the 'customer' table, and
	// 2 to the 'account' table (although one can be null.

	public static final String T5F1 = "trans_id";
	public static final String T5F2 = "trans_user_id";
	public static final String T5F3 = "trans_type";
	public static final String T5F4 = "trans_from_acnt_id";
	public static final String T5F5 = "trans_to_acnt_id";
	public static final String T5F6 = "trans_date";
	public static final String T5F7 = "trans_time";
	public static final String T5F8 = "trans_amnt";
}