package com.example.demo.hitachiController;

import java.util.List;
import java.util.Optional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.hitachiInterface.HitachiInterface;
import com.example.demo.hitachiModel.Hitachi;
import com.example.demo.hitachiModel.StationMaster;

@RestController
@RequestMapping("hitachi")
public class HitachiController {
	
	@Autowired
	private HitachiInterface hitachiInterface;

	@PostMapping("saveHitachi")
	public Hitachi saveHitachi(@RequestBody Hitachi hitachi) {
		Hitachi saveData = hitachiInterface.saveHitachi(hitachi);
		return saveData;
	}
	
	@GetMapping("getAllHitachi")
	public List<Hitachi> getAllHitachi() {
		List<Hitachi> getAllData = hitachiInterface.getAllHitachi();
		return getAllData;
	}
	
	@GetMapping("getHitachiById")
	public Optional<Hitachi> getHitachiById(@RequestParam("id") long id) {
		Optional<Hitachi> getAllData = hitachiInterface.getHitachiById(id);
		return getAllData;
	}
	
	@GetMapping("getHitachiData")
	public StationMaster getHitachiData(){
		StationMaster hitachiList = hitachiInterface.getHitachiData();
			return hitachiList;
		}
	
	
	
	
}
