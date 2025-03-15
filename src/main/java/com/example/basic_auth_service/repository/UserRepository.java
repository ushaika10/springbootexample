package com.example.basic_auth_service.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.basic_auth_service.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    // Find user by username / Kullanıcıyı kullanıcı adına göre bul
    User findByUsername(String username);
}