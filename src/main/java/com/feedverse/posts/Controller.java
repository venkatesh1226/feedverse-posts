package com.feedverse.posts;
import com.feedverse.posts.model.Post;
import com.feedverse.posts.service.PostService;
import com.feedverse.posts.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//TODO: update security to use JWT and access username from there instead of passing it as a parameter

@RestController
@CrossOrigin(origins = "*")
public class Controller {
    @Autowired
    private PostService postService;
    @Autowired
    private UserService userService;

    @PostMapping("/add-post")
    public Long addPost(@RequestBody Post post) {
        return postService.addPost(post);
    }

    @GetMapping("/{id}")
    public Post getPost(@PathVariable Long id) {
        return postService.getPost(id);
    }

    @DeleteMapping("/{id}")
    public boolean deletePost(@PathVariable Long id,
                              @RequestParam(required = false) String role,
                              @RequestParam(required = false) String username) {
        return postService.deletePost(id, role, username);
    }

    @GetMapping("/feed")
    public List<Post> getFeed(@RequestParam String username) {
        return postService.getFeed(username);
    }

    @GetMapping("/all")
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }

    @GetMapping("/user/{username}")
    public List<Post> getPostsByUsername(@PathVariable String username) {
        return postService.getPostsByUsername(username);
    }

    @GetMapping("/count/{username}")
    public Long getUserPostCount(@PathVariable String username) {
        return postService.getUserPostCount(username);
    }

}