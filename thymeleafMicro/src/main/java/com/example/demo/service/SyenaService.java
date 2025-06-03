package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Syena;
import com.example.demo.repository.SyenaRepository;

import jakarta.transaction.Transactional;
@Service
@Transactional
public class SyenaService {

	@Autowired
	private SyenaRepository repository;
	
	public Syena saveSyena(Syena syena) {
		Syena data = repository.save(syena);
		return data;
	}
}
