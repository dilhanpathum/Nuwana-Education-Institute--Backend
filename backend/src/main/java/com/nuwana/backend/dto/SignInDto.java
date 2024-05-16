package com.nuwana.backend.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SignInDto {
    @Valid

    @Email(message = "Entered valid email address" )
    @NotEmpty(message = "Email field not should be empty")
    @NotNull(message = "Email field not should be empty")
    private String email;

    @NotEmpty(message = "Password field not should be empty")
    @NotNull(message = "Password field not should be empty")
    private char[] password;
}
