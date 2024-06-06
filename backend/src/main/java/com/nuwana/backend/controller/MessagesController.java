package com.nuwana.backend.controller;

import com.nuwana.backend.config.UserAuthenticationProvider;
import com.nuwana.backend.dto.SignInDto;
import com.nuwana.backend.dto.SignUpDto;
import com.nuwana.backend.dto.UpdateDto;
import com.nuwana.backend.dto.UserDto;
import com.nuwana.backend.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public ResponseEntity<UserDto> profileEdit(@RequestBody @Valid UpdateDto user) {
        UserDto createdUser = userService.profileEdit(user);
        return ResponseEntity.created(URI.create("/users/" + createdUser.getId())).body(createdUser);
    }

    @PostMapping("/user")
    public ResponseEntity<UserDto> userDetails(@RequestBody UpdateDto user) {
        UserDto userDto =  userService.getUser(user);
        return ResponseEntity.ok(userDto);
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExeption(MethodArgumentNotValidException ex){
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String filedName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(filedName, errorMessage);

        });
        return errors;
    }
}
