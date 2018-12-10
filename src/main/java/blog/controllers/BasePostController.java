package blog.controllers;

import blog.models.Post;
import blog.models.User;
import blog.services.NotificationService;
import blog.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;

public class BasePostController {

    @Autowired
    PostService postService;
    @Autowired
    NotificationService notificationService;

    protected Post getValidPost(Long postId, Authentication authentication){
        User user = (User) authentication.getPrincipal();
        Post editPost = postService.findById(postId);
        if (editPost == null) {
            notificationService.addErrorMessage("Cannot find post #" + postId);
            return null;
        }
        if (editPost.getAuthor() == null || editPost.getAuthor().getId() != user.getId()) {
            notificationService.addErrorMessage("You are not authorized to edit this post");
            return null;
        }

        return editPost;
    }
}
