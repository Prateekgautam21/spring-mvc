package com.test.hplusapp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
// this annotation makes it to apply for all controllers
public class ApplicationGloabalExceptionHandler {

    @ExceptionHandler(ApplicationException.class)
    public String handleException(){
        System.out.println("in exception handler of login controller.");
        return "error";
    }

    @ExceptionHandler(LoginFailureException.class)
    public ResponseEntity handleLoginFailure(LoginFailureException ex){
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(ex.getMessage());
    }

}
