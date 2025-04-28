package com.nihal.securityDB.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.nihal.securityDB.model.users;
import com.nihal.securityDB.repo.userRepo;

@Service
public class registerservice {
	@Autowired
	private userRepo repo;
	
	private  BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(12);

	public users adduservice(users user) {
		user.setPassword(encoder.encode(user.getPassword()));
		return repo.save(user);
	}

}
