package com.blogposts.repository;

import com.blogposts.entity.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogPostsRepository extends JpaRepository<BlogPost, Integer> {
    BlogPost findByTitle(String title);
}
