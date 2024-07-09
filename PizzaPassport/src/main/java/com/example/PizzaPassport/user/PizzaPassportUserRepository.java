package com.example.PizzaPassport.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PizzaPassportUserRepository extends JpaRepository<PizzaPassportUser, Long> {

  @Query("SELECT u FROM PizzaPassportUser u WHERE u.email = ?1")
  Optional<PizzaPassportUser> findUserByEmail(String email);
}
