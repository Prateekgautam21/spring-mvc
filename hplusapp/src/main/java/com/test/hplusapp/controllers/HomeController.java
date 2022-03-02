package com.test.hplusapp.controllers;

import com.test.hplusapp.Entity.Login;
import com.test.hplusapp.Entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String home(){
        return "index";
    }

    @GetMapping("/goToSearch")
    public String goToSearch(){
        return "search";
    }

    @GetMapping("/goToRegister")
    public String goToRegister(){
        return "register";
    }

    @GetMapping("/goToLogin")
    public String goToLogin(){
        return "login";
    }

//    @ModelAttribute("newuser")
//    public User getDefaultUser(){
//        System.out.println("Model attribute annotated funtion for user.");
//        return new User();
//    }
//
//    @ModelAttribute("genderItems")
//    public List<String> getGenderItems(){
//        return Arrays.asList("Male", "Female", "Other");
//    }
//
//    @ModelAttribute("loginData")
//    public Login getDefaultLogin(){
//        return new Login();
//    }

}
