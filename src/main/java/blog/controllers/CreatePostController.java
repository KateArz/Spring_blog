package blog.controllers;

import blog.forms.CreatePostForm;
import blog.forms.RegistrationForm;
import blog.models.Post;
import blog.models.User;
import blog.services.NotificationService;
import blog.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.security.Principal;

@Controller
public class CreatePostController {
    @Autowired
    NotificationService notificationService;
    @Autowired
    PostService postService;


     @RequestMapping("/posts/create")
    public String createPost(CreatePostForm createPostForm)
     {
       return "posts/create";
    }


    @RequestMapping(value = "/posts/create", method = RequestMethod.POST)
    public String createPost(@Valid CreatePostForm createPostForm, BindingResult bindingResult, @RequestParam String title, @RequestParam String body, Authentication user){
        if(bindingResult.hasErrors()){
            notificationService.addErrorMessage("Please fill the form correctly!");
            return "/posts/create";
        }
       Post post = new Post(title,body);
        post.setAuthor((User)user.getPrincipal());
       postService.create(post);
        notificationService.addInfoMessage("Post created!");
        return "/posts/create";
    }
}
