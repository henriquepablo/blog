package com.lacerda.blog.model;

public enum UserRole {
	
	ADMIN;
	
	private String role;
	
	void userRole(String role) {
		this.role = role;
	}
	
	public String getRole() {
		return role;
	}
}
