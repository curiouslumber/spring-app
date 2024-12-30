package com.noelpinto47.spring_app.services;

import org.springframework.stereotype.Service;

import com.noelpinto47.spring_app.entities.User;
import com.noelpinto47.spring_app.repository.UserRepository;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found!"));
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public List<String> getAllUserNames() {
        return userRepository.findAll().stream()
                .map(User::getName)
                .toList();
    }

    public User updateUserEmail(Long id, String email) {
        User user = getUserById(id);
        user.setEmail(email);
        return userRepository.save(user);
    }
}