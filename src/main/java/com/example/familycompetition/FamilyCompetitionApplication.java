package com.example.familycompetition;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import com.example.familycompetition.service.UserService;

@SpringBootApplication
public class FamilyCompetitionApplication {

	    @Autowired
    private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(FamilyCompetitionApplication.class, args);
	}

    @EventListener(ApplicationReadyEvent.class)
    public void initializeUsersAfterStartup() {
        userService.initializeUsers();
    }
}
