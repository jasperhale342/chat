package com.example.chat.models

import com.fasterxml.jackson.annotation.JsonManagedReference
import com.fasterxml.jackson.annotation.JsonBackReference

import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.GrantedAuthority

import jakarta.persistence.*

@Entity
@Table(name="users")
class ApplicationUser implements UserDetails {

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
    joinColumns = @JoinColumn(name = "friend_id"), 
    inverseJoinColumns = @JoinColumn(name = "user_id"))
  @JsonBackReference
  Set<ApplicationUser> friends

  @ManyToMany
  @JoinTable(
    name = "friend_requests", 
    joinColumns = @JoinColumn(name = "user_id"), 
    inverseJoinColumns = @JoinColumn(name = "friend_id"))
  Set<ApplicationUser> friendRequests



  boolean enabled = true

  boolean accountNonExpired = true

  boolean accountNonLocked = true

  boolean credentialsNonExpired = true

  Collection<String> authorities
  Collection<? extends GrantedAuthority> getAuthorities() {
    return authorities
  }
  // ApplicationUser loadByUsername(String username){

  // }


  public User() {}
}