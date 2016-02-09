package com.journaldev.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.journaldev.spring.model.ItemCategory;
import com.journaldev.spring.service.ItemCategoryService;

@Controller
public class ItemCategoryController {
	
	private ItemCategoryService itemCategoryService;
	
	@Autowired(required=true)
	@Qualifier(value="itemCategoryService")
	public void setItemCategoryService(ItemCategoryService itemCategoryService){
		this.itemCategoryService = itemCategoryService;
	}
	
	@RequestMapping(value="/itemCategories", method=RequestMethod.GET)
	public String listItemCategorys(Model model) {
		model.addAttribute("itemCategory", new ItemCategory());
		model.addAttribute("listItemCategories", this.itemCategoryService.listItemCategorys());
		return "itemCategory";
	}
	
	//For add and update itemCategory both
	@RequestMapping(value="/itemCategory/add", method=RequestMethod.POST)
	public String addItemCategory(@ModelAttribute("itemCategory") ItemCategory itemCategory){
		if(itemCategory.getId() == 0){
			//new itemCategory, add it
			this.itemCategoryService.addItemCategory(itemCategory);
		}else{
			//existing itemCategory, call update
			this.itemCategoryService.updateItemCategory(itemCategory);
		}
		return "redirect:/itemCategories";
	}
	
	@RequestMapping("/itemCategory/remove/{id}")
    public String removeItemCategory(@PathVariable("id") int id){
        this.itemCategoryService.removeItemCategory(id);
        return "redirect:/itemCategories";
    }
 
    @RequestMapping("/itemCategory/edit/{id}")
    public String editItemCategory(@PathVariable("id") int id, Model model){
        model.addAttribute("itemCategory", this.itemCategoryService.getItemCategoryById(id));
        model.addAttribute("listItemCategories", this.itemCategoryService.listItemCategorys());
        return "itemCategory";
    }
	
}
