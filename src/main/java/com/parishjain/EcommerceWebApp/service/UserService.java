package com.parishjain.EcommerceWebApp.service;

import com.parishjain.EcommerceWebApp.models.User;
import com.parishjain.EcommerceWebApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void  addUser(User user){
        userRepository.save(user);
    }

    public Boolean loginUser(String email, String password) {
        User user = userRepository.getUserByEmail(email);
        if(password.equals(user.getPassword())){
            return true;
        }
        return false;
    }
}
