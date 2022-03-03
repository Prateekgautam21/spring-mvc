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
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;

@Controller
// to store model of login as session attribute we use sessionattribute
@SessionAttributes("loginData")
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public String login(@ModelAttribute("loginData")Login login, HttpSession session){

        // full session management can be done with session object like session.setAttribute() etc and a lot more.

        User user = this.userRepository.getUserByName(login.getUsername());

        if(user==null){
            throw new ApplicationException("User not found.");
        }

        // forwarding is handling the control to another resource within context or application.
        // redirecting is moving out of application.
        return "forward:/userprofile";
    }

    // exception handler for login controller when ApplicationException occurs.
//    @ExceptionHandler(ApplicationException.class)
//    public String handleException(){
//        System.out.println("in exception handler of login controller.");
//        return "error";
//    }

}
