package org.cpp.food_delivery.fooditem;

import org.cpp.food_delivery.fooditem.FoodItem;
import org.cpp.food_delivery.fooditem.FoodItemDecorator;

public class ToppingDecorator extends FoodItemDecorator {
    private String topping;
    private double toppingCost;

    public ToppingDecorator(FoodItem foodItem, String topping, double toppingCost) {
        super(foodItem);
        this.topping = topping;
        this.toppingCost = toppingCost;
    }

    public String getDescription() {
        return this.foodItem.getDescription() + ", " + this.topping;
    }

    public double getCost() {
        return this.foodItem.getCost() + this.toppingCost;
    }
}
