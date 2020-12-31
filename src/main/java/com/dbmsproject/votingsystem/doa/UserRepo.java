package com.dbmsproject.votingsystem.doa;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dbmsproject.votingsystem.model.User;


public interface UserRepo extends CrudRepository<User, String> {
	
	public List<User> findByEmail(String email);
	
	public List<User> findByPhone(String phone);
	
}
