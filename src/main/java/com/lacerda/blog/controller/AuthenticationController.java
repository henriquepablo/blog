package com.lacerda.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lacerda.blog.infra.security.TokenService;
import com.lacerda.blog.model.AdminUser;
import com.lacerda.blog.model.AuthenticationDTO;
import com.lacerda.blog.model.RegisterDTO;
import com.lacerda.blog.model.ResponseAuthDTO;
import com.lacerda.blog.repositories.AdminUserRepository;

@RestController
@RequestMapping("auth")
public class AuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private AdminUserRepository adminUserRepository;
	
	@Autowired
	TokenService tokenService;
	
	@PostMapping("/login")
	public ResponseEntity login(@RequestBody AuthenticationDTO data) {
		
		var userNamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.password());
		
		var auth = authenticationManager.authenticate(userNamePassword);
		
		var token = tokenService.generateToken((AdminUser) auth.getPrincipal());
		
		AdminUser userAdmin = (AdminUser) adminUserRepository.findByEmail(data.email());

		return ResponseEntity.ok(new ResponseAuthDTO(token, userAdmin.getId()));
	}
	
	@PostMapping("/createNewUserAdmin")
	public ResponseEntity register(@RequestBody RegisterDTO data) {
	
		if (adminUserRepository.findByEmail(data.email()) != null) return ResponseEntity.badRequest().build();
		
		String passwordBcrypt = new BCryptPasswordEncoder().encode(data.password());
		
		AdminUser adminUser = new AdminUser(data.email(), passwordBcrypt, data.role()); 
		
		adminUserRepository.save(adminUser);
		
		return ResponseEntity.ok().build();
	}
}
