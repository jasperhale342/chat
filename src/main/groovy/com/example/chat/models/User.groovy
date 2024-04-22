package com.example.chat.models

import com.fasterxml.jackson.annotation.JsonIgnore
import org.springframework.security.core.userdetails.UserDetails

import jakarta.persistence.*

@Entity
@Table(name="users")
class User{

  @Id
  @ManyToMany(mappedBy = "friendRequests")
  String username

  String password

  String firstName

  String lastName

  @ManyToMany
  Set<Chat> chats

  @ManyToMany
  Set<User> friends

  @ManyToMany
  @JoinTable(
    name = "friend_requests", 
    joinColumns = @JoinColumn(name = "user_id"), 
    inverseJoinColumns = @JoinColumn(name = "friend_id"))
  Set<User> friendRequests



  boolean enabled = true

  boolean accountNonExpired = true

  boolean accountNonLocked = true

  boolean credentialsNonExpired = true

  public User() {}
}