package com.webapp.project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webapp.project.models.User;
import com.webapp.project.request.dto.LoginDto;
import com.webapp.project.response.dto.UserResponse;
import com.webapp.project.service.UserService;

@RestController
@RequestMapping("/rest/user")
public class UserController {
	@Autowired
	UserService service;
	
	@PostMapping("/save")
	public ResponseEntity<User> saveUser(@RequestBody User user) throws Exception{
		return ResponseEntity.ok(service.save(user));
	}
	
	@GetMapping("/get/{userName}")
	public ResponseEntity<UserResponse> getByUser(@PathVariable String userName){
		return ResponseEntity.ok(service.getUser(userName));
	}
	
	@GetMapping("/get/all")
	public ResponseEntity<List<UserResponse>> getAll(){
		return ResponseEntity.ok(service.getAll());
	}
	
	@PostMapping("/login")
	public ResponseEntity<UserResponse> login(@RequestBody LoginDto dto) throws Exception{
		return ResponseEntity.ok(service.login(dto));	
	}
}
