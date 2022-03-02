package com.test.hplusapp.controllers;

import com.test.hplusapp.Entity.Login;
import com.test.hplusapp.Entity.User;
import com.test.hplusapp.exceptions.ApplicationException;
import com.test.hplusapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public String login(@ModelAttribute("loginData")Login login){
        User user = this.userRepository.getUserByName(login.getUsername());

        if(user==null){
            throw new ApplicationException("User not found.");
        }

        return "search";
    }

    // exception handler for login controller when ApplicationException occurs.
//    @ExceptionHandler(ApplicationException.class)
//    public String handleException(){
//        System.out.println("in exception handler of login controller.");
//        return "error";
//    }

}
