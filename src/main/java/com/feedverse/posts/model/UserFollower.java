package com.feedverse.posts.model;

import jakarta.persistence.*;

@Entity
public class UserFollower {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String follower;

    public UserFollower() {
    }

    public UserFollower(Long id, String username, String follower) {
        this.id = id;
        this.username = username;
        this.follower = follower;
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

    public String getFollower() {
        return follower;
    }

    public void setFollower(String follower) {
        this.follower = follower;
    }

    @Override
    public String toString() {
        return "UserFollower{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", follower='" + follower + '\'' +
                '}';
    }
}
