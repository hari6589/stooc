package com.journaldev.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.journaldev.spring.dao.TransactionDAO;
import com.journaldev.spring.model.Transaction;

@Service
public class TransactionServiceImpl implements TransactionService {
	
	private TransactionDAO transactionDAO;

	public void setTransactionDAO(TransactionDAO transactionDAO) {
		this.transactionDAO = transactionDAO;
	}

	@Override
	@Transactional
	public void addTransaction(Transaction transaction) {
		this.transactionDAO.addTransaction(transaction);
	}

	@Override
	@Transactional
	public void updateTransaction(Transaction transaction) {
		this.transactionDAO.updateTransaction(transaction);
	}

	@Override
	@Transactional
	public List<Transaction> listTransactions() {
		return this.transactionDAO.listTransactions();
	}

	@Override
	@Transactional
	public Transaction getTransactionById(int id) {
		return this.transactionDAO.getTransactionById(id);
	}

	@Override
	@Transactional
	public void removeTransaction(int id) {
		this.transactionDAO.removeTransaction(id);
	}

}
