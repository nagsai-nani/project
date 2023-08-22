package com.webapp.project.dao;

import java.util.List;

import com.webapp.project.models.User;

public interface UserDao {

	User save(User user);

	User getByUserName(String userName);
	
	List<User> getUserName(String userName);

	List<User> getAll();
	

}
