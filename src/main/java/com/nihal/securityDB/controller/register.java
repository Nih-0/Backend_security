package com.nihal.securityDB.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nihal.securityDB.model.users;
import com.nihal.securityDB.service.registerservice;

@RestController
public class register {
	
	@Autowired
	private registerservice service;
	
	@PostMapping("/register")
	public users register(@RequestBody users user)
	{
		return service.adduservice(user);
	}

}
