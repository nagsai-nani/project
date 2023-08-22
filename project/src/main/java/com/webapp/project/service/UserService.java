package com.webapp.project.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webapp.project.dao.UserDao;
import com.webapp.project.models.User;
import com.webapp.project.response.dto.UserResponse;

@Service
public class UserService {
@Autowired
UserDao dao;

public User save(User user) throws Exception {
	User bean =dao.getByUserName(user.getUserName());
	if(bean!=null) {
		throw new Exception("USER  "+bean.getUserName()+"  ALREADY EXIST. DUPLICATES ARE NOT ALLOWED");
	}
	if(user.getCompany()==null||user.getCompany().isEmpty()) {
		user.setCompany("VNC IT INSTITUTE");
	}
	
	return dao.save(user);
}

public UserResponse getUser(String userName) {
	List<User> users=dao.getUserName(userName);
	UserResponse resp=null;
	for (User user : users) {
		resp=new UserResponse();
		resp.setCity(user.getCity());
		resp.setEmail(user.getEmail());
		resp.setPincode(user.getPincode());
		resp.setVillage(user.getVillage());
		resp.setUserName(user.getUserName());
	}
	return resp;
}

public List<UserResponse> getAll() {
	
	List<User> users =dao.getAll();
	List<UserResponse> response =new ArrayList<UserResponse>();
	UserResponse resp=null;
	for (User user : users) {
		resp=new UserResponse();
		resp.setCity(user.getCity());
		resp.setEmail(user.getEmail());
		resp.setPincode(user.getPincode());
		resp.setVillage(user.getVillage());
		resp.setUserName(user.getUserName());
		response.add(resp);
	}
	return response;
}

}
