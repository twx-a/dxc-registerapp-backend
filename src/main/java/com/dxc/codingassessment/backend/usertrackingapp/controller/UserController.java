package com.dxc.codingassessment.backend.usertrackingapp.controller;

import com.dxc.codingassessment.backend.usertrackingapp.model.User;
import com.dxc.codingassessment.backend.usertrackingapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }
    @GetMapping("api/v1/users")
    public List<User> getUsers(){
        return userService.getUsers();
    }
    @PostMapping("api/v1/register")
    public void registerNewUser(@RequestBody User user){
        userService.addNewUser(user);
    }
    @PostMapping("api/v1/login")
    public User loginUser(@RequestBody User user){
       return userService.loginUser(user);
    }
}
