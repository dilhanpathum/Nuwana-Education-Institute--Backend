package com.nuwana.backend.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDto {

    private int id;
    private String firstname;
    private String lastname;
    private String email;
    private String role;
    private String token;

}
