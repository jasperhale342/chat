package com.example.chat.controllers

import com.example.chat.models.User
import com.example.chat.services.UserService
import com.example.chat.dto.RegisterUserDto
import com.example.chat.dto.UserDto
import com.example.chat.util.UserMapper

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*



import jakarta.transaction.Transactional

@RestController
@RequestMapping('user')
@Transactional
class UserController {
  @Autowired
  UserService userService

  @GetMapping('')
  List findAll() {
    UserService.findAll()
  }

  @GetMapping('{id}')
  User findOne(@PathVariable long id) {
    userService.findById(id)
  }

  @PostMapping('')
  String save(@RequestBody RegisterUserDto registerUserDto) {
    if (registerUserDto.password != registerUserDto.password2) {
      return "error"
    } 
    def user =  UserMapper.toUserFromRegisterUser(registerUserDto)
    userService.save(user)
    return "user created"
  }

  @PutMapping('{id}')
  User update(@RequestBody User user, @PathVariable long id) {
    userService.update(User, id)
  }

  @DeleteMapping('{id}')
  User deleteById(@PathVariable long id) {
    userService.deleteById(id)
  }
}