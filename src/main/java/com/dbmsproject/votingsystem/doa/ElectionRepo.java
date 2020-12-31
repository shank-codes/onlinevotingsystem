package com.dbmsproject.votingsystem.doa;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.dbmsproject.votingsystem.model.*;

public interface ElectionRepo extends CrudRepository<Election, Integer> {

	public List<Election> findByAdmin(User admin);
}
