package com.dbmsproject.votingsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dbmsproject.votingsystem.model.User;
import com.dbmsproject.votingsystem.service.UserService;

@Controller
public class RegisterController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView registerUser(User newUser) {
		
		ModelAndView registerPage = new ModelAndView("register");
		if(userService.findById(newUser.getUsername()).getUsername() != null) {
			String msg = "Username already exists";
			registerPage.addObject("msg", msg);
			return registerPage;
		}
		else if(!userService.findByEmail(newUser.getEmail()).isEmpty()) {
			String msg = "Email already in use";
			registerPage.addObject("msg", msg);
			return registerPage; 
		}
		else if(!userService.findByPhone(newUser.getPhone()).isEmpty()) {
			String msg = "Phone number already in use";
			registerPage.addObject("msg", msg);
			return registerPage; 
		}
		
		userService.save(newUser);
		System.out.println(newUser);
		return new ModelAndView("login");
	}
	
}
