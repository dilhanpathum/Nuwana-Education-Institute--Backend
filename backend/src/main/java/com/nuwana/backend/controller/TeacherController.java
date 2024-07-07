package com.nuwana.backend.controller;

import com.nuwana.backend.dto.EnrollDto;
import com.nuwana.backend.dto.TeacherDto;
import com.nuwana.backend.service.EnrollService;
import com.nuwana.backend.service.TeacherService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/api/v1")
public class TeacherController {
    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping("/teachers")
    public List<TeacherDto> teachers(){
        return teacherService.getAllTeachers();
    }
}
