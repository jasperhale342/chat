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


  @OneToMany
  Set<Message> messages

  @ManyToMany
  @JoinTable(
  name = "chat_rooms", 
  joinColumns = @JoinColumn(name = "user_id"), 
  inverseJoinColumns = @JoinColumn(name = "chat_id"))
  Set<Chat> chats

  @ManyToMany
   @JoinTable(
    name = "friends", 
    joinColumns = @JoinColumn(name = "user_id"), 
    inverseJoinColumns = @JoinColumn(name = "friend_id"))
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