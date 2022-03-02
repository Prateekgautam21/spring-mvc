package com.test.hplusapp.controllers;

import com.test.hplusapp.Entity.Login;
import com.test.hplusapp.Entity.User;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Arrays;
import java.util.List;

@ControllerAdvice
// this annotation basically apply the functionality to all controllers.
public class DefaultModelAttributeController {

    @ModelAttribute("newuser")
    public User getDefaultUser(){
        System.out.println("Model attribute annotated funtion for user.");
        return new User();
    }

    @ModelAttribute("genderItems")
    public List<String> getGenderItems(){
        return Arrays.asList("Male", "Female", "Other");
    }

    @ModelAttribute("loginData")
    public Login getDefaultLogin(){
        return new Login();
    }

}
