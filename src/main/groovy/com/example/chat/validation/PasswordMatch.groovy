package com.example.chat.validation;

import static java.lang.annotation.ElementType;
import static java.lang.annotation.RetentionPolicy;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy=PasswordMatchValidator.class)
@Documented
public @interface PasswordMatch {
    String message() default "password and confirm password do not match";
    
    Class<?>[] groups() default {};
    
    Class<? extends Payload>[] payload() default {};
}