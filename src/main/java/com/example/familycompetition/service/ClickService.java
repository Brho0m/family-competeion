package com.example.familycompetition.service;

import com.example.familycompetition.model.Click;
import com.example.familycompetition.model.User;
import com.example.familycompetition.repository.ClickRepository;
import com.example.familycompetition.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class ClickService {
    @Autowired
    private ClickRepository clickRepository;

    @Autowired
    private UserRepository userRepository;


    public Click recordAndFetchClick(Long userId, Instant timeClicked) {
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("Invalid user ID"));
        Click click = new Click(user, timeClicked);
        clickRepository.save(click);
        return click;
    }
    public void recordClick(Long userId) {
        User user = userRepository.findById(userId).orElse(null);

        clickRepository.save(new Click(user, Instant.now()));
    }

    public List<Click> getClicksOrdered() {
        return clickRepository.findAllByOrderByTimeClickedAsc();
    }

    public Click recordClick(Long userId, Instant timeClicked) {
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
        Click newClick = new Click(user, timeClicked);
        clickRepository.save(newClick);
        return newClick;
    }
    
    

    public void resetClicks() {
        clickRepository.deleteAll();
    }
}
