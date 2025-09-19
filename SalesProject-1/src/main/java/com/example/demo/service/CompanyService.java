package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.dao.CompanyDao;
import com.example.demo.model.AuthRequest;
import com.example.demo.model.Users;
@Service
public class CompanyService {

	
	@Autowired
	private CompanyDao dao;
	
	
	
	public Users getUserData(AuthRequest request) {
		return dao.getUserData(request);
	}
	
	
}
