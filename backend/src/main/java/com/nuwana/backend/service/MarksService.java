package com.nuwana.backend.service;


import com.nuwana.backend.dto.MarksDto;

import com.nuwana.backend.entity.Marks;
import com.nuwana.backend.mappers.MarksMapper;
import com.nuwana.backend.repository.MarksRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MarksService {
    @Autowired
    private MarksRepo marksRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private MarksMapper marksMapper;

    public MarksDto saveMarks(MarksDto marksDto) {

        Marks marks = marksMapper.toMarksDto(marksDto);


        Marks savedMarks = marksRepo.save(marks);

        return marksMapper.toMarks(savedMarks);
    }

    public List<MarksDto> getAllMarks(){
        Pageable topFive = PageRequest.of(0, 5);
        List<Marks> marksList = marksRepo.findTop5ByMarks(topFive);
        return modelMapper.map(marksList, new TypeToken<List<MarksDto>>(){}.getType());
    }

}
