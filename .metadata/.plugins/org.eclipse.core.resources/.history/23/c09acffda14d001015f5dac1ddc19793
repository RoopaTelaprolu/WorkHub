package com.workhub.freelancebackend.service;

import com.workhub.freelancebackend.entity.User;
import com.workhub.freelancebackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User registerUser(User user) {
        Optional<User> existing = userRepository.findByEmail(user.getEmail());
        if (existing.isPresent()) {
            throw new RuntimeException("Email already registered.");
        }
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    // ✅ Get user by ID
    @Override
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User updateProfile(Long userId, User updatedUser) {
        Optional<User> existingOpt = userRepository.findById(userId);
        if (existingOpt.isEmpty()) {
            throw new RuntimeException("User not found");
        }
        User existing = existingOpt.get();
        existing.setName(updatedUser.getName());
        existing.setEmail(updatedUser.getEmail());
        existing.setSkills(updatedUser.getSkills());
        existing.setProfilePictureUrl(updatedUser.getProfilePictureUrl());

        return userRepository.save(existing);
    }

}
