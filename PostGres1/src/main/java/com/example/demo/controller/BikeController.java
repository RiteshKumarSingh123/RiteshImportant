package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Bike;
import com.example.demo.service.BikeService;

@RestController
@RequestMapping("bike")
public class BikeController {
	
	@Autowired BikeService bikeService;
	
	@GetMapping("testbike")
	public String test() {
		return "w";
	}

	@PostMapping("saveBike")
	public Bike saveBike(@RequestBody Bike bike) {
		Bike saveData = bikeService.saveBike(bike);
		return saveData;
	}
	
	@PostMapping("saveAllBike")
	public List<Bike> saveAllBike(@RequestBody List<Bike> bikeList){
		List<Bike> bikeListData = bikeService.saveAllBike(bikeList);
		return bikeListData;
	}
	
	@GetMapping("getBike/{id}")
	public Bike getBikeById(@PathVariable("id") long id) {
		Bike detailsbyId = bikeService.getBikeById(id);
		return detailsbyId;
	}
	
	@GetMapping("getAllBikes")
	public List<Bike> getAllBikes(){
		List<Bike> bikeList = bikeService.getAllBikes();
		return bikeList;
	}
	
	@PutMapping("updateBike/{id}")
	public Bike updateBike(@PathVariable("id") long id,@RequestBody Bike bike) {
		Bike updateData = bikeService.updateBike(id,bike);
		return updateData;
	}
	
	@DeleteMapping("deleteBike/{id}")
	public Map<String,String> deleteBike(@PathVariable("id") long id){
		Map<String,String> deletedResponse = bikeService.deleteBike(id);	
		return deletedResponse;
	}
	
	@DeleteMapping("deleteAllBike")
	public Map<String,String> deleteAllBike(){
		Map<String,String> deletedResponse = bikeService.deleteAllBike();	
		return deletedResponse;
	}
	
	@GetMapping("checkExists/{id}")
	public Map<String,String> getRecordExists(@PathVariable("id") long id){
		Map<String,String> exits = bikeService.getRecordExists(id);	
		return exits;	
	}
	
	@PostMapping("insertBike")
	public Map<String,String> insertBike(@RequestBody Bike bike) {
		Map<String,String> saveData = bikeService.insertBike(bike);
		return saveData;
	}
	
	@PostMapping("updateBike")
	public Map<String,String> updateBike(@RequestBody Bike bike) {
		Map<String,String> updateData = bikeService.updateBike(bike);
		return updateData;
	}
	
	@GetMapping("getBikeList")
	public List<Bike> getBikeList(){
		List<Bike> bikeList = bikeService.getBikeList();
		return bikeList;
	}
	
	@GetMapping("getBikeById")
	public Bike getBikeByIds(@RequestParam("id") long id) {
		Bike bike = bikeService.getBikeByIds(id);
		return bike;
	}
	
	@GetMapping("deleteById")
	public Map<String,String> deleteBikeById(@RequestParam("id") long id){
		Map<String,String> deletedResponse = bikeService.deleteBikeById(id);	
		return deletedResponse;
	}
	
	@GetMapping("listOfBike")
	public List<Object[]> getListOfBike(){
	List<Object[]> bikeList = bikeService.getListOfBike();
	return bikeList;
	}
	
}
