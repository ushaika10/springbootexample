package com.example.basic_auth_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.basic_auth_service.entity.User;
import com.example.basic_auth_service.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Register a new user / Yeni kullanıcı kaydı
    public User registerUser(User user) { 
        return userRepository.save(user);
    }

    // Update user profile / Kullanıcı profilini güncelle
    public User updateProfile(Long id, User updatedUser) {
        User user = userRepository.findById(id).orElseThrow();
        user.setEmail(updatedUser.getEmail());
        user.setBio(updatedUser.getBio());
        return userRepository.save(user);
    }

    // Delete user / Kullanıcıyı sil
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    // Get all users (for admin) / Tüm kullanıcıları getir (admin için)
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}