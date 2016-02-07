package com.journaldev.spring.dao;

import java.util.List;

import com.journaldev.spring.model.Contact;

public interface ContactDAO {

	public void addContact(Contact contact);
	public void updateContact(Contact contact);
	public List<Contact> listContacts();
	public Contact getContactById(int id);
	public void removeContact(int id);
}
