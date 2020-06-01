package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository repo;

	public UserService(UserRepository repo) {
		super();
		this.repo = repo;
	}
	
	public UserService() {
		
	}
	
	
}
