package com.journaldev.spring.service;

import java.util.List;

import com.journaldev.spring.model.ItemCategory;;

public interface ItemCategoryService {

	public void addItemCategory(ItemCategory itemType);
	public void updateItemCategory(ItemCategory itemType);
	public List<ItemCategory> listItemCategorys();
	public ItemCategory getItemCategoryById(int id);
	public void removeItemCategory(int id);
	
}
