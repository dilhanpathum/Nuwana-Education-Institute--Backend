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
public class Marks {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    @Size(max = 100)
    private String fullname;

    @Column(nullable = false)
    @Size(max = 100)
    private String grade;

    @Column(nullable = false)
    @Size(max = 100)
    private String subject;

    @Column(nullable = false)
    @Size(max = 100)
    private String month;

    @Column(nullable = false, unique = true)
    @Size(max = 100)
    private String email;

    @Column(nullable = false)
    private int marks;
}
