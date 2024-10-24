package com.nuwana.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MarksDto {
    private int id;
    private String fullname;
    private String grade;
    private String month;
    private String subject;
    private String email;
    private int marks;
}
