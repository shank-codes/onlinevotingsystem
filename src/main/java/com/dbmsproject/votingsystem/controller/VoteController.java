package com.dbmsproject.votingsystem.controller;

import java.util.List;

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
import com.dbmsproject.votingsystem.model.Voter;
import com.dbmsproject.votingsystem.service.CandidateService;
import com.dbmsproject.votingsystem.service.ElectionService;
import com.dbmsproject.votingsystem.service.UserService;
import com.dbmsproject.votingsystem.service.VoterService;


@Controller
public class VoteController {
	
	@Autowired
	VoterService voterService;
	@Autowired
	ElectionService electionService;
	@Autowired
	CandidateService candidateService;
	@Autowired
	UserService userService;

	@RequestMapping(value="/savevote", method=RequestMethod.GET)
	public ModelAndView saveVote(@RequestParam("eid") Integer eid, @RequestParam("cid") String cid, HttpServletRequest request) {
		
		if(request.getSession().getAttribute("user") == null) {
			return new ModelAndView("login");
		}
		
		ModelAndView votePageUpdate = new ModelAndView("vote");
		
		Election election = electionService.getById(eid);
		User user = (User)request.getSession().getAttribute("user");
		CandidateVoterId voterId = new CandidateVoterId(user.getUsername(), eid);
		CandidateVoterId candidateId = new CandidateVoterId(cid, eid);
		
		Voter voter = voterService.getById(voterId);
		
		String msg;
		if(voter.getVoterId() == null) {
			voter = new Voter(voterId, userService.findById(cid), user, election);
			voterService.save(voter);
			msg = "Your vote has been saved";
			votePageUpdate.addObject("savemsg", msg);
			
			Candidate candidate = candidateService.getById(candidateId);
			if(candidate.getCandidateId() != null) {
				candidate.setNoOfVotes(candidate.getNoOfVotes()+1);
				candidateService.save(candidate);
			}
			
			election.setNoOfVoters(election.getNoOfVoters()+1);
			electionService.save(election);
		}
		else {
			msg = "You've already voted!";
			votePageUpdate.addObject("errormsg", msg);
		}
		
		List<Candidate> candidateList = candidateService.getByElection(election);
		votePageUpdate.addObject("election", election);
		votePageUpdate.addObject("candidateList", candidateList);
		
		return votePageUpdate;
	}
}
