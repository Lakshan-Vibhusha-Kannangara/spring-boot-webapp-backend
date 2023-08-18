package com.blogposts.controller;

import com.blogposts.entity.BlogPost;
import com.blogposts.service.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class BlogController {

    @Autowired
    private BlogPostService service;

    @PostMapping("/addPost")
    public BlogPost addPost(@RequestBody BlogPost post) {
        return service.savePost(post);
    }

    @PostMapping("/addPosts")
    public List<BlogPost> addPosts(@RequestBody List<BlogPost> posts) {
        return service.savePosts(posts);
    }

    @GetMapping("/posts")
    @CrossOrigin(origins = "http://localhost:3002")
    public List<BlogPost> findAllPosts() {
        return service.getPosts();
    }

    @GetMapping("/postById/{id}")
    public BlogPost findPostById(@PathVariable String id) {
        return service.getPostById(id);
    }

    @GetMapping("/postByTitle/{title}")
    public BlogPost findPostByTitle(@PathVariable String title) {
        return service.getPostByTitle(title);
    }

    @PutMapping("/updatePost")
    public BlogPost updatePost(@RequestBody BlogPost post) {
        return service.updatePost(post);
    }

    @DeleteMapping("/deletePost/{id}")
    public String deletePost(@PathVariable String id) {
        return service.deletePost(id);
    }
}
