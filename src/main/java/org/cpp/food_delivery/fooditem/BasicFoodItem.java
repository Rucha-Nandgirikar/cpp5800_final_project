package org.cpp.food_delivery.fooditem;

import org.cpp.food_delivery.customer.Customer;

import java.util.List;

public class BasicFoodItem implements FoodItem {
    private String description;
    private double cost;

    public BasicFoodItem(String description, double cost) {
        this.description = description;
        this.cost = cost;
    }

    public String getDescription() {
        return this.description;
    }

    public double getCost() {
        return this.cost;
    }


}
