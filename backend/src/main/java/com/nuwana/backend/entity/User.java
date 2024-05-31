package com.nuwana.backend.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
public class User {
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
    private String password;

    @Column(nullable = false)
    @Size(max = 100)
    private String role;

    @Column(nullable = false)
    @Size(max = 100)
    private String gender;

    @Column(nullable = false)
    @Size(max = 100)
    private String contact;


}
