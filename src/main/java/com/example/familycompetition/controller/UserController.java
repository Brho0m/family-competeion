package com.example.familycompetition.controller;

import com.example.familycompetition.ScoreUpdateRequest;
import com.example.familycompetition.model.User;
import com.example.familycompetition.service.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private SimpMessagingTemplate template;

    @PostMapping("/force-navigate-score")
    public void forceNavigateToScore() {
        template.convertAndSend("/topic/navigate", "go-to-score");
    }

    @PostMapping("/force-navigate-competition")
    public void forceNavigateToCompetition() {
        template.convertAndSend("/topic/navigate", "go-to-competition");
    }

    @GetMapping("/user/{username}")
    public User getUser(@PathVariable String username) {
        return userService.findUserByUsername(username);
    }

    @PostMapping("/update")
    public void updateScore(@RequestBody ScoreUpdateRequest updateRequest) {

        userService.updateScore(updateRequest);
    }

    // In UserController.java
@GetMapping("/users")
public List<User> getAllUsers() {
    return userService.findAllUsers();
}

}
