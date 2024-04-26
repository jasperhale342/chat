package com.example.chat.services

import com.example.chat.models.User

interface FriendService {

    List<User> findAllFriendsForUser(String username)
    // User findOneFriend(String user, String friend)
    // User removeFriend(String user, String friend)



    // List<User> findAllFriendsRequestsForUser(String username)`
    // User findOneFriendRequest(String user, String friend)
    // User acceptFriendRequest(String user, String friend)
    // User declineFriendRequest(String user, String friend)

}