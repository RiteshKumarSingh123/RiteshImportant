package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.AuthRequest;
import com.example.demo.model.Users;
import com.example.demo.service.OpenPositionService;

@RestController
@RequestMapping("/position")
public class OpenPositionController {
	
	@Autowired
    private	OpenPositionService openPositionService;
	 
	 @PostMapping("/login")
		public Users getUserData(@RequestBody AuthRequest authRequest){
			System.out.println(authRequest.getUserName()+"**********************************");
			Users response = openPositionService.getUserData(authRequest);
		return response;
		}

}
