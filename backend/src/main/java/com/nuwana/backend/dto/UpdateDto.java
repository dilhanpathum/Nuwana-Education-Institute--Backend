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
public class UpdateDto {

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

    @Pattern(regexp = "^07[0-9]{8}$", message = "Enter valid mobile number")
    @NotEmpty(message = "Contact field not should be empty")
    @NotNull(message = "Contact field not should be empty")
    private String contact;
}
