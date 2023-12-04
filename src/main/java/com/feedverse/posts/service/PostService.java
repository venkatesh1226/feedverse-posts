package com.feedverse.posts.service;

import com.feedverse.posts.model.Post;
import com.feedverse.posts.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository repo;

    public Long addPost(Post post) {
        return repo.save(post).getId();
    }

    public Post getPost(Long id) {
        return repo.findById(id).orElse(null);
    }

    public boolean deletePost(Long postId,String role,String username){
        if(role.equals("admin")||repo.existsByIdAndUsername(postId,username)){
            repo.deleteById(postId);
            return true;
        }
        else {
            return false;
        }
    }

    public List<Post> getFeed(String username){
        return repo.findFeedForCurrentUser(username);
    }

    public List<Post> getAllPosts(){
        return repo.findAll();
    }

    public List<Post> getPostsByUsername(String username){
        return repo.getPostsByUsername(username);
    }

    public Long getUserPostCount(String username) {
        return repo.getUserPostsCount(username);
    }
}
