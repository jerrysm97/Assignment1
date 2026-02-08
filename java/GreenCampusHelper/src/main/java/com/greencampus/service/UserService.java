package com.greencampus.service;

import com.greencampus.model.Admin;
import com.greencampus.model.NormalUser;
import com.greencampus.model.User;
import com.greencampus.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User register(String name, String email, String password, String role) {
        if (userRepository.findByEmail(email).isPresent()) {
            throw new IllegalArgumentException("Email already exists");
        }

        User newUser;
        if ("ADMIN".equalsIgnoreCase(role)) {
            newUser = new Admin(name, email, password);
        } else {
            newUser = new NormalUser(name, email, password);
        }

        return userRepository.save(newUser);
    }

    public User login(String email, String password) {
        Optional<User> userOpt = userRepository.findByEmail(email);
        
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            if (user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }
}
