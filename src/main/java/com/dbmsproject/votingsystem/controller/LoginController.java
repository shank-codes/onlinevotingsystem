package com.dbmsproject.votingsystem.controller;

import java.net.http.HttpRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dbmsproject.votingsystem.model.User;
import com.dbmsproject.votingsystem.service.ElectionService;
import com.dbmsproject.votingsystem.service.UserService;

@Controller
public class LoginController {

	HttpSession session;
	
	@Autowired
	private ElectionService electionService;
	@Autowired
	private UserService userService;
	
	@RequestMapping("/")
	public String showLogin() {
		return "login";
	}
	
	@RequestMapping("register")
	public String showRegister() {
		return "register";
	}
	
	@RequestMapping(value = "/authorise", method = RequestMethod.POST)
	public ModelAndView authorise(@RequestParam String username, @RequestParam String password, HttpServletRequest request) {
		ModelAndView home = new ModelAndView("home");
		
		User user = userService.findById(username);
		String msg;
		if(user.getUsername() == null) {
			msg = "Invalid User";
			System.out.println(msg);
			return new ModelAndView("login").addObject("msg", msg);
		}
		else if(!user.getUsername().equals(username) || !user.getPassword().equals(password)) {
			msg = "Invalid Username/Password";
			System.out.println(msg);
			return new ModelAndView("login").addObject("msg", msg);
		}
		
		session = request.getSession();
		session.setAttribute("user", user);
		System.out.println(session.getAttribute("user"));
		
		
		home.addObject("user", user);
		home.addObject("electionList", electionService.getAllElections());
		return home;
	}
}
