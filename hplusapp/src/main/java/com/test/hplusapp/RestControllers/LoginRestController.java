package com.test.hplusapp.RestControllers;

import com.test.hplusapp.Entity.Login;
import com.test.hplusapp.Entity.User;
import com.test.hplusapp.exceptions.LoginFailureException;
import com.test.hplusapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginRestController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/hplus/rest/loginuser")
    public ResponseEntity loginUser(@RequestBody Login login) throws LoginFailureException{
        System.out.println(login.getUsername() + " " + login.getPassword());
        User user = this.userRepository.getUserByName(login.getUsername());

        if(user==null){
//            return ResponseEntity.status(404).build();
            return new ResponseEntity<>("User not found",HttpStatus.NOT_FOUND);
        }

        if(user.getPassword().equals(login.getPassword())){
            return new ResponseEntity<>("Welcome "+user.getUsername(),HttpStatus.OK);
        }else{
            throw  new LoginFailureException("Invalid username or password");
        }

    }

}