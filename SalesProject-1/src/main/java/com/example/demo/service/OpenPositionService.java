package com.example.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.dao.OpenPositionDao;
import com.example.demo.model.AuthRequest;
import com.example.demo.model.Users;
@Service
public class OpenPositionService {

	
	@Autowired
	private OpenPositionDao openPositionDao;
	
	
	
	public Users getUserData(AuthRequest request) {
		return openPositionDao.getUserData(request);
	}
	
}
