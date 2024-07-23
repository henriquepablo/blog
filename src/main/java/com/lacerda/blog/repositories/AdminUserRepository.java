package com.lacerda.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.lacerda.blog.model.AdminUser;

@Repository
public interface AdminUserRepository extends JpaRepository<AdminUser, Integer>{
	
	UserDetails findByEmail(String email);
}
