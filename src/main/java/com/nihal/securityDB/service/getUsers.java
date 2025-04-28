package com.nihal.securityDB.service;

import java.net.Authenticator;
import java.util.List;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.nihal.securityDB.model.users;
import com.nihal.securityDB.repo.userRepo;

@Service
public class getUsers {
	
	@Autowired
	private userRepo repo;
	
	public long fetch()
	{
		return repo.count();
	}
	public List<users> ret()
		{
			return repo.findAll();
		}
	public users getuser(int id) {
		return repo.findById(id).orElse(null);

	}
	public users adduser(users user)
	{
		return repo.save(user);
	}
	
	

}
