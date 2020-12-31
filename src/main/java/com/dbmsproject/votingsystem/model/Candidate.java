package com.dbmsproject.votingsystem.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Candidate {

	@EmbeddedId
	private CandidateVoterId candidateId;
	
	
	@MapsId("username")
	@ManyToOne
	@JoinColumn(name = "candidateid")
    private User candidateUser;

	@MapsId("eid")
	@ManyToOne
	@JoinColumn(name = "electionid")
    private Election election;
	
	@NotNull
	private Integer noOfVotes;
	
	
	
	public Candidate() {
		this.candidateId = null;
		this.election = null;
		this.candidateUser = null;
		this.noOfVotes = null;
	}

	public Candidate(CandidateVoterId candidateId, Election election, User candidateUser, @NotNull Integer noOfVotes) {
		super();
		this.candidateId = candidateId;
		this.election = election;
		this.candidateUser = candidateUser;
		this.noOfVotes = noOfVotes;
	}
	
	

	public CandidateVoterId getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(CandidateVoterId candidateId) {
		this.candidateId = candidateId;
	}



	public Integer getNoOfVotes() {
		return noOfVotes;
	}

	public void setNoOfVotes(Integer noOfVotes) {
		this.noOfVotes = noOfVotes;
	}

	public User getCandidateUser() {
		return candidateUser;
	}

	public void setCandidateUser(User candidateUser) {
		this.candidateUser = candidateUser;
	}

	public Election getElection() {
		return election;
	}

	public void setElection(Election election) {
		this.election = election;
	}

	
	
}
