package com.nuwana.backend.controller;


import com.nuwana.backend.dto.MarksDto;
import com.nuwana.backend.service.MarksService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequiredArgsConstructor

@RestController
@RequestMapping(value="/api/v1")
public class MarksController {
    @Autowired
    private MarksService marksService;

    @PostMapping("/saveMarks")
    public ResponseEntity<MarksDto> saveMarks(@RequestBody MarksDto marksDto) {
        MarksDto saveMarks = marksService.saveMarks(marksDto);

        return ResponseEntity.ok(saveMarks);
    }

    @GetMapping("/getMarks")
    public List<MarksDto> marks(){
        return marksService.getAllMarks();
    }

}
