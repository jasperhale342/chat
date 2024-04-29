
package com.example.chat.repositories

import com.example.chat.models.ApplicationUser
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ApplicationUserRepository extends CrudRepository<ApplicationUser, String> {
}