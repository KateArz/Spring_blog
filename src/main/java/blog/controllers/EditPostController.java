package blog.controllers;

import blog.models.Post;
import blog.models.User;
import blog.services.NotificationService;
import blog.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EditPostController extends BasePostController {



    @RequestMapping("/posts/edit/{id}")
    public String editPost(@PathVariable("id") Long id, Model model, Authentication authentication) {
        Post post = this.getValidPost(id, authentication);
        if(post == null){
            return "redirect:/";
        }

        model.addAttribute("editPost", post);
        return "posts/edit";
    }

    @RequestMapping(value = "/posts/edit/{id}", method = RequestMethod.POST)
    public String edit(Post editPost, Authentication authentication) {
        Post post = this.getValidPost(editPost.getId(), authentication);
        if(post == null){
            return "redirect:/";
        }
        post.setBody(editPost.getBody());
        post.setTitle(editPost.getTitle());
        postService.edit(post);
        notificationService.addInfoMessage("Post successfully changed");
        return "redirect:/posts";

    }
}
