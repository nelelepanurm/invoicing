package com.schoolproject.invoicing;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("api/userlogin")
    public UserDTO getLoggedInUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        return userService.findUserByName(username);
    }
}
