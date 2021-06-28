package com.github.tinawhite909.todolistspring.users.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/newuser")
    public String newUserForm(Model model){
        model.addAttribute("newuser",new User());
        return "newuser";
    }

}
