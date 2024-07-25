package com.lacerda.blog.infra.security;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.lacerda.blog.model.AdminUser;

@Service
public class TokenService {

	@Value("${api.security.token.secret}")
	private String secret;
	
	public String generateToken(AdminUser adminUser) {
		
		try {
			Algorithm algorithm = Algorithm.HMAC256(secret);
			
			String token = JWT.create()
					.withIssuer("api-blog")
					.withSubject(adminUser.getEmail())
					.withExpiresAt(getExpirationDate())
					.sign(algorithm);
			return token;
		} 
		catch (JWTCreationException e) {
			throw new RuntimeException("Error with generate token", e);
		}
	}
	
	public String verifyToken(String token) {
		
		try {
			Algorithm algorithm = Algorithm.HMAC256(secret);
			
			return JWT.require(algorithm)
					.withIssuer("api-blog")
					.build()
					.verify(token)
					.getSubject();
			
		} catch (JWTVerificationException e) {
			return "";
		}
	}
	
	private Instant getExpirationDate() {
		return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
	}
}
