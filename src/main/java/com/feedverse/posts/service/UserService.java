package com.feedverse.posts.service;

import com.feedverse.posts.model.UserFollower;
import com.feedverse.posts.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    // public void addFollower(String username, String follower){
    // UserFollower user=new UserFollower();
    // user.setFollower(follower);
    // user.setUsername(username);
    // repo.save(user);
    // }

    // public void removeFollower(String username, String follower){
    // repo.deleteByFollowerAndUsername(follower,username);
    // }
}
