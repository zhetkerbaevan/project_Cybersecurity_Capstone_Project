package com.example.Cybersecurity_Capstone_Project_Zhetkerbaeva_Nazerke.services;

import com.example.Cybersecurity_Capstone_Project_Zhetkerbaeva_Nazerke.entities.Users;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UsersService extends UserDetailsService {
    Users getUserByUsername(String username);
    Users createUser(Users user);
    Users getUser(Long id);
}
