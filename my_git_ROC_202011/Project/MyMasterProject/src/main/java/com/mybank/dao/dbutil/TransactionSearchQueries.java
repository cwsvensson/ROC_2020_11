package com.mybank.dao.dbutil;

public class TransactionSearchQueries {

	public static final String GET_ALL_TRANSACTIONS = "SELECT "  + TransactionStatics.T5F1 +", " + TransactionStatics.T5F2 +", "
			                   + TransactionStatics.T5F3 +", " + TransactionStatics.T5F4 +", " + TransactionStatics.T5F5 +", " 
			                   + TransactionStatics.T5F6 +", " + TransactionStatics.T5F7 +", " + TransactionStatics.T5F8 
			                   + " FROM banking.transaction";
	
	public static final String ADD_NEW_TRANSACTION = "Insert into banking.transaction " + 
	                     " (trans_user_id, trans_type, trans_from_account, trans_to_acnt, trans_amount) " + 
			             "Values (?,?,?,?,?);";
}
