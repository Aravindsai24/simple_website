package com.example.demo.controllers;

import com.example.demo.models.UserData;
import com.example.demo.repository.UserDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PostLoginController {
    @Autowired
    private UserDataRepository userDataRepository;

    @PostMapping("/display")
    public String openUrl(@ModelAttribute("userData") UserData userData) {
        String myURL = userData.getMyUrl();
        System.out.println(userData.getUserId());
        UserData createdUserData = userDataRepository.save(userData);
        System.out.println(createdUserData.getUserId());
        System.out.println(createdUserData.getMyUrl());
        return "displayUrl";
    }
}
