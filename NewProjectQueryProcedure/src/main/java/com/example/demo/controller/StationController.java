package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.BalasoreStation;
import com.example.demo.model.Common;
import com.example.demo.model.StationMaster;
import com.example.demo.service.StationService;

@RestController
@RequestMapping("/station")
public class StationController {
	
	@Autowired
	private StationService stationService;

	@PostMapping("/saveBalasoreStation")
	public BalasoreStation saveBalasoreStation(@RequestBody BalasoreStation balasoreStation) {
		BalasoreStation blsStation = stationService.saveBalasoreStation(balasoreStation);
		return blsStation;
	}
	
	
	@PostMapping("/saveStation")
	public StationMaster saveStationMaster(@RequestBody StationMaster stationMaster) {
		StationMaster saveResStation = stationService.saveStationMaster(stationMaster);
		return saveResStation;
	}
	
	@GetMapping("/getAllMixData")
	public Common getAllMixData(){
		Common listOfObjectData = stationService.getAllMixData();
		return listOfObjectData;
	}
	
	@GetMapping("/getAllDataById")
	public Common getAllDataById(@RequestParam("stationId") long stationId) {
		Common dataById = stationService.getAllDataById(stationId);
		return dataById;
	}
	
}
