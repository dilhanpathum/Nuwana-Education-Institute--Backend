package com.nuwana.backend.controller;

import com.nuwana.backend.dto.EnrollDto;
import com.nuwana.backend.dto.UpdateDto;
import com.nuwana.backend.dto.UserDto;
import com.nuwana.backend.dto.UsersDto;
import com.nuwana.backend.service.EnrollService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value="/api/v1")
public class EnrollController {
    private final EnrollService enrollService;

    public EnrollController(EnrollService enrollService) {
        this.enrollService = enrollService;
    }

    @PostMapping("/enroll")
    public ResponseEntity<EnrollDto> enroll(@RequestBody EnrollDto enrollDto) {
        EnrollDto enrallUser = enrollService.enroll(enrollDto);

        return ResponseEntity.ok(enrallUser);
    }

    @GetMapping("/students")
    public List<EnrollDto> students(){
        return enrollService.getAllStudents();
    }

    @PutMapping("/updateStatus")
    public ResponseEntity<EnrollDto> profileEdit(@RequestBody @Valid EnrollDto user) {
        EnrollDto createdUser = enrollService.acceptEnroll(user);
        return ResponseEntity.ok(createdUser);
    }

    @GetMapping("/acceptStudents")
    public List<EnrollDto> acceptStudents(){
        return enrollService.getAcceptStudents();
    }
}
