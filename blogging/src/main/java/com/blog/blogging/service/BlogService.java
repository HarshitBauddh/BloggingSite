package com.blog.blogging.service;

import com.blog.blogging.entity.Blog;
//import com.blog.blogging.Repository.BlogRepository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BlogService {

    @Autowired
    private com.blog.blogging.Repository.BlogRepository blogRepository;

    // Method to get blogs by user ID
    public List<Blog> getBlogsByUser(Long userId) {
        return blogRepository.findByUserId(userId);
    }

    // Method to save a blog
    public void save(Blog blog) {
        blogRepository.save(blog);

    }

    // Method to delete a blog by ID
    public void delete(Long id) {
        blogRepository.deleteById(id);
    }
}
