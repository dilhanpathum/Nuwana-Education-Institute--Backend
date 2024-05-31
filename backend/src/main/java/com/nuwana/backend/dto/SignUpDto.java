package com.nuwana.backend.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SignUpDto {
    @Valid


    @NotEmpty(message = "First Name field not should be empty")
    @NotNull(message = "First Name field not should be empty")
    private String firstname;

    @NotEmpty(message = "Last Name field not should be empty")
    @NotNull(message = "Last Name field not should be empty")
    private String lastname;


    @Email(message = "Entered valid email address" )
    @NotEmpty(message = "Email field not should be empty")
    @NotNull(message = "Email field not should be empty")
    private String email;

    @NotEmpty(message = "Password field not should be empty")
    @NotNull(message = "Password field not should be empty")
    private char[] password;

    @NotEmpty(message = "Role field not should be empty")
    @NotNull(message = "Role field not should be empty")
    private String role;

    @NotEmpty(message = "Gender field not should be empty")
    @NotNull(message = "Gender field not should be empty")
    private String gender;

    @Pattern(regexp = "(\\07)[0-9]{10}", message = "Enter valid mobile number")
    @NotEmpty(message = "Contact field not should be empty")
    @NotNull(message = "Contact field not should be empty")
    private String contact;

}
