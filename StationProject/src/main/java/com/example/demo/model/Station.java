package com.example.demo.model;

import org.springframework.stereotype.Component;

@Component
public class Station {
	private long id;
	private String stationName;
	private long stationPlatform;
	private long totalTrainHaults;
	private long numberOfExpress;
	private long numberOfSuperFast;
	private long numberOfLuxuryTrain;
	private String staionConnectingWith;
	private long active;
	
	
	public long getActive() {
		return active;
	}
	public void setActive(long active) {
		this.active = active;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getStationName() {
		return stationName;
	}
	public void setStationName(String stationName) {
		this.stationName = stationName;
	}
	public long getStationPlatform() {
		return stationPlatform;
	}
	public void setStationPlatform(long stationPlatform) {
		this.stationPlatform = stationPlatform;
	}
	public long getTotalTrainHaults() {
		return totalTrainHaults;
	}
	public void setTotalTrainHaults(long totalTrainHaults) {
		this.totalTrainHaults = totalTrainHaults;
	}
	public long getNumberOfExpress() {
		return numberOfExpress;
	}
	public void setNumberOfExpress(long numberOfExpress) {
		this.numberOfExpress = numberOfExpress;
	}
	public long getNumberOfSuperFast() {
		return numberOfSuperFast;
	}
	public void setNumberOfSuperFast(long numberOfSuperFast) {
		this.numberOfSuperFast = numberOfSuperFast;
	}
	public long getNumberOfLuxuryTrain() {
		return numberOfLuxuryTrain;
	}
	public void setNumberOfLuxuryTrain(long numberOfLuxuryTrain) {
		this.numberOfLuxuryTrain = numberOfLuxuryTrain;
	}
	public String getStaionConnectingWith() {
		return staionConnectingWith;
	}
	public void setStaionConnectingWith(String staionConnectingWith) {
		this.staionConnectingWith = staionConnectingWith;
	}

	@Override
	public String toString() {
		return "Station [id=" + id + ", stationName=" + stationName + ", stationPlatform=" + stationPlatform
				+ ", totalTrainHaults=" + totalTrainHaults + ", numberOfExpress=" + numberOfExpress + ", numberOfSuperFast="
				+ numberOfSuperFast + ", numberOfLuxuryTrain=" + numberOfLuxuryTrain + ", staionConnectingWith="
				+ staionConnectingWith + "]";
	}




}
