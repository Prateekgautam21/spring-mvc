package com.test.hplusapp.controllers;

import com.test.hplusapp.Entity.Login;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpSession;

@Controller
public class LogoutController {

    @GetMapping("/logout")
    public String logout(HttpSession session){
        System.out.println("Ending user session");
        session.invalidate();
        return "login";
    }

}
