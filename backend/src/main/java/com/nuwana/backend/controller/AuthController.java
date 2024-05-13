package com.nuwana.backend.controller;

import com.nuwana.backend.config.UserAuthenticationProvider;
import com.nuwana.backend.dto.SignInDto;
import com.nuwana.backend.dto.SignUpDto;
import com.nuwana.backend.dto.UserDto;
import com.nuwana.backend.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RequiredArgsConstructor
@RestController
@RequestMapping(value="/api/v1")
@CrossOrigin
public class AuthController {

    private final UserService userService;
    private final UserAuthenticationProvider userAuthenticationProvider;

    @PostMapping("/login")
    public ResponseEntity<UserDto> login(@RequestBody @Valid SignInDto signInDto) {
        UserDto userDto = userService.login(signInDto);
        userDto.setToken(userAuthenticationProvider.createToken(userDto.getEmail(),userDto.getRole(),userDto.getFirstname()));
        return ResponseEntity.ok(userDto);
    }

    @PostMapping("/register")
    public ResponseEntity<UserDto> register(@RequestBody @Valid SignUpDto user) {
        UserDto createdUser = userService.register(user);
        createdUser.setToken(userAuthenticationProvider.createToken(user.getEmail(),user.getRole(),user.getFirstname()));
        return ResponseEntity.created(URI.create("/users/" + createdUser.getId())).body(createdUser);
    }

}
