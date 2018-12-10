package blog.controllers;

import blog.models.Post;
import blog.models.User;
import blog.services.NotificationService;
import blog.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DeletePostController extends BasePostController {

    @RequestMapping("/posts/delete/{id}")
    public String delete(@PathVariable("id") Long id, Model model, Authentication authentication){
        Post post = this.getValidPost(id, authentication);
        if(post == null){
            return "redirect:/";
        }
        model.addAttribute("post", post);
        return "posts/delete";
    }

    @RequestMapping(value = "/posts/delete", method = RequestMethod.POST)
    public String delete(Post post, Authentication authentication){
        Post dbPost = this.getValidPost(post.getId(), authentication);
        if(dbPost == null){
            return "redirect:/";
        }
        postService.deleteById(dbPost.getId());
        return "redirect:/posts";
    }



}
