package com.example.demo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ShowRoom {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private long showRoomId;
private String showRoomName;
private String showRoomAddress;
private String showRoomAwnerName;
private String totalEmployees;
private String showRoomRepresentingBrand;
public long getId() {
	return showRoomId;
}
public void setId(long showRoomId) {
	this.showRoomId = showRoomId;
}
public String getShowRoomName() {
	return showRoomName;
}
public void setShowRoomName(String showRoomName) {
	this.showRoomName = showRoomName;
}
public String getShowRoomAddress() {
	return showRoomAddress;
}
public void setShowRoomAddress(String showRoomAddress) {
	this.showRoomAddress = showRoomAddress;
}
public String getShowRoomAwnerName() {
	return showRoomAwnerName;
}
public void setShowRoomAwnerName(String showRoomAwnerName) {
	this.showRoomAwnerName = showRoomAwnerName;
}
public String getTotalEmployees() {
	return totalEmployees;
}
public void setTotalEmployees(String totalEmployees) {
	this.totalEmployees = totalEmployees;
}
public String getShowRoomRepresentingBrand() {
	return showRoomRepresentingBrand;
}
public void setShowRoomRepresentingBrand(String showRoomRepresentingBrand) {
	this.showRoomRepresentingBrand = showRoomRepresentingBrand;
}


}
