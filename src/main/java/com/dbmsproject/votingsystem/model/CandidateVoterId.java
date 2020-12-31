package com.dbmsproject.votingsystem.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class CandidateVoterId implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String username;
	private Integer eid;
	
	public CandidateVoterId() {
		username = null;
		eid = null;
	}
	
	public CandidateVoterId(String username, Integer eid) {
		super();
		this.username = username;
		this.eid = eid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getEid() {
		return eid;
	}

	public void setEid(Integer eid) {
		this.eid = eid;
	}
	
}
