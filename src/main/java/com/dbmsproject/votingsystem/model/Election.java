package com.dbmsproject.votingsystem.model;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Election {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotNull
	private Integer eid;
	
	@NotNull
	private String ename;
	
	@ManyToOne
	@JoinColumn(name="admin")
	private User admin;
	
	@OneToMany(mappedBy="election")
	List<Candidate> candidateList;
	
	@OneToMany(mappedBy="election")
	List<Voter> voterList;
	

	@NotNull
	private Integer noOfCandidates;
	
	@NotNull
	private Integer noOfVoters;
	
	@NotNull
	private Boolean eStatus;
	
	@Column(columnDefinition = "varchar(255) DEFAULT NULL")
	String ePassword;
	
	public Election() {
		this.eid = null;
		this.ename = null;
		this.admin = null;
		this.noOfCandidates = null;
		this.noOfVoters = null;
		this.eStatus = null;
	}

	public Election(@NotNull Integer eid, @NotNull String ename, User admin, @NotNull Integer noOfCandidates,
			@NotNull Integer noOfVoters, @NotNull Boolean eStatus, String ePassword) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.admin = admin;
		this.noOfCandidates = noOfCandidates;
		this.noOfVoters = 0;
		this.eStatus = eStatus;
		this.ePassword = ePassword;
	}

	public Integer getEid() {
		return eid;
	}

	public void setEid(Integer eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public User getAdmin() {
		return admin;
	}

	public void setAdmin(User admin) {
		this.admin = admin;
	}

	public Integer getNoOfCandidates() {
		return noOfCandidates;
	}

	public void setNoOfCandidates(Integer noOfCandidates) {
		this.noOfCandidates = noOfCandidates;
	}

	public Integer getNoOfVoters() {
		return noOfVoters;
	}

	public void setNoOfVoters(Integer noOfVoters) {
		this.noOfVoters = noOfVoters;
	}

	public Boolean geteStatus() {
		return eStatus;
	}

	public void seteStatus(Boolean eStatus) {
		this.eStatus = eStatus;
	}

	public String getePassword() {
		return ePassword;
	}

	public void setePassword(String ePassword) {
		this.ePassword = ePassword;
	}

	@Override
	public String toString() {
		return "Election [eid=" + eid + ", ename=" + ename + ", admin=" + admin + ", noOfCandidates=" + noOfCandidates
				+ ", noOfVoters=" + noOfVoters + ", eStatus=" + eStatus + ", ePassword=" + ePassword + "]";
	}
	
	
}
