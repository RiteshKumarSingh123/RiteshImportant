package com.example.demo.Model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Bike {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;
private String name;
private String address;
private String price;
private String companyName;
private String rtoNumber;
private String showRoomName;

public String getCompanyName() {
	return companyName;
}
public void setCompanyName(String companyName) {
	this.companyName = companyName;
}
public String getRtoNumber() {
	return rtoNumber;
}
public void setRtoNumber(String rtoNumber) {
	this.rtoNumber = rtoNumber;
}
public String getShowRoomName() {
	return showRoomName;
}
public void setShowRoomName(String showRoomName) {
	this.showRoomName = showRoomName;
}
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
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getPrice() {
	return price;
}
public void setPrice(String price) {
	this.price = price;
}

@OneToOne(cascade = CascadeType.ALL)
@JoinColumn(name="showRoomId_fk")
private ShowRoom showRoom;

public ShowRoom getShowRoom() {
	return showRoom;
}
public void setShowRoom(ShowRoom showRoom) {
	this.showRoom = showRoom;
}


}
