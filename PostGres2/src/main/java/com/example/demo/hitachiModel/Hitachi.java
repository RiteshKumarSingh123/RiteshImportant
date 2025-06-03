package com.example.demo.hitachiModel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Hitachi {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;
private String products;
private String employeeName;
private String companyAddress;
private String ownerName;
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getProducts() {
	return products;
}
public void setProducts(String products) {
	this.products = products;
}
public String getEmployeeName() {
	return employeeName;
}
public void setEmployeeName(String employeeName) {
	this.employeeName = employeeName;
}
public String getCompanyAddress() {
	return companyAddress;
}
public void setCompanyAddress(String companyAddress) {
	this.companyAddress = companyAddress;
}
public String getOwnerName() {
	return ownerName;
}
public void setOwnerName(String ownerName) {
	this.ownerName = ownerName;
}
@Override
public String toString() {
	return "Hitachi [id=" + id + ", products=" + products + ", employeeName=" + employeeName + ", companyAddress="
			+ companyAddress + ", ownerName=" + ownerName + "]";
}



}
