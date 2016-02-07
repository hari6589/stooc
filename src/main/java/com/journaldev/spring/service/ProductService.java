package com.journaldev.spring.service;

import java.util.List;

import com.journaldev.spring.model.Product;;

public interface ProductService {

	public void addProduct(Product product);
	public void updateProduct(Product product);
	public List<Product> listProducts();
	public Product getProductById(int id);
	public void removeProduct(int id);
	
}
