package com.taashee.SpringAssessment.service;

import org.springframework.security.core.userdetails.UserDetails;

import com.taashee.SpringAssessment.entity.User;

public interface UserService {
	UserDetails findByUsername(String username);
	User save(User user);
}
