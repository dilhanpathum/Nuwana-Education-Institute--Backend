package com.nuwana.backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
public class Enroll {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    @Size(max = 100)
    private String firstname;

    @Column(nullable = false)
    @Size(max = 100)
    private String lastname;

    @Column(nullable = false, unique = true)
    @Size(max = 100)
    private String email;


    @Column(nullable = false)
    @Size(max = 100)
    private String gender;

    @Column(nullable = false)
    @Size(max = 100)
    private String subject;


    @Column(nullable = false)
    @Size(max = 100)
    private String grade;

    @Column(nullable = false)
    @Size(max = 100)
    private String status;
}
