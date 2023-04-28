package com.example.Cybersecurity_Capstone_Project_Zhetkerbaeva_Nazerke.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long user_id;

    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password;

}
