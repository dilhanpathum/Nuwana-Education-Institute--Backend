package com.nuwana.backend.mappers;

import com.nuwana.backend.dto.EnrollDto;
import com.nuwana.backend.entity.Enroll;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EnrollMapper {
    Enroll toEnroll(EnrollDto enrollDto);
    EnrollDto toEnrollDto(Enroll enroll);
}
