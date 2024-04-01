package com.taashee.SpringAssessment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.taashee.SpringAssessment.entity.User;
import com.taashee.SpringAssessment.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;

	@Override
	public UserDetails findByUsername(String username) {
		return userRepo.findByUsername(username);
	}

	@Override
	public User save(User user) {
		return userRepo.save(user);
	}

}
