package com.dbmsproject.votingsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbmsproject.votingsystem.doa.CandidateRepo;
import com.dbmsproject.votingsystem.model.Candidate;
import com.dbmsproject.votingsystem.model.CandidateVoterId;
import com.dbmsproject.votingsystem.model.Election;


@Service
public class CandidateService {
	
	@Autowired
	private CandidateRepo candidateRepo;
	
	public Candidate save(Candidate newCandidate) {
		return candidateRepo.save(newCandidate);
	}
	
	public List<Candidate> getByElection(Election ele) {
		return (List<Candidate>)candidateRepo.findByElection(ele);
	}
	
	public Candidate getById(CandidateVoterId cid) {
		return candidateRepo.findById(cid).orElse(new Candidate());
	}
}
