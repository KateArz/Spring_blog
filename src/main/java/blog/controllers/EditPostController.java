package blog.controllers;

import blog.models.Post;
import blog.services.NotificationService;
import blog.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EditPostController {
    @Autowired
    PostService postService;
    @Autowired
    NotificationService notificationService;


    @RequestMapping("/posts/edit/{id}")
    public String editPost(@PathVariable("id") Long id, Model model){
        Post  editPost = postService.findById(id);
        if(editPost == null){
            notificationService.addErrorMessage("Cannot find post #" + id);
            return "redirect:/";
        }
        model.addAttribute("editPost", editPost);
       return "posts/edit";
    }

    @RequestMapping(value = "/posts/edit/{id}", method = RequestMethod.POST)
    public String edit(Post editPost){
        postService.edit(editPost);
        notificationService.addInfoMessage("Post successfully changed");
        return "redirect:/posts";

    }



}
