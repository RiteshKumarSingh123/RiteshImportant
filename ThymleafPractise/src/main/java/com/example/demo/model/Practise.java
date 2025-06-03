package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Practise {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;
private String name;
private String companyName;
private String address;
private String homeTownAddress;
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getCompanyName() {
	return companyName;
}
public void setCompanyName(String companyName) {
	this.companyName = companyName;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getHomeTownAddress() {
	return homeTownAddress;
}
public void setHomeTownAddress(String homeTownAddress) {
	this.homeTownAddress = homeTownAddress;
}


}
