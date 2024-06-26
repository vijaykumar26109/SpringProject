package com.taashee.SpringAssessment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.taashee.SpringAssessment.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	UserDetails findByUsername(String username);

}
