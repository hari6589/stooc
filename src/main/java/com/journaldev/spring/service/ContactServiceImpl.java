package com.journaldev.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.journaldev.spring.dao.ContactDAO;
import com.journaldev.spring.model.Contact;

@Service
public class ContactServiceImpl implements ContactService {
	
	private ContactDAO contactDAO;

	public void setContactDAO(ContactDAO contactDAO) {
		this.contactDAO = contactDAO;
	}

	@Override
	@Transactional
	public void addContact(Contact contact) {
		this.contactDAO.addContact(contact);
	}

	@Override
	@Transactional
	public void updateContact(Contact contact) {
		this.contactDAO.updateContact(contact);
	}

	@Override
	@Transactional
	public List<Contact> listContacts() {
		return this.contactDAO.listContacts();
	}

	@Override
	@Transactional
	public Contact getContactById(int id) {
		return this.contactDAO.getContactById(id);
	}

	@Override
	@Transactional
	public void removeContact(int id) {
		this.contactDAO.removeContact(id);
	}

}
