package com.nihal.securityDB.service;

import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties.Jwt;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JWTservice {
	
	private String secretkey="";
	
	public JWTservice() throws NoSuchAlgorithmException
	{
		KeyGenerator keygen=KeyGenerator.getInstance("HmacSHA256");
		SecretKey sk=keygen.generateKey();
		secretkey=Base64.getEncoder().encodeToString(sk.getEncoded());
		
		
		
	}

	public String generatetoken(String username) {
		Map<String,Object> claims=new HashMap<>();	
		return Jwts.builder()
				.claims()
				.add(claims)
				.subject(username)
				.issuedAt(new Date(System.currentTimeMillis()))
				.expiration(new Date(System.currentTimeMillis()+1000 * 60 * 30))
				.and()
				.signWith(getkey())
				.compact();
		
	}

	private Key getkey() {
        byte[] keyBytes = Base64.getDecoder().decode(secretkey);
        return Keys.hmacShaKeyFor(keyBytes);
    }
	

}
