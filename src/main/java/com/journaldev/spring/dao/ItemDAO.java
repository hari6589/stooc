package com.journaldev.spring.dao;

import java.util.List;

import com.journaldev.spring.model.Item;

public interface ItemDAO {

	public void addItem(Item item);
	public void updateItem(Item item);
	public List<Item> listItems();
	public Item getItemById(int id);
	public void removeItem(int id);
}
