
package com.example.chat.user.repositories

import com.example.chat.user.models.User
import org.springframework.data.repository.CrudRepository

interface UserRepository extends CrudRepository<User, String> {
}