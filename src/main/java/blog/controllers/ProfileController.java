package blog.controllers;

import blog.models.Post;
import blog.models.User;
import blog.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ProfileController {
    @Autowired
    PostService postService;

    @RequestMapping("/profile/posts")
    public String posts(Model model, Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        List<Post> posts = postService.findPostsByUserId(user.getId());
        model.addAttribute("posts", posts);
        return "profile/posts";

    }
}
