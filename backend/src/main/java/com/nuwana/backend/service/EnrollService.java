package com.nuwana.backend.service;

import com.nuwana.backend.dto.EnrollDto;
import com.nuwana.backend.dto.UpdateDto;
import com.nuwana.backend.dto.UserDto;
import com.nuwana.backend.dto.UsersDto;
import com.nuwana.backend.entity.Enroll;
import com.nuwana.backend.entity.User;
import com.nuwana.backend.mappers.EnrollMapper;
import com.nuwana.backend.mappers.UserMapper;
import com.nuwana.backend.repository.EnrollRepo;
import com.nuwana.backend.repository.UserRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class EnrollService {
    @Autowired
    private EnrollRepo enrollRepo;


    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private EnrollMapper enrollMapper;

    public EnrollDto enroll(EnrollDto enrollDto) {

        Enroll enroll = enrollMapper.toEnroll(enrollDto);


        Enroll enrollUser = enrollRepo.save(enroll);

        return enrollMapper.toEnrollDto(enrollUser);
    }

    public List<EnrollDto> getAllStudents(){
        List<Enroll> studentList = enrollRepo.findAllPendingEnrolls();
        return modelMapper.map(studentList, new TypeToken<List<EnrollDto>>(){}.getType());
    }

    public EnrollDto acceptEnroll(EnrollDto enrollDto) {
        Enroll user = enrollRepo.findUserByemail(enrollDto.getEmail());

        user.setStatus(enrollDto.getStatus());


        Enroll saveuser = enrollRepo.save(user);

        return enrollMapper.toEnrollDto(saveuser);
    }

    public List<EnrollDto> getAcceptStudents(){
        List<Enroll> studentList = enrollRepo.findAllAcceptedEnrolls();
        return modelMapper.map(studentList, new TypeToken<List<EnrollDto>>(){}.getType());
    }

    public List<EnrollDto> getStudents(){
        List<Enroll> studentList = enrollRepo.findAll();
        return modelMapper.map(studentList, new TypeToken<List<EnrollDto>>(){}.getType());
    }
}
