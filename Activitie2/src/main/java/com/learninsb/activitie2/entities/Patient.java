package com.learninsb.activitie2.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity // new entité JPA
@Data // genere les getters et setters
@NoArgsConstructor
@AllArgsConstructor
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    @Temporal(TemporalType.DATE)
    private Date dateNaissance;

    private boolean malade;

    private int score;
}