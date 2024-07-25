package com.lacerda.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.lacerda.blog.repositories.AdminUserRepository;

@Service
public class AuthorizationService implements UserDetailsService{

	@Autowired
	AdminUserRepository AdminUserRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		return AdminUserRepository.findByEmail(username);
	}

}
