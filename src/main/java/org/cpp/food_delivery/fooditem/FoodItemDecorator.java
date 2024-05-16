package org.cpp.food_delivery.fooditem;

import org.cpp.food_delivery.fooditem.FoodItem;

abstract class FoodItemDecorator implements FoodItem {
    protected FoodItem foodItem;

    public FoodItemDecorator(FoodItem foodItem) {
        this.foodItem = foodItem;
    }

    public String getDescription() {
        return this.foodItem.getDescription();
    }

    public double getCost() {
        return this.foodItem.getCost();
    }
}