package com.dxc.codingassessment.backend.usertrackingapp.controller;

import com.dxc.codingassessment.backend.usertrackingapp.model.User;
import com.dxc.codingassessment.backend.usertrackingapp.service.UserDTOService;
import com.dxc.codingassessment.backend.usertrackingapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }
    @GetMapping("api/users")
    public ResponseEntity<List<User>> getUsers(){
        return ResponseEntity.ok(userService.getUsers());
    }
    @PostMapping("api/user/register")
    public ResponseEntity<?> registerNewUser(@RequestBody UserDTOService user){
        return userService.addNewUser(user);
    }
    @PostMapping("api/user/login")
    public ResponseEntity<?> loginUser(@RequestBody UserDTOService user){
        return userService.loginUser(user);
    }
}
