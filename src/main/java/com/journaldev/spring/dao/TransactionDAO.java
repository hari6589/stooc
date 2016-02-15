package com.journaldev.spring.dao;

import java.util.List;

import com.journaldev.spring.model.Transaction;

public interface TransactionDAO {

	public void addTransaction(Transaction transaction);
	public void updateTransaction(Transaction transaction);
	public List<Transaction> listTransactions();
	public Transaction getTransactionById(int id);
	public void removeTransaction(int id);
}
