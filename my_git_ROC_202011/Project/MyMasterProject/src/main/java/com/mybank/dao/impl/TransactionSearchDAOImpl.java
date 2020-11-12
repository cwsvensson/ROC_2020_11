package com.mybank.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mybank.dao.TransactionSearchDAO;
import com.mybank.dao.dbutil.TransactionStatics;
import com.mybank.exception.BankingException;
import com.mybank.model.Transaction;
import com.mybank.service.menu.Sv;

public class TransactionSearchDAOImpl implements TransactionSearchDAO {

	@Override
	public List<Transaction> getAllTransactions(PreparedStatement preparedStatement) throws BankingException {
		
		List<Transaction> transactionList = new ArrayList<>();
		
		try {
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Transaction transaction = new Transaction(resultSet.getLong(TransactionStatics.T5F1), resultSet.getInt(TransactionStatics.T5F2),
						resultSet.getString(TransactionStatics.T5F3), resultSet.getLong(TransactionStatics.T5F4),
						resultSet.getLong(TransactionStatics.T5F5), resultSet.getDate(TransactionStatics.T5F6),
						resultSet.getTime(TransactionStatics.T5F7), 
						resultSet.getBigDecimal(TransactionStatics.T5F8) );
				transactionList.add(transaction);
			}
			if(transactionList.size()==0) {
				throw new BankingException("No Login Records Available");
			}

		} catch (SQLException e) {
			Sv.log.debug("Error inside TransactionSearchDAOImpl = ",e);
			throw new BankingException("Internal error occurred.. Kindly contact SYSADMIN");

		}
		return transactionList;
	}
}
