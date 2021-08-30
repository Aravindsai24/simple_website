package com.example.demo.controllers;

import com.example.demo.models.Url;
import com.example.demo.models.User;
import com.example.demo.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class LoginController {
    @Autowired
    private UsersRepository usersRepository;

    @GetMapping("/login")
    public String getLogin(Model model) {
        User user = new User();
        model.addAttribute("user",user);
        return "preLogin";
    }

    @PostMapping("/login")
    public String postLogin(Model model, @ModelAttribute("user") User user) {
        List<User> userList = usersRepository.findByUsernameAndPassword(user.getUsername(),user.getPassword());
        model.addAttribute("URL", new Url());
        if(userList.size() > 0) {
            System.out.println(userList.get(0).getUsername());
            System.out.println(userList.get(0).getPassword());
            return "postSuccesfulLogin";
        }
        return "preLogin";
    }
}
