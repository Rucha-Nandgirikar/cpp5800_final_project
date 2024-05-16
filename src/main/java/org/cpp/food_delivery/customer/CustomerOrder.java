package org.cpp.food_delivery.customer;
import org.cpp.food_delivery.fooditem.FoodItem;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
public class CustomerOrder {

    private List<FoodItem> foodItems = new ArrayList<>();
    private Customer customer;

    public CustomerOrder(Customer customer) {
        this.customer = customer;
    }

    public void addFoodItem(FoodItem foodItem) {
        this.foodItems.add(foodItem);
    }

    public double calculateTotalCost() {
        double total = 0;
        for (FoodItem foodItem : this.foodItems) {
            total += foodItem.getCost();
        }

        return total;
    }

    public List<FoodItem> getFoodItems() {
        return this.foodItems;
    }
}
