package org.cpp.food_delivery.fooditem.dietaryRestriction;

import org.cpp.food_delivery.customer.Customer;
import org.cpp.food_delivery.fooditem.dietaryRestriction.DietaryRestrictionStrategy;

import java.util.Arrays;
import java.util.List;

public class Vegan implements DietaryRestrictionStrategy {
    public Vegan() {
    }

    public void applyRestriction(List<String> carbs, List<String> proteins, List<String> fats) {
        proteins.removeAll(Arrays.asList("Fish", "Chicken", "Beef"));
        fats.removeAll(Arrays.asList("Cheese", "Sour cream", "Tuna"));
    }
}