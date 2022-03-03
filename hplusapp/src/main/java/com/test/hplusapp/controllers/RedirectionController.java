package com.test.hplusapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RedirectionController {

    @GetMapping("/redirectToLinkedin")
    public String redirectToLinkedin(){
        return "redirect:https:www.linkedin.com";
    }
}
