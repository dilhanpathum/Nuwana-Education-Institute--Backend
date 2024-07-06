package com.nuwana.backend.controller;

import com.nuwana.backend.dto.EnrollDto;
import com.nuwana.backend.dto.UsersDto;
import com.nuwana.backend.service.EnrollService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
