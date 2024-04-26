// package com.example.chat.repository.impl

// import com.example.chat.repository.CustomFriendRepository
// import com.example.chat.models.User

// import jakarta.persistence.PersistenceContext
// import jakarta.persistence.EntityManager

// class CustomFriendRepositoryImpl implements CustomFriendRepository {

//     @PersistenceContext
//     EntityManager entityManager;

//     @Override
//     List<User> findAllFriendsForUser(String username) {
//          return (User) entityManager.createQuery("SELECT username FROM User INNER JOIN friends ON friends.user_id = :username")
//           .setParameter("username", username)
//           .getMaxResults()
          
        
//     }
// }