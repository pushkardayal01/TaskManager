package com.assignment.taskmanager.service;

import com.assignment.taskmanager.model.User;
import com.assignment.taskmanager.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Get a specific user by username
    public Optional<User> getUser(String username) {
        return userRepository.findById(username);
    }

    // Add a new user
    public User addUser(User user) {
        return userRepository.save(user);
    }

    // Update an existing user
    public User updateUser(String username, User user) {
        return userRepository.findById(username).map(existingUser -> {
            existingUser.setFirstName(user.getFirstName());
            existingUser.setLastName(user.getLastName());
            existingUser.setEmail(user.getEmail());
            existingUser.setPhone(user.getPhone());
            existingUser.setPassword(user.getPassword());
            return userRepository.save(existingUser);
        }).orElseGet(() -> {
            user.setUsername(username);
            return userRepository.save(user);
        });
    }

    // Delete a user
    public boolean deleteUser(String username) {
        if (userRepository.existsById(username)) {
            userRepository.deleteById(username);
            return true;
        }
        return false;
    }
}
