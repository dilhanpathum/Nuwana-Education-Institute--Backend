package com.nuwana.backend.mappers;
import com.nuwana.backend.dto.MarksDto;
import com.nuwana.backend.entity.Marks;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MarksMapper {
    Marks toMarksDto(MarksDto marksDto);
    MarksDto toMarks(Marks marks);
}
