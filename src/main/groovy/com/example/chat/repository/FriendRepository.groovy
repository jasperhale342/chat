package com.example.chat.repository

import org.springframework.data.jpa.repository.JpaRepository

import com.example.chat.models.ApplicationUser
// import com.example.chat.repository.CustomFriendRepository

import org.springframework.stereotype.Repository
import org.springframework.data.repository.Repository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param





interface FriendRepository extends JpaRepository <ApplicationUser, String> {

    List<ApplicationUser> findByFriends_Username( String username)

}