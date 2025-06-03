package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class StationMaster {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;
private String stationMasterName;
private String workingHours;
private String address;


public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getStationMasterName() {
	return stationMasterName;
}
public void setStationMasterName(String stationMasterName) {
	this.stationMasterName = stationMasterName;
}
public String getWorkingHours() {
	return workingHours;
}
public void setWorkingHours(String workingHours) {
	this.workingHours = workingHours;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}


}
