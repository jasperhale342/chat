package com.example.chat.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class HelloController {

    @GetMapping("/")
    String index() {
        return "Greetings from Spring Boot!"
    }

	@GetMapping("/home")
    String home() {
        return "Home Page"
    }

}