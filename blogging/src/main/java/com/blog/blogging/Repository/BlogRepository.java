package com.blog.blogging.Repository;


import com.blog.blogging.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {
    // Method to find blogs by user ID
    List<Blog> findByUser_Id(Long userId);

    List<Blog> findByUserId(Long userId);
}
