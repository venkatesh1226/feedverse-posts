package com.feedverse.posts;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.feedverse.posts.model.UserFollower;
import com.feedverse.posts.repository.UserRepository;
import com.feedverse.posts.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaListeners {

    @Autowired
    UserRepository repo;

    @KafkaListener(topics = "user-follow", groupId = "group1")
    public void listenUserFollow(String message) {
        String[] res = message.split("#");
        System.out.println("Received follow message: " + message);

        UserFollower obj = new UserFollower();
        obj.setUsername(res[0]);
        obj.setFollower(res[1]);
        repo.save(obj);
    }

    @KafkaListener(topics = "user-unfollow", groupId = "group1")
    public void listenUserUnfollow(String message) {
        System.out.println("Received unfollow message: " + message);
        String[] res = message.split("#");
    }
}
