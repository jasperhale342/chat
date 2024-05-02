package com.example.chat.controllers;

import com.example.chat.payload.request.LoginRequest

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.core.Authentication
import org.springframework.http.HttpStatus
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken

@RestController
class LoginController {
    private final AuthenticationManager authenticationManager;

	public LoginController(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}


    @PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
		println(loginRequest.username + "  " + loginRequest.password)
		Authentication authenticationRequest =
			UsernamePasswordAuthenticationToken.unauthenticated(loginRequest.username, loginRequest.password);
		Authentication authenticationResponse =
			this.authenticationManager.authenticate(authenticationRequest);
		// ...
		return new ResponseEntity<String> ("logged in", HttpStatus.OK)
	}


}