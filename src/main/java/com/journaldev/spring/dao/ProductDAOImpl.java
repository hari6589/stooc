package com.journaldev.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.journaldev.spring.model.Product;

@Repository
public class ProductDAOImpl implements ProductDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void addProduct(Product product) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(product);
		logger.info("Product saved successfully, Product Details="+product);
	}

	@Override
	public void updateProduct(Product product) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(product);
		logger.info("Product updated successfully, Product Details="+product);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> listProducts() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Product> productsList = session.createQuery("from Product").list();
		for(Product product : productsList){
			logger.info("Product List::"+product);
		}
		return productsList;
	}

	@Override
	public Product getProductById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Product product = (Product) session.load(Product.class, new Integer(id));
		logger.info("Product loaded successfully, Product details="+product);
		return product;
	}

	@Override
	public void removeProduct(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Product product = (Product) session.load(Product.class, new Integer(id));
		if(null != product){
			session.delete(product);
		}
		logger.info("Product deleted successfully, product details="+product);
	}

}
