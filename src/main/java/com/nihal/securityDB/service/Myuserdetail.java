package com.nihal.securityDB.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.nihal.securityDB.model.userprinciple;
import com.nihal.securityDB.model.users;
import com.nihal.securityDB.repo.userRepo;


@Service
public class Myuserdetail implements UserDetailsService {

	@Autowired
	private userRepo repo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		users user=repo.findByUsername(username);
		if(user==null)
		{
			System.out.println("user not found");
			throw new UsernameNotFoundException("user not found");
		}
		return new userprinciple(user);
	}

}
