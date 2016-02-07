package com.journaldev.spring.dao;

import java.util.List;

import com.journaldev.spring.model.ItemType;

public interface ItemTypeDAO {

	public void addItemType(ItemType itemType);
	public void updateItemType(ItemType itemType);
	public List<ItemType> listItemTypes();
	public ItemType getItemTypeById(int id);
	public void removeItemType(int id);
}
