package com.example.demo.controllers;

import com.example.demo.models.Url;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PostLoginController {

    @PostMapping("/open")
    public String openUrl(@ModelAttribute("URL") Url URL) {
        String myURL = URL.getMyUrl();
        System.out.println(myURL);
        return "redirect:" + myURL;
    }
}
