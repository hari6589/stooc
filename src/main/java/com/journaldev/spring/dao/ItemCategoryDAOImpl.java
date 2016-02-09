package com.journaldev.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.journaldev.spring.model.ItemCategory;

@Repository
public class ItemCategoryDAOImpl implements ItemCategoryDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(ItemCategoryDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void addItemCategory(ItemCategory itemCategory) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(itemCategory);
		logger.info("ItemCategory saved successfully, ItemCategory Details="+itemCategory);
	}

	@Override
	public void updateItemCategory(ItemCategory itemCategory) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(itemCategory);
		logger.info("ItemCategory updated successfully, ItemCategory Details="+itemCategory);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ItemCategory> listItemCategorys() {
		Session session = this.sessionFactory.getCurrentSession();
		List<ItemCategory> itemCategorysList = session.createQuery("from ItemCategory").list();
		for(ItemCategory itemCategory : itemCategorysList){
			logger.info("ItemCategory List::"+itemCategory);
		}
		return itemCategorysList;
	}

	@Override
	public ItemCategory getItemCategoryById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		ItemCategory itemCategory = (ItemCategory) session.load(ItemCategory.class, new Integer(id));
		logger.info("ItemCategory loaded successfully, ItemCategory details="+itemCategory);
		return itemCategory;
	}

	@Override
	public void removeItemCategory(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		ItemCategory itemCategory = (ItemCategory) session.load(ItemCategory.class, new Integer(id));
		if(null != itemCategory){
			session.delete(itemCategory);
		}
		logger.info("ItemCategory deleted successfully, itemCategory details="+itemCategory);
	}

}
