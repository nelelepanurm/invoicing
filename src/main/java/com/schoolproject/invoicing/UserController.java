package com.schoolproject.invoicing;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {



    @Autowired
    private UserService userService;

    @PostMapping("api/public/newuser")
    public void createUser(@RequestBody CreateUserRequest request){
        userService.createUser(request.getUserName(),request.getPassword());
    }

    @PostMapping("api/public/password")
    public String login(@RequestBody CreateUserRequest request){
        return userService.login(request.getUserName(),request.getPassword());

    }
    @GetMapping("api/protected")
    public String testLogin(){
        return "Protected page";
    }
}
