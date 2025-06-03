package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Train;
import com.example.demo.service.TrainService;

@RestController
@RequestMapping("train")
public class TrainController {
	
	@Autowired
	private TrainService service;

	@PostMapping("saveTrain")
	public Map<String,String> saveTrain(@RequestBody Train train){
		Map<String,String> mapData = service.saveTrain(train);
		return mapData;
	}
	
	@GetMapping("getAllDetailsList")
	public List<Train> getAllDetailsList(@ModelAttribute Train train){
		List<Train> mapList = service.getAllDetailsList(train);
		return mapList;
	}
	
	@PostMapping("insertTrain")
	public Map<String,String> insertTrain(@RequestBody Train train){
		Map<String,String> mapData = service.insertTrain(train);
		return mapData;
	}
	
	@PostMapping("updateTrain")
	public Map<String,String> updateTrain(@RequestBody Train train){
		Map<String,String> mapData = service.updateTrain(train);
		return mapData;
	}
	
	@GetMapping("deleteTrain")
	public Map<String,String> deleteTrain(@ModelAttribute Train train){
		Map<String,String> mapData = service.deleteTrain(train);
		return mapData;
	}
	
	@GetMapping("getTrainById")
	public Train getTrainById(@ModelAttribute Train train){
		Train trainDataById = service.getTrainById(train);
		return trainDataById;
	}
	
}
