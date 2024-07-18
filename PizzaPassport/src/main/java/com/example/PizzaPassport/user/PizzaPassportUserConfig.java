package com.example.PizzaPassport.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

@Configuration
public class PizzaPassportUserConfig {

  @Bean
  CommandLineRunner commandLineRunner(PizzaPassportUserRepository repository) {
    return args -> {
      PizzaPassportUser eliot = new PizzaPassportUser(
              "Eliot Pardo",
              "eliot.pardo@gmail.com",
              LocalDate.of(1982, Month.NOVEMBER, 23),
              "Bestia",
              "Lamb Sausage",
              Arrays.asList("Bestia", "Pizzeria Sei", "Dino's", "Bestia")
      );
//      PizzaPassportUser joanne = new PizzaPassportUser(
//              "Joanne Pardo",
//              "joanne214@gmail.com",
//              LocalDate.of(1983, Month.FEBRUARY, 14)
//      );
//      PizzaPassportUser cheddar = new PizzaPassportUser(
//              "Cheddar Pardo",
//              "cheds@gmail.com",
//              LocalDate.of(2022, Month.JULY, 26)
//      );
//      PizzaPassportUser colby = new PizzaPassportUser(
//              "Colby Pardo",
//              "colbs@gmail.com",
//              LocalDate.of(2022, Month.JULY, 26)
//      );
      repository.saveAll(List.of(eliot));
    };
  }
}
