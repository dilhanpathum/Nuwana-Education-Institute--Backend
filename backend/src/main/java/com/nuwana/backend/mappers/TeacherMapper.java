package com.nuwana.backend.mappers;

import com.nuwana.backend.dto.EnrollDto;
import com.nuwana.backend.dto.TeacherDto;
import com.nuwana.backend.entity.Enroll;
import com.nuwana.backend.entity.Teacher;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TeacherMapper {
    Teacher toTeacher(TeacherDto teacherDto);
    TeacherDto toTeacherDto(Teacher teacher);
}
