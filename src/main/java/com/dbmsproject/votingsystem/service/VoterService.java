package com.dbmsproject.votingsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbmsproject.votingsystem.doa.VoterRepo;
import com.dbmsproject.votingsystem.model.CandidateVoterId;
import com.dbmsproject.votingsystem.model.Voter;

@Service
public class VoterService {

	@Autowired
	VoterRepo voterRepo;
	
	public Voter getById(CandidateVoterId voterId) {
		return voterRepo.findById(voterId).orElse(new Voter());
	}
	
	public Voter save(Voter voter) {
		return voterRepo.save(voter);
	}
	
}
