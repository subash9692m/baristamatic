package com.example.demo.repository;

import com.example.demo.Model.Drink;
import com.example.demo.Model.Ingredient;

import java.util.List;
import java.util.Optional;

public interface DrinkRepository {
    Optional<Drink> findByName(String name);
    List<Drink> findAll();
    void updateIngredientQuantity(String name, int newQuantity);

}

