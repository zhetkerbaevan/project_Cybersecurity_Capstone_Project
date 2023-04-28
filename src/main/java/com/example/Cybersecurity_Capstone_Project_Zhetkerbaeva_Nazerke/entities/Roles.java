package com.example.Cybersecurity_Capstone_Project_Zhetkerbaeva_Nazerke.entities;

import org.springframework.security.core.GrantedAuthority;

public class Roles implements GrantedAuthority {
    private String role;

    @Override
    public String getAuthority() {
        return this.role;
    }
}
