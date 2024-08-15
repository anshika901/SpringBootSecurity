package com.jwt.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.entities.User;
import com.jwt.services.UserServices;

@RestController
@RequestMapping("/home")
public class Homecontroller {

	@Autowired
	private UserServices userServices;
	
	@GetMapping("/users")
	public List<User> getUser() {
		System.out.println("getting users");
		return this.userServices.getUser();
	}
	
	@GetMapping("/currentUser")
	public String getLoggedInUser(Principal principal){
		return principal.getName();
	}
	
	
}
