package com.example.chat.models

import com.fasterxml.jackson.annotation.JsonIgnore
import org.springframework.security.core.userdetails.UserDetails

import jakarta.persistence.*

@Entity
@Table(name="users")
class User{

  @Id
  String username

  String password

  String firstName

  String lastName

  boolean enabled = true

  boolean accountNonExpired = true

  boolean accountNonLocked = true

  boolean credentialsNonExpired = true

  public User() {}
}