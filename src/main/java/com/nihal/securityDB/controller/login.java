package com.nihal.securityDB.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nihal.securityDB.model.users;
import com.nihal.securityDB.service.getUsers;
import com.nihal.securityDB.service.loginservice;

@RestController
public class login {
	@Autowired
	 private loginservice service;
	
	
	@PostMapping("/login")
	public String log(@RequestBody users user)
	{
		return service.verify(user);
	}
	

}
