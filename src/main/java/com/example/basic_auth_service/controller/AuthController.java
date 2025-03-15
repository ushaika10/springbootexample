package com.example.basic_auth_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.basic_auth_service.entity.User;
import com.example.basic_auth_service.service.UserService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    // Register endpoint / Kayıt endpoint'i
    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.registerUser(user);
    }

    // Update profile endpoint / Profil güncelleme endpoint'i
    @PutMapping("/profile/{id}")
    public User updateProfile(@PathVariable Long id, @RequestBody User user) {
        return userService.updateProfile(id, user);
    }

    // Delete profile endpoint / Profil silme endpoint'i
    @DeleteMapping("/profile/{id}")
    public String deleteProfile(@PathVariable Long id) {
        userService.deleteUser(id);
        return "User deleted / Kullanıcı silindi";
    }
}