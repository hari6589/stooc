package com.journaldev.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.journaldev.spring.dao.ItemDAO;
import com.journaldev.spring.model.Item;

@Service
public class ItemServiceImpl implements ItemService {
	
	private ItemDAO itemDAO;

	public void setItemDAO(ItemDAO itemDAO) {
		this.itemDAO = itemDAO;
	}

	@Override
	@Transactional
	public void addItem(Item item) {
		this.itemDAO.addItem(item);
	}

	@Override
	@Transactional
	public void updateItem(Item item) {
		this.itemDAO.updateItem(item);
	}

	@Override
	@Transactional
	public List<Item> listItems() {
		return this.itemDAO.listItems();
	}

	@Override
	@Transactional
	public Item getItemById(int id) {
		return this.itemDAO.getItemById(id);
	}

	@Override
	@Transactional
	public void removeItem(int id) {
		this.itemDAO.removeItem(id);
	}

}
