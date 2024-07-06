package com.nuwana.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EnrollDto {
    private int id;
    private String firstname;
    private String lastname;

    private String email;
    private String gender;
    private String subject;

    private String grade;
    private String status;
}
