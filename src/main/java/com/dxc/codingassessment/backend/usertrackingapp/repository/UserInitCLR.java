package com.dxc.codingassessment.backend.usertrackingapp.repository;

import com.dxc.codingassessment.backend.usertrackingapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserInitCLR implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        userRepository.save(new User("John", "Doe", "johndoe@email.com","password",'Y'));
        userRepository.save(new User("Jane", "Doe", "janedoe@email.com","password123",'N'));
        userRepository.save(new User("Richard", "Smith", "richardsmith@email.com","P@$$W0RD",'N'));
        System.out.println("User Initialization done");
    }
}
