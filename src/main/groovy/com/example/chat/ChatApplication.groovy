package com.example.springboot;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ChatApplication {

	static void main(String[] args) {
    SpringApplication.run(ChatApplication, args)
}

	@Bean
	CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return { String[] args ->
			println("Let's inspect the beans provided by Spring Boot:")
			def beanNames = ctx.getBeanDefinitionNames()
			beanNames.sort()
			beanNames.each { beanName ->
				println(beanName)
			}
		}
	}

}