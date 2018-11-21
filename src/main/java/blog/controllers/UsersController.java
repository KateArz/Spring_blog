package blog.controllers;

import blog.models.User;
import blog.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class UsersController {
    @Autowired
    UserService userService;

    @RequestMapping("/users")
    public String allusers(Model model){
        List<User> users = userService.findAll();
        model.addAttribute("users",users);
        return "users/allusers";

    }
}
