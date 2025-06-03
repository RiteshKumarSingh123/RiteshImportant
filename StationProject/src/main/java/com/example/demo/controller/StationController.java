package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Station;
import com.example.demo.service.StationService;

@RestController
@RequestMapping("station")
public class StationController {
	
	@Autowired
	private StationService service;
	
	@GetMapping("check")
	public String checkData() {
		return "comming 200 Ok";
	}

	@PostMapping("saveStation")
	public Map<String,String> saveStation(@RequestBody Station station){
		Map<String,String> res = service.saveStation(station);
		return res;
	}
	
	@PostMapping("updateStation")
	public Map<String,String> updateStation(@RequestBody Station station){
		Map<String,String> res = service.updateStation(station);
		return res;
	}
	
	@GetMapping("getStations")
	public List<Station> getStations(@ModelAttribute Station station ){
		List<Station> stationList = service.getStations(station);
		return stationList;
	}
	
	@GetMapping("getStationById")
	public Station getStationById(@ModelAttribute Station station ){
		Station stationData = service.getStationById(station);
		return stationData;
	}
	
	@GetMapping("deleteStationById")
	public Map<String,String> deleteStationById(@RequestParam long id ){
		Map<String,String> deletedRes = service.deleteStationById(id);
		return deletedRes;
	}
	
}
