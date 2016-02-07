package com.journaldev.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.journaldev.spring.model.ItemType;

@Repository
public class ItemTypeDAOImpl implements ItemTypeDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(ItemTypeDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void addItemType(ItemType itemType) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(itemType);
		logger.info("ItemType saved successfully, ItemType Details="+itemType);
	}

	@Override
	public void updateItemType(ItemType itemType) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(itemType);
		logger.info("ItemType updated successfully, ItemType Details="+itemType);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ItemType> listItemTypes() {
		Session session = this.sessionFactory.getCurrentSession();
		List<ItemType> itemTypesList = session.createQuery("from ItemType").list();
		for(ItemType itemType : itemTypesList){
			logger.info("ItemType List::"+itemType);
		}
		return itemTypesList;
	}

	@Override
	public ItemType getItemTypeById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		ItemType itemType = (ItemType) session.load(ItemType.class, new Integer(id));
		logger.info("ItemType loaded successfully, ItemType details="+itemType);
		return itemType;
	}

	@Override
	public void removeItemType(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		ItemType itemType = (ItemType) session.load(ItemType.class, new Integer(id));
		if(null != itemType){
			session.delete(itemType);
		}
		logger.info("ItemType deleted successfully, itemType details="+itemType);
	}

}
