package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class BalasoreStation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private long stationId;
private String stationName;
private String noOfPlatforms;
private String noSuperFastPassing;
private String nameOfLuxuryTrains;

public long getStationId() {
	return stationId;
}
public void setStationId(long stationId) {
	this.stationId = stationId;
}
public String getStationName() {
	return stationName;
}
public void setStationName(String stationName) {
	this.stationName = stationName;
}
public String getNoOfPlatforms() {
	return noOfPlatforms;
}
public void setNoOfPlatforms(String noOfPlatforms) {
	this.noOfPlatforms = noOfPlatforms;
}
public String getNoSuperFastPassing() {
	return noSuperFastPassing;
}
public void setNoSuperFastPassing(String noSuperFastPassing) {
	this.noSuperFastPassing = noSuperFastPassing;
}
public String getNameOfLuxuryTrains() {
	return nameOfLuxuryTrains;
}
public void setNameOfLuxuryTrains(String nameOfLuxuryTrains) {
	this.nameOfLuxuryTrains = nameOfLuxuryTrains;
}


}
