package com.journaldev.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.journaldev.spring.dao.ProductDAO;
import com.journaldev.spring.model.Product;

@Service
public class ProductServiceImpl implements ProductService {
	
	private ProductDAO productDAO;

	public void setProductDAO(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}

	@Override
	@Transactional
	public void addProduct(Product product) {
		this.productDAO.addProduct(product);
	}

	@Override
	@Transactional
	public void updateProduct(Product product) {
		this.productDAO.updateProduct(product);
	}

	@Override
	@Transactional
	public List<Product> listProducts() {
		return this.productDAO.listProducts();
	}

	@Override
	@Transactional
	public Product getProductById(int id) {
		return this.productDAO.getProductById(id);
	}

	@Override
	@Transactional
	public void removeProduct(int id) {
		this.productDAO.removeProduct(id);
	}

}
