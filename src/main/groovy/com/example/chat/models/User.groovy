package com.chat.User.models

import com.fasterxml.jackson.annotation.JsonIgnore
import org.springframework.security.core.userdetails.UserDetails

import jakarta.persistence.*

@Entity
abstract class User implements UserDetails {

  @Id
  String username

  String password

  boolean enabled = true

  boolean accountNonExpired = true

  boolean accountNonLocked = true

  boolean credentialsNonExpired = true
}