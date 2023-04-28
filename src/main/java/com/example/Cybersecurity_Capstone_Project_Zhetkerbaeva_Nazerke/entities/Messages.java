package com.example.Cybersecurity_Capstone_Project_Zhetkerbaeva_Nazerke.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "messages")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Messages {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long message_id;

    @ManyToOne
    @JoinColumn(name="sender_id")
    private Users sender_id;

    @ManyToOne
    @JoinColumn(name="receiver_id")
    private Users receiver_id;

    @Column(name="content")
    private String content;
}
