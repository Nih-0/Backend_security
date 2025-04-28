package com.nihal.securityDB.controller;

import java.net.http.HttpRequest;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nihal.securityDB.model.greet;
import com.nihal.securityDB.model.users;
import com.nihal.securityDB.service.getUsers;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class Mycontroller {
	
	@Autowired
	private getUsers service;
	
	@GetMapping("/")
	public long fetchuser()
	
	{
		return service.fetch();
	}
	@GetMapping("/all")
	public  List<users> getallUsers()
	{
		return service.ret();
	}
	@GetMapping("/user/{id}")
	public users getspecificuser(@PathVariable int id)
	{
		return service.getuser(id);
	}
	@PostMapping("/user")
	public users adduser(@RequestBody users user)
	{
		return service.adduser(user);
	}
	@GetMapping("/csrf")
	public CsrfToken csrf(HttpServletRequest request)
	{
		return (CsrfToken) request.getAttribute("_csrf");
		
	}
	
	
	
	

}
