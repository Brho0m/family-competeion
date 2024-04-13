package com.example.familycompetition;

import java.time.Instant;

public class ClickDTO {
    private Long id;
    private String username;
    private Long userId;
    private Instant timeClicked;

    public ClickDTO(Long id,  String username,Long userId, Instant timeClicked) {
        this.id = id;
        this.userId = userId;
        this.username = username;
        this.timeClicked = timeClicked;
    }

    // Getters and setters
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Instant getTimeClicked() {
        return timeClicked;
    }

    public void setTimeClicked(Instant timeClicked) {
        this.timeClicked = timeClicked;
    }
}
