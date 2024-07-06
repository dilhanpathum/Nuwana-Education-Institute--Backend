package com.nuwana.backend.service;


import com.nuwana.backend.dto.*;
import com.nuwana.backend.entity.Enroll;
import com.nuwana.backend.entity.User;
import com.nuwana.backend.exceptions.AppException;
import com.nuwana.backend.mappers.UserMapper;
import com.nuwana.backend.repository.EnrollRepo;
import com.nuwana.backend.repository.UserRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.CharBuffer;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserMapper userMapper;
    public UserDto login(SignInDto signInDto) {
        User user = userRepo.findByEmail(signInDto.getEmail())
                .orElseThrow(() -> new AppException("Email or Password Invalid", HttpStatus.NOT_FOUND));

        if (passwordEncoder.matches(CharBuffer.wrap(signInDto.getPassword()), user.getPassword())) {
            return userMapper.toUserDto(user);
        }
        throw new AppException("Email or Password Invalid", HttpStatus.BAD_REQUEST);
    }

    public UserDto register(SignUpDto signUpDto) {
        Optional<User> optionalUser = userRepo.findByEmail(signUpDto.getEmail());

        if (optionalUser.isPresent()) {
            throw new AppException("Login already exists", HttpStatus.BAD_REQUEST);
        }

        User user = userMapper.signUpToUser(signUpDto);
        user.setPassword(passwordEncoder.encode(CharBuffer.wrap(signUpDto.getPassword())));

        User savedUser = userRepo.save(user);

        return userMapper.toUserDto(savedUser);
    }

    public UserDto profileEdit(UpdateDto updateDto) {
        User user = userRepo.findUserByemail(updateDto.getEmail());
//        User user = userRepo.getById(updateDto.getId());
        user.setFirstname(updateDto.getFirstname());
        user.setLastname(updateDto.getLastname());
        user.setContact(updateDto.getContact());
        user.setEmail(updateDto.getEmail());

        User saveuser = userRepo.save(user);

        return userMapper.toUserDto(saveuser);
    }

    public List<UsersDto> getAllStudents(){
        List<User> studentList = userRepo.findAll();
        return modelMapper.map(studentList, new TypeToken<List<UsersDto>>(){}.getType());
    }
    public UsersDto getUser(UsersDto updateDto){
        User user = userRepo.findUserByemail(updateDto.getEmail());
        return userMapper.toUsersDto(user);
    }

    public UserDto findByLogin(String email) {
        User user = userRepo.findByEmail(email)
                .orElseThrow(() -> new AppException("Unknown user", HttpStatus.NOT_FOUND));
        return userMapper.toUserDto(user);
    }



}
