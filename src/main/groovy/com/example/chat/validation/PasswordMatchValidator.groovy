package com.example.chat.validation

import com.example.chat.dto.RegisterUserDto

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


public class PasswordMatchValidator implements ConstraintValidator<PasswordMatch, RegisterUserDto>{

    @Override
    public void initialize(PasswordMatch p) {
        
    }
    
    public boolean isValid(RegisterUserDto user, ConstraintValidatorContext c) {
        String plainPassword = user.password;
        String repeatPassword = user.password2;
        
        if(plainPassword == null || !plainPassword.equals(repeatPassword)) {
            return false;
        }
        
        return true;
    }

}