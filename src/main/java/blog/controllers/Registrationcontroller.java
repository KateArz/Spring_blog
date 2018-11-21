package blog.controllers;

import blog.forms.RegistrationForm;
import blog.models.User;
import blog.services.NotificationService;
import blog.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class Registrationcontroller {
    @Autowired
    private UserService userService;
    @Autowired
    private NotificationService notificationService;

    @RequestMapping("/users/register")
    public String register(RegistrationForm registrationForm){
        return "users/register";

    }

    @RequestMapping(value = "/users/register", method = RequestMethod.POST)
    public String registerPage(@Valid RegistrationForm registrationForm, BindingResult bindingResult, @RequestParam String username, @RequestParam String password, @RequestParam String fullname){
        if(bindingResult.hasErrors()){
            notificationService.addErrorMessage("Please fill the form correctly!");
            return "/users/register";
        }
        User user = new User(username, fullname,password);
        userService.create(user);
        notificationService.addInfoMessage("Registered successful!");
        return "redirect:/";
    }



}
