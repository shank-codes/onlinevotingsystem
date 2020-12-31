package com.dbmsproject.votingsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbmsproject.votingsystem.doa.ElectionRepo;
import com.dbmsproject.votingsystem.model.Election;
import com.dbmsproject.votingsystem.model.User;

@Service
public class ElectionService {

	@Autowired
	private ElectionRepo electionRepo;
	
	public List<Election> getAllElections() {
		return (List<Election>)electionRepo.findAll();
	}
	
	public Election save(Election newElection) {
		return electionRepo.save(newElection);
	}
	
	public List<Election> getByAdmin(User admin) {
		return (List<Election>)electionRepo.findByAdmin(admin);
	}
	
	public Election getById(Integer eid) {
		return electionRepo.findById(eid).orElse(new Election());
	}
}
