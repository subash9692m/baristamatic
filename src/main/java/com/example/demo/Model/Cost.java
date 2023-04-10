package com.example.demo.Model;

public class Cost {
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

    public float getCostPerUnit() {
        return costPerUnit;
    }

    public void setCostPerUnit(float costPerUnit) {
        this.costPerUnit = costPerUnit;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    private Long id;
    private String name;
    private float costPerUnit;
    private float quantity;

    // Constructors, getters, and setters
}

