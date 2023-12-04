package com.feedverse.posts;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.feedverse.posts.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class KafkaListeners {

    @Autowired
    private UserService userFollowerService;
    private final ObjectMapper objectMapper;

    @Autowired
    public KafkaListeners(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    // @KafkaListener(topics = "userFollowTopic")
    // public void listenUserFollows(String message) {
    // try{
    // UserFollower userFollower=objectMapper.readValue(message,UserFollower.class);
    // userFollowerService.addFollower(userFollower.getUsername(),userFollower.getFollower());
    // }
    // catch (Exception e){
    // e.printStackTrace();
    // }
    // }

    // @KafkaListener(topics = "userUnfollowTopic", groupId = "unfollow-group")
    // public void listenUserUnfollows(String message) {
    // try{
    // UserFollower userFollower=objectMapper.readValue(message,UserFollower.class);
    // userFollowerService.removeFollower(userFollower.getUsername(),userFollower.getFollower());
    // }
    // catch (Exception e){
    // e.printStackTrace();
    // }
    // }
    @KafkaListener(topics = "userFollowTopic", groupId = "follow-group")
    public void listenUserFollows(String msg) {
        System.out.println("consumer consume the events  " + msg);
        try {
            HashMap<String, String> userFollower = objectMapper.readValue(msg,
                    new TypeReference<HashMap<String, String>>() {
                    });
            userFollowerService.addFollower(userFollower.get("UserName"), userFollower.get("FollowerName"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @KafkaListener(topics = "userUnfollowTopic", groupId = "unfollow-group")
    public void listenUserUnfollows(String msg) {
        System.out.println("consumer consume the events {} " + msg);
        try {
            HashMap<String, String> userFollower = objectMapper.readValue(msg,
                    new TypeReference<HashMap<String, String>>() {
                    });
            userFollowerService.removeFollower(userFollower.get("UserName"), userFollower.get("FollowerName"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
