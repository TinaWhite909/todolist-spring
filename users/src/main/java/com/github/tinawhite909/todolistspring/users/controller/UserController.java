package com.github.tinawhite909.todolistspring.users.controller;

import com.github.tinawhite909.todolistspring.users.bean.NewUser;
import com.github.tinawhite909.todolistspring.users.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/newuser")
    public String newUserForm(Model model){
        model.addAttribute("newuser",new NewUser());
        return "newuser";
    }

    @PostMapping("/newuser")
    public String newUserSubmit(@ModelAttribute NewUser user, Model model){
        model.addAttribute("newuser", userService.addUser(user));
        return "user";
    }

}
