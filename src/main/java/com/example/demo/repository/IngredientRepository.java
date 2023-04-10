package com.example.demo.repository;

import com.example.demo.Model.Ingredient;
import com.example.demo.Model.IngredientWithCostQuantity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.*;


@Repository
public class IngredientRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public IngredientRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Autowired
    private CostRepository costRepository;

    public List<Ingredient> findAll() {
        String sql = "SELECT * FROM drinks";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Ingredient.class));
    }

    public void restock() {
        String sql = "UPDATE ingredient SET quantity = 10";
        jdbcTemplate.update(sql);
    }

    public void decreaseQuantity(String drinkName) {
        String sql = "UPDATE ingredient SET quantity = quantity - 1 WHERE name = ?";
        jdbcTemplate.update(sql, drinkName);
    }


    public void decreaseIngredientQuantity(String ingredientName, int quantity) {
        String sql = "UPDATE INGREDIENT SET QUANTITY = QUANTITY - ? WHERE NAME = ?";
        jdbcTemplate.update(sql, quantity, ingredientName);

    }


    public List<IngredientWithCostQuantity> findByName(String name) {
        String sql = "SELECT * FROM drinks WHERE name = ?";

        List<List<IngredientWithCostQuantity>> ingredients = jdbcTemplate.query(sql, new Object[]{name}, (rs, rowNum) -> {
            String[] ingredientStrs = rs.getString("ingredients").split(",");
            List<IngredientWithCostQuantity> drinkIngredients = new ArrayList<>();
            for (String ingredientStr : ingredientStrs) {
                String[] parts = ingredientStr.split(":");
                String ingredientName = parts[0].trim();
                int ingredientQuantity = Integer.parseInt(parts[1].trim());
                double unitCost = (double) costRepository.getCostAndQuantityByDrinkName(ingredientName).get("cost_per_unit");
                double totalCost = unitCost * ingredientQuantity;

                IngredientWithCostQuantity ingredient = new IngredientWithCostQuantity();
                ingredient.setName(ingredientName);
                ingredient.setQuantity(ingredientQuantity);
                ingredient.setUnit_cost((float) unitCost);
                ingredient.setTotalCost((float) totalCost);
                drinkIngredients.add(ingredient);
            }
            return drinkIngredients;
        });
        return ingredients.isEmpty() ? null : ingredients.get(0);
    }











}



