package com.jacaranda.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jacaranda.security.model.User;
import com.jacaranda.security.model.dto.UserDTO;
import com.jacaranda.security.model.dto.UserDTOConverter;
import com.jacaranda.security.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserDTOConverter userDTOConverter;

	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		return	userRepository.findByUsername(username)
		.orElseThrow(()-> new UsernameNotFoundException("Username not found"));
	}
	
	
	public User createUser (UserDTO dto) {
		
		return userRepository.save(userDTOConverter.fromUserDTOToUser(dto));
	}

}
