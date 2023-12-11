package com.syntacticsuger.bookmyshow.services;


import com.syntacticsuger.bookmyshow.models.User;
import com.syntacticsuger.bookmyshow.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    public User signUp(String email, String password){
        // Validate user already exists
        Optional<User> userOptional =userRepository.findByEmail(email);
        if(userOptional.isPresent()){
            throw new RuntimeException("User already exists");
        }
        User user = new User();
        user.setPassword(password);
        user.setEmail(email);
        user.setBookings(new ArrayList<>());
        return userRepository.save(user);
    }
}
