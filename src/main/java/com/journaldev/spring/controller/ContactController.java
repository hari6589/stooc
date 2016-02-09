package com.journaldev.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.journaldev.spring.model.Contact;
import com.journaldev.spring.service.ContactService;

@Controller
public class ContactController {
	
	private ContactService contactService;
	
	@Autowired(required=true)
	@Qualifier(value="contactService")
	public void setContactService(ContactService contactService){
		this.contactService = contactService;
	}
	
	@RequestMapping(value="/contacts", method=RequestMethod.GET)
	public String listContacts(Model model) {
		model.addAttribute("contact", new Contact());
		model.addAttribute("listContacts", this.contactService.listContacts());
		return "contact";
	}
	
	//For add and update contact both
	@RequestMapping(value="/contact/add", method=RequestMethod.POST)
	public String addContact(@ModelAttribute("contact") Contact contact){
		if(contact.getId() == 0){
			//new contact, add it
			this.contactService.addContact(contact);
		}else{
			//existing contact, call update
			this.contactService.updateContact(contact);
		}
		return "redirect:/contacts";
	}
	
	@RequestMapping("/contact/remove/{id}")
    public String removeContact(@PathVariable("id") int id){
        this.contactService.removeContact(id);
        return "redirect:/contacts";
    }
 
    @RequestMapping("/contact/edit/{id}")
    public String editContact(@PathVariable("id") int id, Model model){
        model.addAttribute("contact", this.contactService.getContactById(id));
        model.addAttribute("listContacts", this.contactService.listContacts());
        return "contact";
    }
	
}
