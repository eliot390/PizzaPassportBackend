package com.example.PizzaPassport.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PizzaPassportUserService {

  private final PizzaPassportUserRepository pizzaPassportUserRepository;

  @Autowired
  public PizzaPassportUserService(PizzaPassportUserRepository pizzaPassportUserRepository) {
    this.pizzaPassportUserRepository = pizzaPassportUserRepository;
  }

  public List<PizzaPassportUser> getUsers(){
    return pizzaPassportUserRepository.findAll();
  }

  public void addNewUser(PizzaPassportUser pizzaPassportUser) {
    Optional<PizzaPassportUser> userByEmail = pizzaPassportUserRepository.findUserByEmail(pizzaPassportUser.getEmail());
    if (userByEmail.isPresent()){
      throw new IllegalStateException("Email already exists");
    }
    pizzaPassportUserRepository.save(pizzaPassportUser);
  }

  public void deleteUser(Long id) {
    boolean exists = pizzaPassportUserRepository.existsById(id);
    if (!exists){
      throw new IllegalStateException("User ID '" + id + "' does not exist.");
    }
    pizzaPassportUserRepository.deleteById(id);
  }

  @Transactional
  public void updateUser(Long id, String name, String email) {
    PizzaPassportUser pizzaPassportUser = pizzaPassportUserRepository.findById(id).orElseThrow(() -> new IllegalStateException("User does not exist."));
    if (name != null && !name.isEmpty() && !Objects.equals(pizzaPassportUser.getName(), name)){
      pizzaPassportUser.setName(name);
    }
    if (email != null && !email.isEmpty() && !Objects.equals(pizzaPassportUser.getEmail(), email)){
      Optional<PizzaPassportUser> userOptional = pizzaPassportUserRepository.findUserByEmail(email);
      if (userOptional.isPresent()){
        throw new IllegalStateException("Email already in use.");
      }
      pizzaPassportUser.setEmail(email);
    }
  }
}
