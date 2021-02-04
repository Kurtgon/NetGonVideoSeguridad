package com.jacaranda.security.model.dto;

import java.time.LocalDateTime;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.jacaranda.security.model.User;
import com.jacaranda.security.model.UserRole;

public class UserDTOConverter {
	
	@Autowired
	private PasswordEncoder passwordEnconder;
	
	public User fromUserDTOToUser(UserDTO dto) {
		User user = new User();
		
		user.setUsername(dto.getUsername());
		user.setPassword(passwordEnconder.encode(dto.getPassword()));
		user.setRoles(Set.of(UserRole.USER));
		user.setCreateTime(LocalDateTime.now());
		user.setUpdateTime(LocalDateTime.now());
		
		return user;
	}
	
	public UserDTO fromUserToUserDTO(User user) {
		
		UserDTO dto = new UserDTO();
		
		dto.setUsername(user.getUsername());
		dto.setPassword(passwordEnconder.encode(user.getPassword()));
		dto.setRoles(user.getRoles());
		
		return dto;
	}

}
