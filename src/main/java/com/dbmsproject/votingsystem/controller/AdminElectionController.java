package com.dbmsproject.votingsystem.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dbmsproject.votingsystem.model.Candidate;
import com.dbmsproject.votingsystem.model.Election;
import com.dbmsproject.votingsystem.service.CandidateService;
import com.dbmsproject.votingsystem.service.ElectionService;

@Controller
public class AdminElectionController {

	@Autowired
	ElectionService electionService;
	@Autowired
	CandidateService candidateService;
	
	@RequestMapping(value="/showresults", method=RequestMethod.GET)
	public ModelAndView showResultPage(@RequestParam("eid") Integer eid, HttpServletRequest request) {
		
		if(request.getSession().getAttribute("user") == null) {
			return new ModelAndView("login");
		}
		
		ModelAndView resultPage = new ModelAndView("result");
		
		Election election =  electionService.getById(eid);
		election.seteStatus(false);
		electionService.save(election);
		List<Candidate> candidateList = candidateService.getByElection(election);
		resultPage.addObject("election", election);

		Collections.sort(candidateList, new SortByVotes());
		
		List<Candidate> winners = new ArrayList<Candidate>();
		List<Candidate> others = new ArrayList<Candidate>();

		for(Candidate cd : candidateList) {
			System.out.println(cd);
		}
		
		int maxvotes = candidateList.get(0).getNoOfVotes();
		for(int i = 0; i < candidateList.size(); i++) {
			if(candidateList.get(i).getNoOfVotes() == maxvotes) {
				winners.add(candidateList.get(i));
			}
			else {
				others.add(candidateList.get(i));
			}
		}
		
		resultPage.addObject("winners", winners);
		resultPage.addObject("others", others);
		
		return resultPage;
	}
}

class SortByVotes implements Comparator<Candidate> 
{ 
    // Used for sorting in ascending order of no of votes
    public int compare(Candidate a, Candidate b) 
    { 
        return b.getNoOfVotes() - a.getNoOfVotes(); 
    } 
}  