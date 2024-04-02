
package com.example.chat.User.repositories

import com.example.User.models.User
import org.springframework.data.repository.CrudRepository

interface UserRepository extends CrudRepository<User, String> {
}