package com.example.chat.dto

// import com.example.chat.validation.PasswordMatchValidator
import com.example.chat.validation.PasswordMatch;

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size


@PasswordMatch
class RegisterUserDto {
    public RegisterUserDto() {}

    @NotEmpty(message = "First name is required.")
    @Size(min = 2, max = 100, message = "The length of full name must be between 2 and 100 characters.")
    String firstName

    @NotEmpty(message = "Last name is required.")
    @Size(min = 2, max = 100, message = "The length of full name must be between 2 and 100 characters.")
    String lastName
    
    @NotEmpty(message = "Username is required.")
    @Size(min = 2, max = 100, message = "The length of full name must be between 2 and 100 characters.")
    String username

    @NotEmpty(message = "password is required.")
  
    String password
    
    @NotEmpty(message = "confirm password is required.")
    String password2


}