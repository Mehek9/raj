package com.example.Entity;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="registration")
public class User {

	
@Id
@Column
@GeneratedValue(strategy = GenerationType.AUTO)
private int id;
@Column
@NonNull
private String name;
@Column
@NonNull
private String email;
@Column
@NonNull
private String organization;
@Column
@NonNull
private String password;
public User(int id, String name, String email, String organization, String password) {
	
	this.id = id;
	this.name = name;
	this.email = email;
	this.organization = organization;
	this.password = password;
}

public User( String name, String email, String organization, String password) {
	
	
	this.name = name;
	this.email = email;
	this.organization = organization;
	this.password = password;
}
public User() {

}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
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
public String getOrganization() {
	return organization;
}
public void setOrganization(String organization) {
	this.organization = organization;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
@Override
public String toString() {
	return "User [id=" + id + ", name=" + name + ", email=" + email + ", organization=" + organization + ", password="
			+ password + "]";
}



}
