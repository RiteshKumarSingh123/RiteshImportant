package com.example.demo.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;


import com.example.demo.Model.Bike;

import jakarta.transaction.Transactional;

@Service
public interface BikeService {
 
	public Bike saveBike(Bike bike);
	
	public List<Bike> saveAllBike(List<Bike> bikeList);
	
	public Bike getBikeById(long id);
	
	public List<Bike> getAllBikes();
	
	public Bike updateBike(long id,Bike bike);
	
	public Map<String,String> deleteBike(long id);
	
	public Map<String,String> deleteAllBike();
	
	public Map<String,String> getRecordExists(long id);
	
	public Map<String,String> insertBike(Bike bike);
	
	public Map<String,String> updateBike(Bike bike);
	
	public List<Bike> getBikeList();
	
	public Bike getBikeByIds(long id);
	
	public Map<String,String> deleteBikeById(long id);
	
	public List<Object[]> getListOfBike();
	
}
