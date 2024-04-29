package com.example.chat.services.impl

import com.example.chat.models.ApplicationUser
import com.example.chat.services.ApplicationUserService
import com.example.chat.repositories.ApplicationUserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

import jakarta.persistence.EntityNotFoundException

@Service
class ApplicationUserServiceImpl implements ApplicationUserService{
  @Autowired
  ApplicationUserRepository applicationUserRepository

  @Autowired
  PasswordEncoder passwordEncoder

  List<ApplicationUser> findAll() {
    return applicationUserRepository.findAll().asList()
  }

  ApplicationUser findById(String id) {
    applicationUserRepository.findById(id).orElse(null)
  }

  ApplicationUser findByIdOrError(String id) {
    applicationUserRepository.findById(id).orElseThrow({
      new EntityNotFoundException()
    })
  }

  ApplicationUser create(ApplicationUser user) {
    user.password = passwordEncoder.encode(user.password)
    applicationUserRepository.save(user)
  }

  ApplicationUser updatePassword(String id, String password) {
    def user = applicationUserRepository.findByIdOrError(id)
    user.password = passwordEncoder.encode(password)
    applicationUserRepository.save(user)
  }

  ApplicationUser updateEnabled(String id, boolean enabled) {
    def user = applicationUserRepository.findByIdOrError(id)
    user.enabled = enabled
    applicationUserRepository.save(user)
  }

  ApplicationUser deleteById(String id) {
    def user = findByIdOrError(id)
    applicationUserRepository.delete(user)
    user
  }


}