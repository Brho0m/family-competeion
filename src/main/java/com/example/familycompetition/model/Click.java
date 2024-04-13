package com.example.familycompetition.model;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
public class Click {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userId", referencedColumnName = "id")
    private User user; // Link to User entity

    private Instant timeClicked;

    // Constructor, getters, and setters
    public Click() {}

    public Click(User user, Instant timeClicked) {
        this.user = user;
        this.timeClicked = timeClicked;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Instant getTimeClicked() {
        return timeClicked;
    }

    public void setTimeClicked(Instant timeClicked) {
        this.timeClicked = timeClicked;
    }
}
