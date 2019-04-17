package com.well.kept.security;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.well.kept.User;

import lombok.Data;

@Data
public class RegistrationForm {
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	
	public User toUser(PasswordEncoder passwordEncoder) {
		return new User(username, passwordEncoder.encode(password), firstName, lastName, email);
	}
}
