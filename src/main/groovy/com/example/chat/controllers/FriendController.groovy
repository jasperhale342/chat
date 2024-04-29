package com.example.chat.controllers

import com.example.chat.models.ApplicationUser
import com.example.chat.services.FriendService
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
@RequestMapping('friend')
@Transactional
class FriendController {
  
  @Autowired
  FriendService friendService

  @Autowired
  ModelMapper modelMapper

  @GetMapping('/{username}')
  ResponseEntity<List<ApplicationUser>> findAllFriends(@PathVariable("username") String username) {
    List<ApplicationUser>  users = friendService.findAllFriendsForUser(username)
    return new ResponseEntity<List<ApplicationUser>>(users, HttpStatus.OK)

  }

  // @PostMapping('/reuqest')
  // ResponseEntity<List<String>> sendFriendRequest(@PathVariable String username) {
  //   List<String>  users = friendService.findAllFriendsForUser(username)
  //   return new ResponseEntity<List<String>>(users, HttpStatus.OK)

  // }

}