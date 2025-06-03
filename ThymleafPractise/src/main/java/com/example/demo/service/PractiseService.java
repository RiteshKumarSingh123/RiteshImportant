package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Practise;
import com.example.demo.repository.PractiseRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PractiseService {

	@Autowired
	private PractiseRepository repo;
	
	public Practise savePractise(Practise practise) {
		Practise saveData = repo.save(practise);
		return saveData;
	}
	
	public List<Practise> getPractiseList(){
		List<Practise> practiseList = repo.findAll();
		return practiseList;
	}
	
	public Practise getPractiseDataById(long id) {
		Practise practise = repo.findById(id).get();
		return practise;
	}
	
	public Practise updatePractise(Practise practise) {
		Practise updateData = new Practise();
		if(practise.getId()>0) {
			updateData.setId(practise.getId());	
			updateData.setName(practise.getName());
			updateData.setCompanyName(practise.getCompanyName());
			updateData.setAddress(practise.getAddress());
			updateData.setHomeTownAddress(practise.getHomeTownAddress());
		}
		Practise data = repo.save(updateData);
		
		return data;
	}
	
	public String deletePractise(long id) {
		repo.deleteById(id);
		return "deleted sucessfully";
	}
	
}
