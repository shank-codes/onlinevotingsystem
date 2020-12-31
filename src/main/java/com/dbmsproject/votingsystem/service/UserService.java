package com.dbmsproject.votingsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.dbmsproject.votingsystem.doa.UserRepo;
import com.dbmsproject.votingsystem.model.User;

@Service
public class UserService {
	
	@Autowired
	private UserRepo userRepo;
	
	
	public User findById(String username) {
		return userRepo.findById(username).orElse(new User());
	}
	
	public User save(User newUser) {
		
		return userRepo.save(newUser);
	}

	public List<User> findByEmail(String email) {
		return userRepo.findByEmail(email);
	}

	public List<User> findByPhone(String phone) {
		return userRepo.findByPhone(phone);
	}
}
