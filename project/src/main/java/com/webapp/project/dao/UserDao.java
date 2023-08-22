package com.webapp.project.dao;

import java.util.List;

import com.webapp.project.models.User;
import com.webapp.project.request.dto.UserUpdateDto;

public interface UserDao {

	User save(User user);

	User getByUserName(String userName);
	
	List<User> getUserName(String userName);

	List<User> getAll();

	long updateUser(UserUpdateDto dto);

	
	

}
