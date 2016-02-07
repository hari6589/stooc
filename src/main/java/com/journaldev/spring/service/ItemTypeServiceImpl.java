package com.journaldev.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.journaldev.spring.dao.ItemTypeDAO;
import com.journaldev.spring.model.ItemType;

@Service
public class ItemTypeServiceImpl implements ItemTypeService {
	
	private ItemTypeDAO itemTypeDAO;

	public void setItemTypeDAO(ItemTypeDAO itemTypeDAO) {
		this.itemTypeDAO = itemTypeDAO;
	}

	@Override
	@Transactional
	public void addItemType(ItemType itemType) {
		this.itemTypeDAO.addItemType(itemType);
	}

	@Override
	@Transactional
	public void updateItemType(ItemType itemType) {
		this.itemTypeDAO.updateItemType(itemType);
	}

	@Override
	@Transactional
	public List<ItemType> listItemTypes() {
		return this.itemTypeDAO.listItemTypes();
	}

	@Override
	@Transactional
	public ItemType getItemTypeById(int id) {
		return this.itemTypeDAO.getItemTypeById(id);
	}

	@Override
	@Transactional
	public void removeItemType(int id) {
		this.itemTypeDAO.removeItemType(id);
	}

}
