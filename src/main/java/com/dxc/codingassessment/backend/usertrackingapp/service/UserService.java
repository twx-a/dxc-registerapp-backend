package com.dxc.codingassessment.backend.usertrackingapp.service;

import com.dxc.codingassessment.backend.usertrackingapp.repository.UserRepository;
import com.dxc.codingassessment.backend.usertrackingapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User>getUsers(){
        return userRepository.findAll();
    }

   public void addNewUser(User user){
        //check if the email exist since email is unique.
        Optional<User>getUserEmail = userRepository.findByEmail(user.getEmail());
        if(getUserEmail.isPresent()){
            throw new IllegalStateException("Email Taken");
        }
        else{
            userRepository.save(user);
        }
   }

   public User loginUser(User user){
        //find user
        Optional<User> getUserEmail = userRepository.findByEmail(user.getEmail());
        if(getUserEmail.isPresent()){
            //take from db and return
            User checkUserInfo = getUserEmail.get();
            if(user.getPassword().equals(checkUserInfo.getPassword())){
                return checkUserInfo;
            }
        }
       throw new IllegalStateException("Wrong password or email not found");
   }

}

