package com.dbmsproject.votingsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = {"com.dbmsproject.votingsystem.controller", "com.dbmsproject.votingsystem.service", 
		"com.dbmsproject.votingsystem.doa"})
@ComponentScan(basePackages = {"com.dbmsproject.votingsystem.controller", "com.dbmsproject.votingsystem.service", 
		"com.dbmsproject.votingsystem.doa"})
public class VotingsystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(VotingsystemApplication.class, args);
	}

}
