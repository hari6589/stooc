package com.journaldev.spring.service;

import java.util.List;

import com.journaldev.spring.model.Transaction;;

public interface TransactionService {

	public void addTransaction(Transaction transaction);
	public void updateTransaction(Transaction transaction);
	public List<Transaction> listTransactions();
	public Transaction getTransactionById(int id);
	public void removeTransaction(int id);
	
}
