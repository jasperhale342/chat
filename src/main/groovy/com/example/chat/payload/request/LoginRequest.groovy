package com.example.chat.payload.request

import jakarta.validation.constraints.NotBlank;

public class LoginRequest {

    @NotBlank
    String username;

	@NotBlank
	String password;

}