package com.blog.blogging.Repository;

import com.blog.blogging.entity.Blog;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

@SpringBootTest
public class BlogRepositoryTest {
    @Autowired
    private BlogRepository blogRepository;

    @Test
    public void testFindByUserId() {
        List<Blog> blogs = blogRepository.findByUser_Id(1L); // Replace 1L with a valid user ID from your database
        assertNotNull(blogs);
        assertFalse(blogs.isEmpty());
    }
}
