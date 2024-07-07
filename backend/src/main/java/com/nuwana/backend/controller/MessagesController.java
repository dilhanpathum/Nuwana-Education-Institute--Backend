package com.nuwana.backend.controller;

import com.nuwana.backend.config.UserAuthenticationProvider;
import com.nuwana.backend.dto.*;
import com.nuwana.backend.entity.User;
import com.nuwana.backend.service.EnrollService;
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
        return ResponseEntity.ok(createdUser);
    }

    @PostMapping("/user")
    public ResponseEntity<UsersDto> userDetails(@RequestBody UsersDto user) {
        UsersDto usersDto =  userService.getUser(user);
        return ResponseEntity.ok(usersDto);
    }
    @PostMapping("/attendence")
    public ResponseEntity<UsersDto> attendence(@RequestBody UsersDto user) {
        UsersDto usersDto =  userService.getAttendence(user);
        return ResponseEntity.ok(usersDto);
    }

//    @PostMapping("/enroll")
//    public ResponseEntity<EnrollDto> enroll(@RequestBody EnrollDto enrollDto) {
//        EnrollDto enrallUser = enrollService.enroll(enrollDto);
//
//        return ResponseEntity.ok(enrallUser);
//    }
    @GetMapping("/allStudents")
    public List<UsersDto> students(){
        return userService.getAllStudents();
    }
    @GetMapping("/allClassStudents")
    public List<UsersDto> allStudents(){
        return userService.getStudents();
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
