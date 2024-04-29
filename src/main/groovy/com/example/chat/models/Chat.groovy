package com.example.chat.models
import jakarta.persistence.*
@Entity
@Table(name="chats")
class Chat {

    @Id
    Integer Id

    @ManyToMany(mappedBy = "chats")
    Set<ApplicationUser> users

    @OneToMany(mappedBy = "room")
    Set<Message> messages



}