package com.nuwana.backend.controller;

import com.nuwana.backend.config.UserAuthenticationProvider;
import com.nuwana.backend.dto.SignUpDto;
import com.nuwana.backend.dto.UpdateDto;
import com.nuwana.backend.dto.UserDto;
import com.nuwana.backend.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value="/api/v1")
public class MessagesController {
    private final UserService userService;

    public MessagesController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/messages")
    public ResponseEntity<List<String>> messages() {

        return ResponseEntity.ok(Arrays.asList("first", "second"));
    }

    @PutMapping("/edit")
    public String profileEdit(@RequestBody @Valid UpdateDto user) {
        userService.profileEdit(user);
        return "success";
    }
}
