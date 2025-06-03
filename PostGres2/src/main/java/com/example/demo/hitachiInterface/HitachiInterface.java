package com.example.demo.hitachiInterface;

import java.util.List;
import java.util.Optional;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.example.demo.hitachiModel.Hitachi;
import com.example.demo.hitachiModel.StationMaster;

@Service
public interface HitachiInterface {

	public Hitachi saveHitachi(Hitachi hitachi);
	
	public List<Hitachi> getAllHitachi();
	
	public Optional<Hitachi> getHitachiById(long id);
	
	public StationMaster getHitachiData();
	
	
}
