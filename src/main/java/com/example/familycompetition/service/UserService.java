package com.example.familycompetition.service;

import com.example.familycompetition.ScoreUpdateRequest;
import com.example.familycompetition.model.User;
import com.example.familycompetition.repository.UserRepository;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

public void initializeUsers() {
    List<User> users = Arrays.asList(
        new User("huda", 0),
        new User("nader", 0),
        new User("maher", 0),
        new User("redha", 0),
        new User("hajar", 0),
        new User("hailah", 0)
    );
    userRepository.saveAll(users);
}


    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }



public List<User> findAllUsers() {
    return userRepository.findAll();
}

    public void updateScore(ScoreUpdateRequest updateRequest) {
        if (updateRequest.getUserId() == null || updateRequest.getScore() == null) {
            throw new IllegalArgumentException("User ID and points must not be null.");
        }
        User user = userRepository.findById(updateRequest.getUserId())
            .orElseThrow(() -> new RuntimeException("User not found"));
        user.setScore(user.getScore() + updateRequest.getScore());
        userRepository.save(user);
    }

}
