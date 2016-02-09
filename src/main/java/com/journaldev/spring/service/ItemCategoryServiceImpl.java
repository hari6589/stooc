package com.journaldev.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.journaldev.spring.dao.ItemCategoryDAO;
import com.journaldev.spring.model.ItemCategory;

@Service
public class ItemCategoryServiceImpl implements ItemCategoryService {
	
	private ItemCategoryDAO itemCategoryDAO;

	public void setItemCategoryDAO(ItemCategoryDAO itemCategoryDAO) {
		this.itemCategoryDAO = itemCategoryDAO;
	}

	@Override
	@Transactional
	public void addItemCategory(ItemCategory itemCategory) {
		this.itemCategoryDAO.addItemCategory(itemCategory);
	}

	@Override
	@Transactional
	public void updateItemCategory(ItemCategory itemCategory) {
		this.itemCategoryDAO.updateItemCategory(itemCategory);
	}

	@Override
	@Transactional
	public List<ItemCategory> listItemCategorys() {
		return this.itemCategoryDAO.listItemCategorys();
	}

	@Override
	@Transactional
	public ItemCategory getItemCategoryById(int id) {
		return this.itemCategoryDAO.getItemCategoryById(id);
	}

	@Override
	@Transactional
	public void removeItemCategory(int id) {
		this.itemCategoryDAO.removeItemCategory(id);
	}

}
