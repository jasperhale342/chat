package com.example.chat.controllers

import com.example.chat.models.ApplicationUser
import com.example.chat.services.ApplicationUserService
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
  ApplicationUserService applicationUserService

  @Autowired
  ModelMapper modelMapper

  @GetMapping('')
  ResponseEntity<List<UserDto>> findAll() {
    List<ApplicationUser>  users = applicationUserService.findAll()
    List<UserDto> userDtos = new  ArrayList<UserDto>();
    for(user: users) {
      UserDto userDto = new UserDto(firstName:user.firstName, lastName:user.lastName, username:user.username);
      userDtos.add(userDto)
    }

  return new ResponseEntity<List<UserDto>>(userDtos, HttpStatus.OK)

  }

  @GetMapping('{id}')
  ApplicationUser findOne(@PathVariable long id) {
    applicationUserService.findById(id)
  }

  @PostMapping(path='', consumes = "application/json", produces = "application/json")
  ResponseEntity<RegisterUserDto> save(@Valid @RequestBody RegisterUserDto registerUserDto) {
    ApplicationUser user = new ApplicationUser(username: registerUserDto.username, firstName: registerUserDto.firstName, lastName: registerUserDto.lastName, password: registerUserDto.password)
    // User user =  modelMapper.map(registerUserDto, User.class)
    applicationUserService.create(user)
    return new ResponseEntity<>(registerUserDto, HttpStatus.OK);
  }

  @PutMapping('{id}')
  ApplicationUser update(@RequestBody ApplicationUser user, @PathVariable long id) {
    applicationUserService.update(user, id)
  }

  @DeleteMapping('{id}')
  ApplicationUser deleteById(@PathVariable long id) {
    applicationUserService.deleteById(id)
  }
}