package com.example.chat.controllers

import com.example.chat.models.User
import com.example.chat.services.UserService
import com.example.chat.dto.RegisterUserDto
import com.example.chat.dto.UserDto

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import org.springframework.http.ResponseEntity
import org.springframework.http.HttpStatus
import org.springframework.web.bind.MethodArgumentNotValidException;

import jakarta.transaction.Transactional
import jakarta.validation.Valid


@RestController
@RequestMapping('user')
@Transactional
class UserController {
  @Autowired
  UserService userService

  @Autowired
  ModelMapper modelMapper

  @GetMapping('')
  List findAll() {
    UserService.findAll()
  }

  @GetMapping('{id}')
  User findOne(@PathVariable long id) {
    userService.findById(id)
  }

  @PostMapping(path='', consumes = "application/json", produces = "application/json")
  ResponseEntity<RegisterUserDto> save(@Valid @RequestBody RegisterUserDto registerUserDto) {
    User user = new User(username: registerUserDto.username, firstName: registerUserDto.firstName, lastName: registerUserDto.lastName, password: registerUserDto.password)
    // User user =  modelMapper.map(registerUserDto, User.class)
    userService.create(user)
    return new ResponseEntity<>(registerUserDto, HttpStatus.OK);
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