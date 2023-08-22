package com.webapp.project.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.webapp.project.dao.UserDao;
import com.webapp.project.models.User;
import com.webapp.project.repository.UserRepository;

@Repository
public class UserDaoImpl implements UserDao{
@Autowired
MongoTemplate template;
@Autowired
UserRepository repo;

@Override
	public User save(User user) {
		return repo.save(user);
	}

@Override
public User getByUserName(String userName) {
	Query query =new Query();
	query.addCriteria(Criteria.where("userName").is(userName));
	return template.findOne(query, User.class);
}


@Override
public List<User> getUserName(String userName) {
	Query query =new Query();
	query.addCriteria(Criteria.where("userName").is(userName));
	return template.find(query, User.class);
}

@Override
public List<User> getAll() {
return template.findAll(User.class);
}
}
