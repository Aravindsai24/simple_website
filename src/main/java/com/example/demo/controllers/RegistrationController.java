package com.example.demo.controllers;

import com.example.demo.models.User;
import com.example.demo.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {
    @Autowired
    private UsersRepository usersRepository;

    @GetMapping("/register")
    public String getRegister(Model model) {
        User user = new User();
        model.addAttribute("user",user);
        return "preRegister";
    }

    @PostMapping("/register")
    public String postRegister(Model model, @ModelAttribute("user") User user) {
        User createdUser = usersRepository.save(user);
        System.out.println(createdUser.getUsername());
        model.addAttribute("user",user);
        return "postRegister";
    }
}
