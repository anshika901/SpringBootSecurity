package com.jwt.services;


import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.jwt.dao.UserRepository;
import com.jwt.entities.User;

@Service
public class UserServices {
 
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public UserServices(){
	
	}
	
	public List<User>getUser(){
		return userRepository.findAll();
	}
	public User createUser(User user) {
		
		user.setId(UUID.randomUUID().toString());
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		 return userRepository.save(user);
	}
}
