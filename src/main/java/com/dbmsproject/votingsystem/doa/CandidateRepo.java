package com.dbmsproject.votingsystem.doa;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.dbmsproject.votingsystem.model.Candidate;
import com.dbmsproject.votingsystem.model.CandidateVoterId;
import com.dbmsproject.votingsystem.model.Election;

public interface CandidateRepo extends CrudRepository<Candidate, CandidateVoterId>{

	public List<Candidate> findByElection(Election election);
}
