package blog.controllers;

import blog.models.Post;
import blog.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class AllPostController {
    @Autowired
    PostService postService;

    @RequestMapping("posts")
    public String allPosts( Model model) {
        List<Post> posts = postService.findAllByOrderByDateDesc();
        model.addAttribute("posts", posts);
        return "posts/allposts";

    }
}
