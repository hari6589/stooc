package com.journaldev.spring.dao;

import java.util.List;

import com.journaldev.spring.model.ItemCategory;

public interface ItemCategoryDAO {

	public void addItemCategory(ItemCategory itemCategory);
	public void updateItemCategory(ItemCategory itemCategory);
	public List<ItemCategory> listItemCategorys();
	public ItemCategory getItemCategoryById(int id);
	public void removeItemCategory(int id);
}
