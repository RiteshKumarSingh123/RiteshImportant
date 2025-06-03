package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Syena;
import com.example.demo.service.SyenaService;

@RestController
@RequestMapping("/syena")
public class SyenaController {
	
	@Autowired
	private SyenaService service;
	
	@GetMapping("/getData")
	public String register(Model  model) {
		model.addAttribute("syena", new Syena());
		return "register";
	}

	@PostMapping("/saveSyena")
	public String saveSyena(@RequestBody Syena syena,Model model) {
		Syena syenaData = service.saveSyena(syena);
		model.addAttribute("syena",syena);
		return "register";
	}
}
