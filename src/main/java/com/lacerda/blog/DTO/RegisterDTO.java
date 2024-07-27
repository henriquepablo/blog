package com.lacerda.blog.DTO;

import com.lacerda.blog.model.UserRole;

public record RegisterDTO(String email, String password, UserRole role) {

}
