package com.jacaranda.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.jacaranda.security.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	public Optional<User> findByUsername(String Username);

}
