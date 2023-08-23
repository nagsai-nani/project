package com.webapp.project.dao.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.mongodb.client.result.UpdateResult;
import com.webapp.project.dao.UserDao;
import com.webapp.project.models.User;
import com.webapp.project.repository.UserRepository;
import com.webapp.project.request.dto.UserUpdateDto;

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
public List<User> getAll(String key,boolean order) {
	Query query =new  Query();
	if(key!=null) {
		if(order ==true) {
			query.with(Sort.by(Sort.Direction.ASC,key));
		}
		else {
			query.with(Sort.by(Sort.Direction.DESC, key));
		}
	}
return template.find(query,User.class);
}

@Override
public long updateUser(UserUpdateDto dto) {
	Query query =new Query();
	query.addCriteria(Criteria.where("userName").is(dto.getUserName()));
	Update update=new Update();
	update.set("company", dto.getCompany());
	update.set("contactNumber", dto.getContactNumber());
	update.set("email", dto.getEmail());
	update.set("password", dto.getPassword());
	UpdateResult rs=template.updateFirst(query, update, User.class);
	return rs.getModifiedCount();
}

@Override
public List<User> getUserBySearchString(String searchString) {
	Query query =new Query();
	
	query.addCriteria(new Criteria().orOperator
			(Criteria.where("city").regex(searchString),
			(Criteria.where("userName").regex(searchString)),
			(Criteria.where("village").regex(searchString)),
			Criteria.where("company").regex(searchString)));
	return template.find(query, User.class);
}
}
