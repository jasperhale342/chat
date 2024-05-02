package com.example.chat.services

import com.example.chat.models.ApplicationUser
import org.springframework.security.core.userdetails.UserDetailsService

interface ApplicationUserService extends UserDetailsService {

  List<ApplicationUser> findAll()
  ApplicationUser findById(String id)
  ApplicationUser findByIdOrError(String id)
  ApplicationUser create(ApplicationUser user)
  ApplicationUser updatePassword(String id, String password)
  ApplicationUser updateEnabled(String id, boolean enabled)
  ApplicationUser deleteById(String id)

  ApplicationUser loadUserByUsername(String username) 
  // List<User> findAllFriends(String id)


}