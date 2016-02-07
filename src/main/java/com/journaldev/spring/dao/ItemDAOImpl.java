package com.journaldev.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.journaldev.spring.model.Item;
	
@Repository
public class ItemDAOImpl implements ItemDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(ItemDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void addItem(Item item) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(item);
		logger.info("Item saved successfully, Item Details="+item);
	}

	@Override
	public void updateItem(Item item) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(item);
		logger.info("Item updated successfully, Item Details="+item);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Item> listItems() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Item> itemsList = session.createQuery("from Item").list();
		for(Item item : itemsList){
			logger.info("Item List::"+item);
		}
		return itemsList;
	}

	@Override
	public Item getItemById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Item item = (Item) session.load(Item.class, new Integer(id));
		logger.info("Item loaded successfully, Item details="+item);
		return item;
	}

	@Override
	public void removeItem(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Item item = (Item) session.load(Item.class, new Integer(id));
		if(null != item){
			session.delete(item);
		}
		logger.info("Item deleted successfully, item details="+item);
	}

}
