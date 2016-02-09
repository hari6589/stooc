package com.journaldev.spring.dao;

import java.util.List;

import com.journaldev.spring.model.User;

public interface UserDAO {

	public void addUser(User user);
	public void updateUser(User user);
	public List<User> listUsers();
	public User getUserById(int id);
	public void removeUser(int id);
}
