package com.test.hplusapp.controllers;

import com.test.hplusapp.Entity.User;
import com.test.hplusapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class RegistrationController {

    @Autowired
    private UserRepository userRepository;

    // to convert dateOfBirth string type to date type
    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.registerCustomEditor(Date.class,
                                    "dateOfBirth",
                                    new CustomDateEditor(new SimpleDateFormat("dd-MM-yyyy"),true));
    }

    @PostMapping("/register")
    // validations will be carried out by spring before data binding with user object
    // the result of validations will be stored in an object called BindingResult
    // this BindingResult should be placed just after validating object.
    public ModelAndView register(@Valid @ModelAttribute("newuser")User user, BindingResult result){

        ModelAndView mav = new ModelAndView();
        if(result.hasErrors()){
            mav.setViewName("register");
            mav.addObject("message","Registration failure.");
            return mav;
        }
        userRepository.save(user);
        System.out.println("User registered successfully.");
        mav.setViewName("login");
        mav.addObject("message","User registered successfully.");
        return mav;
    }

}
