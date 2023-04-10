package com.example.demo.Model;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;


public class DrinkResponse {

    private String name;
    private float cost;
    private List<IngredientWithCostQuantity> usedIngredients;

    public DrinkResponse(String name, float cost, List<IngredientWithCostQuantity> usedIngredients) {
        this.name = name;
        this.cost = cost;
        this.usedIngredients = usedIngredients;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public List<IngredientWithCostQuantity> getUsedIngredients() {
        return usedIngredients;
    }

    public void setUsedIngredients(List<IngredientWithCostQuantity> usedIngredients) {
        this.usedIngredients = usedIngredients;
    }
}



