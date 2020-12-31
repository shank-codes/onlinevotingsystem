package com.dbmsproject.votingsystem.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dbmsproject.votingsystem.model.Candidate;
import com.dbmsproject.votingsystem.model.CandidateVoterId;
import com.dbmsproject.votingsystem.model.Election;
import com.dbmsproject.votingsystem.model.User;
import com.dbmsproject.votingsystem.service.CandidateService;
import com.dbmsproject.votingsystem.service.ElectionService;
import com.dbmsproject.votingsystem.service.UserService;

@Controller
public class CreateElectionController {

	
	@Autowired
	ElectionService electionService;
	@Autowired
	UserService userService;
	@Autowired
	CandidateService candidateService;
	
	@RequestMapping(value = "/saveelection", method = RequestMethod.POST)
	public ModelAndView registerElection(@RequestParam String name, @RequestParam Integer noOfCandidates, @RequestParam String candidateList,
			@RequestParam String password, HttpServletRequest request) {
		
		if(request.getSession().getAttribute("user") == null) {
			return new ModelAndView("login");
		}
		
		System.out.println("election saved");
		System.out.println(request.getSession().getAttribute("user"));
		
		User admin = (User)request.getSession().getAttribute("user");
	
		Election newElection = new Election();
		newElection.setEname(name);
		newElection.setePassword(password);
		newElection.setAdmin(admin);
		newElection.seteStatus(true);
		newElection.setNoOfCandidates(noOfCandidates);
		newElection.setNoOfVoters(0);		
		
		String[] candidates = candidateList.split(",", noOfCandidates);
		
		System.out.println(candidates);
		
		ModelAndView reload = new ModelAndView("createElection");
		String message = "Please enter valid candidates. Note: Election admin cannot be a candidate.";
		reload.addObject("msg", message);
		
		if(candidates.length != noOfCandidates) {
			return reload;
		}
		for(int i = 0; i < noOfCandidates; i++) {
			User candidate = userService.findById(candidates[i]);
			if(candidate.getUsername() == null || candidate.getUsername().equals(admin.getUsername()) ) {
				return reload;
			}
		}
		
		electionService.save(newElection);
		
		for(int i = 0; i < noOfCandidates; i++) {
			Candidate newCandidate = new Candidate(new CandidateVoterId(candidates[i], newElection.getEid()), 
					newElection, userService.findById(candidates[i]), 0);
			candidateService.save(newCandidate);
		}
		
		ModelAndView home = new ModelAndView("home");
		home.addObject("user", newElection.getAdmin());
		home.addObject("electionList", electionService.getAllElections());
		return home;
	}
}
