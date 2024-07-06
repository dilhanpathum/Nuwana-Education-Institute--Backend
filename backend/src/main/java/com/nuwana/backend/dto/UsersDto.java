package com.nuwana.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UsersDto {

    private int id;
    private String firstname;
    private String lastname;
    private String gender;
    private String email;
    private String role;
}
