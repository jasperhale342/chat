
package com.example.chat.repositories

import com.example.chat.models.User
import org.springframework.data.repository.CrudRepository

interface UserRepository extends CrudRepository<User, String> {
}