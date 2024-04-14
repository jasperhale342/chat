package org.example.chat.config

import org.springframework.context.annotation.Bean


@Bean
ModelMapper modelMapper() {
    return new ModelMapper();
}