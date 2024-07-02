package com.example.PizzaPassport;

import com.example.PizzaPassport.user.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@SpringBootApplication
public class PizzaPassportApplication {

	public static void main(String[] args) {
		SpringApplication.run(PizzaPassportApplication.class, args);
	}
}
