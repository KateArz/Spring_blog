package blog.controllers;

import blog.models.Post;
import blog.services.NotificationService;
import blog.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DeletePostController {
    @Autowired
    private PostService postService;

    @Autowired
    private NotificationService notificationService;

    @RequestMapping("/posts/delete/{id}")
    public String delete(@PathVariable("id") Long id, Model model){
        Post post =postService.findById(id);
        if(post == null){
            notificationService.addErrorMessage("Cannot find post #" + id);
            return "redirect:/";
        }
        model.addAttribute("post", post);
        return "posts/delete";
    }

    @RequestMapping(value = "/posts/delete", method = RequestMethod.POST)
    public String delete(Post post){
        postService.deleteById(post.getId());
        return "redirect:/posts";
    }

}
