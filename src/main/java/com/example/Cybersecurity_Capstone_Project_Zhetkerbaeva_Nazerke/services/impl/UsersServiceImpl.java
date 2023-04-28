package com.example.Cybersecurity_Capstone_Project_Zhetkerbaeva_Nazerke.services.impl;

import com.example.Cybersecurity_Capstone_Project_Zhetkerbaeva_Nazerke.entities.Roles;
import com.example.Cybersecurity_Capstone_Project_Zhetkerbaeva_Nazerke.entities.Users;
import com.example.Cybersecurity_Capstone_Project_Zhetkerbaeva_Nazerke.repo.UsersRepo;
import com.example.Cybersecurity_Capstone_Project_Zhetkerbaeva_Nazerke.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersRepo usersRepo;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public Users getUserByUsername(String username) {
        return null;
    }

    @Override
    public Users createUser(Users user) {
        Users checkUser = usersRepo.findByUsername(user.getUsername());
        if(checkUser == null){
                user.setPassword(passwordEncoder.encode(user.getPassword()));
                return usersRepo.save(user);
        }
        return null;
    }

    @Override
    public Users getUser(Long id) {
        return usersRepo.getOne(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Roles roles = new Roles();
        Users myUser = usersRepo.findByUsername(username);
        if(myUser != null){
           //User secUser = new User(myUser.getUsername(), myUser.getPassword(), roles);
            //return secUser;
        }
        throw new UsernameNotFoundException("User not found");
    }
}
