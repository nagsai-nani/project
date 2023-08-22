package com.webapp.project.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.webapp.project.models.User;

public interface UserRepository extends MongoRepository<User, String> {

}
