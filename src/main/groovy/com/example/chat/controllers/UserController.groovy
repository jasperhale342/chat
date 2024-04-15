package com.example.chat.controllers

import com.example.chat.models.User
import com.example.chat.services.UserService
import com.example.chat.dto.RegisterUserDto
import com.example.chat.dto.UserDto

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*



import jakarta.transaction.Transactional

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
  @ResponseBody
  User save(@RequestBody RegisterUserDto registerUserDto) {

    println("about to add a user")
    // println(registerUserDto.firstName)
    // if (registerUserDto.password != registerUserDto.password2) {
    //   return "error"
    // } 
    User user =  modelMapper.map(registerUserDto, User.class)
    println("mapped user")
    println(user.dump())
    User _user = userService.create(user)
    println("created user")
    println(_user.firstName)
    return _user
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