package com.example.demo.model;

import org.springframework.stereotype.Component;

@Component
public class Common {
private StationMaster stationMaster;
private BalasoreStation balasoreStation;
public StationMaster getStationMaster() {
	return stationMaster;
}
public void setStationMaster(StationMaster stationMaster) {
	this.stationMaster = stationMaster;
}
public BalasoreStation getBalasoreStation() {
	return balasoreStation;
}
public void setBalasoreStation(BalasoreStation balasoreStation) {
	this.balasoreStation = balasoreStation;
}


}
