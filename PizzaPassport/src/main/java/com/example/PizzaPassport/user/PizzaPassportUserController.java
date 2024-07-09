package com.example.PizzaPassport.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/user")
public class PizzaPassportUserController {

  private final PizzaPassportUserService pizzaPassportUserService;

  @Autowired
  public PizzaPassportUserController(PizzaPassportUserService pizzaPassportUserService) {
    this.pizzaPassportUserService = pizzaPassportUserService;
  }

  @GetMapping
  public List<PizzaPassportUser> getUsers(){
    return pizzaPassportUserService.getUsers();
  }

  @Autowired
  private PizzaPassportUserRepository pizzaPassportUserRepository;
  @GetMapping("/{id}")
  /**
   * Get single user
   * http://localhost:8080/api/v1/user/4
   * @param id
   */
  public ResponseEntity<PizzaPassportUser> getUserById(@PathVariable Long id){
    return pizzaPassportUserRepository.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
  }

  @PostMapping
  /**
   * Add new user
   * @param user
   * {
   *     "name": "Cheddar",
   *     "email": "cheds@gmail.com",
   *     "birthday": "2022-07-26"
   * }
   */
  public void registerNewUser(@RequestBody PizzaPassportUser pizzaPassportUser){
    pizzaPassportUserService.addNewUser(pizzaPassportUser);
  }

  @DeleteMapping(path = "{userId}")
  /**
   * http://localhost:8080/api/v1/user/4
   * @param id
   */
  public void deleteUser(@PathVariable("userId") Long id){
    pizzaPassportUserService.deleteUser(id);
  }

  @PutMapping(path = "{userId}")
  /**
   * Update/change user info
   * http://localhost:8080/api/v1/user/4?name=Name&email=Email
   * @param id
   * @param name
   * @param email
   */
  public void updateUser(@PathVariable("userId") Long id,
                           @RequestParam(required = false) String name,
                           @RequestParam(required = false) String email) {
    pizzaPassportUserService.updateUser(id, name, email); }
}
