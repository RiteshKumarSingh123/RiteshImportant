package com.example.demo.service;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

import com.example.demo.model.Station;

@Service
public interface StationService {
	
	public Map<String,String> saveStation(Station station);
	
	public Map<String,String> updateStation(Station station);
	
	public List<Station> getStations(Station station );
	
	public Station getStationById(Station station );
	
	public Map<String,String> deleteStationById(long id );
}
