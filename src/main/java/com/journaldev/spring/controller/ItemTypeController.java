package com.journaldev.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.journaldev.spring.model.ItemType;
import com.journaldev.spring.service.ItemTypeService;

@Controller
public class ItemTypeController {
	
	private ItemTypeService itemTypeService;
	
	@Autowired(required=true)
	@Qualifier(value="itemTypeService")
	public void setItemTypeService(ItemTypeService ps){
		this.itemTypeService = ps;
	}
	
	@RequestMapping(value="/itemTypes", method=RequestMethod.GET)
	public String listItemTypes(Model model) {
		model.addAttribute("itemType", new ItemType());
		model.addAttribute("listItemTypes", this.itemTypeService.listItemTypes());
		return "itemType";
	}
	
	//For add and update itemType both
	@RequestMapping(value="/itemType/add", method=RequestMethod.POST)
	public String addItemType(@ModelAttribute("itemType") ItemType itemType){
		if(itemType.getId() == 0){
			//new itemType, add it
			this.itemTypeService.addItemType(itemType);
		}else{
			//existing itemType, call update
			this.itemTypeService.updateItemType(itemType);
		}
		return "redirect:/itemTypes";
	}
	
	@RequestMapping("/itemType/remove/{id}")
    public String removeItemType(@PathVariable("id") int id){
        this.itemTypeService.removeItemType(id);
        return "redirect:/itemTypes";
    }
 
    @RequestMapping("/itemType/edit/{id}")
    public String editItemType(@PathVariable("id") int id, Model model){
        model.addAttribute("itemType", this.itemTypeService.getItemTypeById(id));
        model.addAttribute("listItemTypes", this.itemTypeService.listItemTypes());
        return "itemType";
    }
	
}
