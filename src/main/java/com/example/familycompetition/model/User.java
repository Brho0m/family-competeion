package com.example.familycompetition.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "\"user\"")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private int score;
    private String gender;

    public User() {
    }

    public User(String username, int score,String gender) {
        this.username = username;
        this.score = score;
        this.gender= gender;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
