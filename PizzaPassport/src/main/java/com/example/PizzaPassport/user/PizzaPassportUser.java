package com.example.PizzaPassport.user;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Entity
@Table
public class PizzaPassportUser {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
  @SequenceGenerator(name = "user_seq", sequenceName = "user_sequence", allocationSize = 1)

  private Long id;
  private String name;
  private String email;
  private LocalDate birthday;
  private String favoriteRestaurant;
  private String favoritePizza;
  private List<String> visitedRestaurantList;

  public PizzaPassportUser() {
  }

  public PizzaPassportUser(Long id, String name, String email, LocalDate birthday, String favoriteRestaurant, String favoritePizza, List<String> visitedRestaurantList) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.birthday = birthday;
    this.favoriteRestaurant = favoriteRestaurant;
    this.favoritePizza = favoritePizza;
    this.visitedRestaurantList = visitedRestaurantList;
  }

  public PizzaPassportUser(String name, String email, LocalDate birthday, String favoriteRestaurant, String favoritePizza, List<String> visitedRestaurantList) {
    this.name = name;
    this.email = email;
    this.birthday = birthday;
    this.favoriteRestaurant = favoriteRestaurant;
    this.favoritePizza = favoritePizza;
    this.visitedRestaurantList = visitedRestaurantList;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public LocalDate getBirthday() {
    return birthday;
  }

  public void setBirthday(LocalDate birthday) {
    this.birthday = birthday;
  }

  public String getFavoriteRestaurant() {
    return favoriteRestaurant;
  }

  public void setFavoriteRestaurant(String favoriteRestaurant) {
    this.favoriteRestaurant = favoriteRestaurant;
  }

  public String getFavoritePizza() {
    return favoritePizza;
  }

  public void setFavoritePizza(String favoritePizza) {
    this.favoritePizza = favoritePizza;
  }

  public List<String> getVisitedRestaurantList() {
    return visitedRestaurantList;
  }

  public void setVisitedRestaurantList(List<String> visitedRestaurantList) {
    this.visitedRestaurantList = visitedRestaurantList;
  }

  @Override
  public String toString() {
    return super.toString();
  }
}
