package com.example.demo.repository;

import com.example.demo.Model.Cost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Repository
public class CostRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Integer findQuantityByName(String name) {
        String sql = "SELECT quantity FROM cost WHERE name = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{name}, Integer.class);
    }

    public List<Cost> findAllCosts() {
        String sql = "SELECT * FROM cost";
        List<Cost> costs = jdbcTemplate.query(sql, (rs, rowNum) -> {
            Cost cost = new Cost();
            cost.setId(rs.getLong("id"));
            cost.setName(rs.getString("name"));
            cost.setCostPerUnit(rs.getFloat("cost_per_unit"));
            cost.setQuantity(rs.getFloat("quantity"));
            return cost;
        });
        return costs;
    }

    public boolean restock() {
        String sql = "UPDATE cost SET quantity = 10";
        int rowsUpdated = jdbcTemplate.update(sql);
        return rowsUpdated > 0;
    }


    public Integer findCostByName(String name) {
        String sql = "SELECT cost_per_unit FROM cost WHERE name = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{name}, Integer.class);
    }

    public Map<String, Object> getCostAndQuantityByDrinkName(String drinkName) {
        String sql = "SELECT cost_per_unit, quantity FROM cost WHERE name = ?";
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql, drinkName);
        if (rows.isEmpty()) {
            throw new RuntimeException("Drink not found.");
        }
        return rows.get(0);
    }

}

