package com.employeeManagement.config;

import java.security.Key;
import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {

	private static final String SECRET = "mysecretkeyforemployeemanagementmysecretkey";
	
	private static final Key key = Keys.hmacShaKeyFor(SECRET.getBytes());
	
	private static final long EXPIRATION = 1000 * 60 * 60 * 12; // 12hrs
	
	public String generateToken(String employeeId) {
		
		return Jwts.builder()
				.setSubject(employeeId)
				.setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
				.signWith(key, SignatureAlgorithm.HS256)
				.compact();
	}
	
	public String extractEmployeeId(String token) {
		
		return Jwts.parserBuilder()
				.setSigningKey(key)
				.build()
				.parseClaimsJws(token)
				.getBody()
				.getSubject();
	}
	
	public boolean validateToken(String token) {
		
		return !isTokenExpired(token);
	}
	private boolean isTokenExpired(String token) {
		
		return Jwts.parserBuilder()
				.setSigningKey(key)
				.build()
				.parseClaimsJws(token)
				.getBody()
				.getExpiration()
				.before(new Date());
	}
	
}
