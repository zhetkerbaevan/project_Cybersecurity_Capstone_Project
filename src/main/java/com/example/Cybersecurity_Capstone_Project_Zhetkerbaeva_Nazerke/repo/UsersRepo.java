package com.example.Cybersecurity_Capstone_Project_Zhetkerbaeva_Nazerke.repo;

import com.example.Cybersecurity_Capstone_Project_Zhetkerbaeva_Nazerke.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface UsersRepo extends JpaRepository<Users, Long> {
    Users findByUsername(String username);
}
