package com.example.PizzaPassport;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class PizzaPassportApplication {

	public static void main(String[] args) {
		SpringApplication.run(PizzaPassportApplication.class, args);
	}
}
