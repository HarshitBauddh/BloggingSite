package com.blog.blogging.Controller;

import com.blog.blogging.entity.Blog;
import com.blog.blogging.entity.User;
import com.blog.blogging.service.BlogService;
import com.blog.blogging.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.security.Principal;
import java.util.List;

@Controller
public class BlogController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private UserService userService;

    @GetMapping("/dashboard")
    public String dashboard(Model model, Principal principal) {
        // Fetch the user by their username
        User user = userService.findByUsername(principal.getName());
        if (user == null) {
            throw new RuntimeException("User not found!");
        }
        // Get the list of blogs for the user
        List<Blog> blogs = blogService.getBlogsByUser(user.getId());
        // Add blogs to the model
        model.addAttribute("blogs", blogs);
        return "dashboard";
    }

    @PostMapping("/blogs")
    public String createOrUpdateBlog(Blog blog, Principal principal) {
        // Fetch the user by their username
        User user = userService.findByUsername(principal.getName());
        // Set the user for the blog
        blog.setUser(user);
        // Save the blog
        blogService.save(blog);
        return "redirect:/dashboard"; // Redirect to dashboard after saving the blog
    }

    @GetMapping("/blog/delete/{id}")
    public String deleteBlog(@PathVariable Long id) {
        blogService.delete(id); // Delete the blog by ID
        return "redirect:/dashboard"; // Redirect to dashboard after deleting the blog
    }
}