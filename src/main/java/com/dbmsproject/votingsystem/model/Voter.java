package com.dbmsproject.votingsystem.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
//import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Voter {

	@EmbeddedId
	private CandidateVoterId voterId;
	
	@MapsId("username")
	@JoinColumn(name="voterid")
	@ManyToOne
	private User voter;

	@MapsId("eid")
	@JoinColumn(name="electionid")
	@ManyToOne
	private Election election;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="candidateid")
	private User candidate;
	
	public Voter()
	{
		this.voterId = null;
		this.candidate = null;
		this.voter = null;
		this.election = null;
	}
	public Voter(CandidateVoterId voterId, @NotNull User cid, User voter,Election election) {
		super();
		this.voterId = voterId;
		this.candidate = cid;
		this.voter = voter;
		this.election = election;
	}

	public CandidateVoterId getVoterId() {
		return voterId;
	}

	public void setVoterId(CandidateVoterId voterId) {
		this.voterId = voterId;
	}

	public User getCid() {
		return candidate;
	}

	public void setCid(User cid) {
		this.candidate = cid;
	}
	
}
