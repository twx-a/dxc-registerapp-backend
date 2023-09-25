package com.dxc.codingassessment.backend.usertrackingapp.service;

import com.dxc.codingassessment.backend.usertrackingapp.repository.UserRepository;
import com.dxc.codingassessment.backend.usertrackingapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    //incoming data from html
   public ResponseEntity<?> addNewUser(UserDTOService registerUser){
        //check if the email exist since email is unique.
        Optional<User>getUserEmail = userRepository.findByEmail(registerUser.getEmail());
        if(getUserEmail.isPresent()){
            return new ResponseEntity<>("Email is taken", HttpStatus.BAD_REQUEST);
        }
        else{
            User user = new User();
            user.setEmail(registerUser.getEmail());
            user.setFirstName(registerUser.getFirstName());
            user.setLastName(registerUser.getLastName());
            user.setPassword(registerUser.getPassword());
            user.setManager(registerUser.getManager());
            userRepository.save(user);
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
   }

    //incoming data from html
   public ResponseEntity<?> loginUser(UserDTOService loginUser){
        //find user
        Optional<User> getUserEmail = userRepository.findByEmail(loginUser.getEmail());
        if(getUserEmail.isPresent()){
            //take from db and return
            User checkUserInfo = getUserEmail.get();
            //System.out.println("user variable: " + loginUser);
            //System.out.println("Fetch user from db:" +getUserEmail);
            //System.out.println("Fetch from db:"+checkUserInfo);
            if(loginUser.getPassword().equals(checkUserInfo.getPassword())){
                //System.out.println("Object to return: "+checkUserInfo);
                return new ResponseEntity<>(checkUserInfo, HttpStatus.OK);
            }
        }
       return new ResponseEntity<>("Wrong Email or Password", HttpStatus.UNAUTHORIZED);
   }

}

