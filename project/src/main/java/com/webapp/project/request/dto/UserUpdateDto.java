package com.webapp.project.request.dto;

public class UserUpdateDto {
private String userName;
private String password;
private String email;
private String company;
private String contactNumber;

public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getCompany() {
	return company;
}
public void setCompany(String company) {
	this.company = company;
}
public String getContactNumber() {
	return contactNumber;
}
public void setContactNumber(String contactNumber) {
	this.contactNumber = contactNumber;
}



}
