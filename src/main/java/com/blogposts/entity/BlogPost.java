package com.blogposts.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class BlogPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;
    private String imageUrl;

    private  String authorName;
    private String authorImg;
    private String publishDate;
    private String content;

    @ElementCollection
    private List<String> listItems;
    @ElementCollection
    private List<String> images;
    // Other getter and setter methods if needed
}
