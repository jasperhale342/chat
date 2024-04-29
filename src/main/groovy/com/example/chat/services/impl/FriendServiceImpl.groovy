package com.example.chat.services.impl

import com.example.chat.repository.FriendRepository
import com.example.chat.services.FriendService
import com.example.chat.models.ApplicationUser

import org.springframework.stereotype.Service
import org.springframework.beans.factory.annotation.Autowired


@Service
class FriendServiceImpl implements FriendService{

  @Autowired
  FriendRepository friendRepository


  List<ApplicationUser> findAllFriendsForUser(String username) {
        return friendRepository.findByFriends_Username(username).toList();


  }



}