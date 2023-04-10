package com.example.demo.service;

import com.example.demo.Model.Cost;
import com.example.demo.Model.DrinkResponse;
import com.example.demo.Model.Ingredient;
import com.example.demo.Model.IngredientWithCostQuantity;
import com.example.demo.repository.CostRepository;
import com.example.demo.repository.IngredientRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Service
public class DrinkService {

    private final IngredientRepository ingredientRepository;

    private final CostRepository costRepository;

    public DrinkService(IngredientRepository ingredientRepository, CostRepository costRepository) {
        this.ingredientRepository = ingredientRepository;
        this.costRepository = costRepository;
    }

    public DrinkResponse makeMyDrink(String drinkName){
        List<IngredientWithCostQuantity> lists =ingredientRepository.findByName(drinkName);

        float totalCost = lists.stream()
                .map(IngredientWithCostQuantity::getTotalCost)
                .reduce(0f, Float::sum);
        return new DrinkResponse(drinkName, totalCost, lists);
    }

    public List<Ingredient> getMenu() {
        return ingredientRepository.findAll();
    }

    public List<Cost> getInventory() {
        return costRepository.findAllCosts();
    }

   public boolean restock(){
        return costRepository.restock();
   }

}

