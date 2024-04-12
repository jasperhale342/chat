package com.example.chat.controllers

import com.example.chat.models.User
import com.example.chat.services.UserService

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
  User save(@RequestBody User user) {
    userService.save(User)
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