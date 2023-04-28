package com.example.Cybersecurity_Capstone_Project_Zhetkerbaeva_Nazerke.repo;

import com.example.Cybersecurity_Capstone_Project_Zhetkerbaeva_Nazerke.entities.Messages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface MessagesRepo extends JpaRepository<Messages, Long> {
}
