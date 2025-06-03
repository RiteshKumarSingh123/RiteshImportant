package com.example.demo.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;


import com.example.demo.model.Train;

@Service
public interface TrainService {

	public Map<String,String> saveTrain(Train train);
	
	public List<Train> getAllDetailsList(Train train);
	
	public Map<String,String> insertTrain(Train train);
	
	public Map<String,String> updateTrain(Train train);
	
	public Map<String,String> deleteTrain(Train train);
	
	public Train getTrainById(Train train);
	
	
}
