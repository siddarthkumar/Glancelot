package com.glancelot.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private String name;
private String password;
private String email;
private String mobile;
private String gender;
private String age;
@Column(nullable=true)
@ElementCollection(fetch = FetchType.EAGER)
List<String> chatroomstillnow;

public User()
{
	
}





public User(int id, String name, String password, String email, String mobile, String gender, String age,
		List<String> chatroomstillnow) {
	super();
	this.id = id;
	this.name = name;
	this.password = password;
	this.email = email;
	this.mobile = mobile;
	this.gender = gender;
	this.age = age;
	this.chatroomstillnow = chatroomstillnow;
}


public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getMobile() {
	return mobile;
}
public void setMobile(String phone) {
	this.mobile = phone;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getAge() {
	return age;
}
public void setAge(String age) {
	this.age = age;
}


public int getId() {
	return id;
}


public void setId(int id) {
	this.id = id;
}


public List<String> getChatroomstillnow() {
	return chatroomstillnow;
}


public void setChatroomstillnow(List<String> chatroomstillnow) {
	this.chatroomstillnow = chatroomstillnow;
}





@Override
public String toString() {
	return "User [id=" + id + ", name=" + name + ", password=" + password + ", email=" + email + ", phone=" +mobile
			+ ", gender=" + gender + ", age=" + age + ", chatroomstillnow=" + chatroomstillnow + "]";
}



}
