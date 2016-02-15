package com.journaldev.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.journaldev.spring.model.Transaction;

@Repository
public class TransactionDAOImpl implements TransactionDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(TransactionDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void addTransaction(Transaction transaction) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(transaction);
		logger.info("Transaction saved successfully, Transaction Details="+transaction);
	}

	@Override
	public void updateTransaction(Transaction transaction) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(transaction);
		logger.info("Transaction updated successfully, Transaction Details="+transaction);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Transaction> listTransactions() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Transaction> transactionsList = session.createQuery("from Transaction").list();
		for(Transaction transaction : transactionsList){
			logger.info("Transaction List::"+transaction);
		}
		return transactionsList;
	}

	@Override
	public Transaction getTransactionById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Transaction transaction = (Transaction) session.load(Transaction.class, new Integer(id));
		logger.info("Transaction loaded successfully, Transaction details="+transaction);
		return transaction;
	}

	@Override
	public void removeTransaction(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Transaction transaction = (Transaction) session.load(Transaction.class, new Integer(id));
		if(null != transaction){
			session.delete(transaction);
		}
		logger.info("Transaction deleted successfully, transaction details="+transaction);
	}

}
