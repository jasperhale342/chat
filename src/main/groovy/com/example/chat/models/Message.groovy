package com.example.chat.models

import jakarta.persistence.*
@Entity
@Table(name="messages")
class Message {
    
    @Id
    Integer Id
    
    @ManyToOne
    @JoinColumn(name = "author_id")
    ApplicationUser author

    @ManyToOne
    @JoinColumn(name = 'chat_id')
    Chat room

    String message

    Date createdAt

}