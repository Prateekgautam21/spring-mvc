package com.test.hplusapp.controllers;

import com.test.hplusapp.Entity.Login;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class UserProfileController {

    @PostMapping("/userprofile")
    public String getUserProfile(@SessionAttribute("loginData") Login login, Model model){
        System.out.println("in user profile controller");
        System.out.println("username: " + login.getUsername());
        model.addAttribute("username",login.getUsername());
        return "profile";
    }

}
