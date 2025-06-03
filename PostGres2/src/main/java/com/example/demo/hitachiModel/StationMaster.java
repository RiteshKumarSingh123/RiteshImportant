package com.example.demo.hitachiModel;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class StationMaster {
	private long id;
	private String stationMasterName;
	private String workingHours;
	private String address;
	private List<Hitachi> hitachiList;
	private List<StationMaster> stationMasterList;
	
	
	public List<Hitachi> getHitachiList() {
		return hitachiList;
	}
	public void setHitachiList(List<Hitachi> hitachiList) {
		this.hitachiList = hitachiList;
	}
	public List<StationMaster> getStationMasterList() {
		return stationMasterList;
	}
	public void setStationMasterList(List<StationMaster> stationMasterList) {
		this.stationMasterList = stationMasterList;
	}
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
	
	@Override
	public String toString() {
		return "StationMaster [id=" + id + ", stationMasterName=" + stationMasterName + ", workingHours=" + workingHours
				+ ", address=" + address + "]";
	}

	
}
