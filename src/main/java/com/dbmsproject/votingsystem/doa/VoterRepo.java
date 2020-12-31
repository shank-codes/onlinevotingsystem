package com.dbmsproject.votingsystem.doa;

import org.springframework.data.repository.CrudRepository;

import com.dbmsproject.votingsystem.model.CandidateVoterId;
import com.dbmsproject.votingsystem.model.Voter;

public interface VoterRepo extends CrudRepository<Voter, CandidateVoterId> {

}
