package com.example.chat.services.impl

import com.example.chat.models.User
import com.example.chat.services.UserService
import com.example.chat.repositories.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

import jakarta.persistence.EntityNotFoundException

@Service
class UserServiceImpl implements UserService{
  @Autowired
  UserRepository userRepository

  @Autowired
  PasswordEncoder passwordEncoder

  List<User> findAll() {
    userRepository.findAll().asList()
  }

  User findById(String id) {
    userRepository.findById(id).orElse(null)
  }

  User findByIdOrError(String id) {
    userRepository.findById(id).orElseThrow({
      new EntityNotFoundException()
    })
  }

  User create(User user) {
    user.password = passwordEncoder.encode(user.password)
    userRepository.save(user)
  }

  User updatePassword(String id, String password) {
    def user = findByIdOrError(id)
    user.password = passwordEncoder.encode(password)
    userRepository.save(user)
  }

  User updateEnabled(String id, boolean enabled) {
    def user = findByIdOrError(id)
    user.enabled = enabled
    userRepository.save(user)
  }

  User deleteById(String id) {
    def user = findByIdOrError(id)
    userRepository.delete(user)
    user
  }


}