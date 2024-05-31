package com.nuwana.backend.mappers;

import com.nuwana.backend.dto.SignUpDto;
import com.nuwana.backend.dto.UpdateDto;
import com.nuwana.backend.dto.UserDto;
import com.nuwana.backend.entity.User;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toUserDto(User user);

    @Mapping(target = "password" ,ignore = true)
    User signUpToUser(SignUpDto signUpDto);

    User updateToUser(UpdateDto updateDto);

}
