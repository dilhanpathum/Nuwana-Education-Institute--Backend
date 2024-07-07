package com.nuwana.backend.service;

import com.nuwana.backend.dto.EnrollDto;
import com.nuwana.backend.dto.TeacherDto;
import com.nuwana.backend.entity.Enroll;
import com.nuwana.backend.entity.Teacher;
import com.nuwana.backend.mappers.EnrollMapper;
import com.nuwana.backend.mappers.TeacherMapper;
import com.nuwana.backend.repository.EnrollRepo;
import com.nuwana.backend.repository.TeacherRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class TeacherService {
    @Autowired
    private TeacherRepo teacherRepo;


    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private TeacherMapper teacherMapper;

    public List<TeacherDto> getAllTeachers(){
        List<Teacher> teachersList = teacherRepo.findAll();
        return modelMapper.map(teachersList, new TypeToken<List<TeacherDto>>(){}.getType());
    }
}
