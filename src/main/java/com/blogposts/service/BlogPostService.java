package com.blogposts.service;

import com.blogposts.repository.BlogPostsRepository;
import com.blogposts.entity.BlogPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogPostService {
    @Autowired
    private BlogPostsRepository repository;

    public BlogPost savePost(BlogPost post) {
        return repository.save(post);
    }

    public List<BlogPost> savePosts(List<BlogPost> posts) {
        return repository.saveAll(posts);
    }

    public List<BlogPost> getPosts() {
        return repository.findAll();
    }

    public BlogPost getPostById(String id) {
        return repository.findById(Integer.valueOf(id)).orElse(null);
    }

    public BlogPost getPostByTitle(String title) {
        return repository.findByTitle(title);
    }

    public String deletePost(String id) {
        repository.deleteById(Integer.valueOf(id));
        return "Post removed!! " + id;
    }

    public BlogPost updatePost(BlogPost post) {
        BlogPost existingPost = repository.findById(post.getId()).orElse(null);
        if (existingPost != null) {
            existingPost.setTitle(post.getTitle());
            existingPost.setImageUrl(post.getImageUrl());
            existingPost.setAuthorName(post.getAuthorName());
            existingPost.setAuthorImg(post.getAuthorImg());
            existingPost.setPublishDate(post.getPublishDate());
            existingPost.setContent(post.getContent());
            existingPost.setListItems(post.getListItems());

            return repository.save(existingPost);
        } else {
            throw new IllegalArgumentException("Post not found with ID: " + post.getId());
        }
    }
}
