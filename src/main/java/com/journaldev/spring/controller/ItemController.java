package com.journaldev.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.journaldev.spring.model.Item;
import com.journaldev.spring.service.ItemService;

@Controller
public class ItemController {
	
	private ItemService itemService;
	
	@Autowired(required=true)
	@Qualifier(value="itemService")
	public void setItemService(ItemService itemService){
		this.itemService = itemService;
	}
	
	@RequestMapping(value="/items", method=RequestMethod.GET)
	public String listItems(Model model) {
		model.addAttribute("item", new Item());
		model.addAttribute("listItems", this.itemService.listItems());
		return "item";
	}
	
	//For add and update item both
	@RequestMapping(value="/item/add", method=RequestMethod.POST)
	public String addItem(@ModelAttribute("item") Item item){
		if(item.getId() == 0){
			//new item, add it
			this.itemService.addItem(item);
		}else{
			//existing item, call update
			this.itemService.updateItem(item);
		}
		return "redirect:/items";
	}
	
	@RequestMapping("/item/remove/{id}")
    public String removeItem(@PathVariable("id") int id){
        this.itemService.removeItem(id);
        return "redirect:/items";
    }
 
    @RequestMapping("/item/edit/{id}")
    public String editItem(@PathVariable("id") int id, Model model){
        model.addAttribute("item", this.itemService.getItemById(id));
        model.addAttribute("listItems", this.itemService.listItems());
        return "item";
    }
	
}
