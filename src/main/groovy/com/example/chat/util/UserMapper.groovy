package com.example.chat.util

import com.example.chat.models.User
import com.example.chat.dto.UserDto
import com.example.chat.dto.RegisterUserDto
import com.example.chat.config.modelMapper

import org.springframework.stereotype.Component



@Component
class UserMapper {
    // UserDto convertToDto(User user) {
    //     UserDto userDto = new UserDto(user.username, user.firstName, user.lastName)
    //     return userDto
    // }

    // User toUser(UserCreationDTO userDTO) {

    //     return new User(userDTO.getName(), userDTO.getPassword(), new ArrayList<>());
    // }

    User toUserFromRegisterUser(RegisterUserDto registerUserDto) {
        User user = modelMapper.map(registerUserDto,  User.class)
        return user

    }
}