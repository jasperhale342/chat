package com.example.chat.services

import com.example.chat.models.User

interface UserService {

  List<User> findAll()
  User findById(String id)
  User findByIdOrError(String id)
  User create(User user)
  User updatePassword(String id, String password)
  User updateEnabled(String id, boolean enabled)
  User deleteById(String id)


}