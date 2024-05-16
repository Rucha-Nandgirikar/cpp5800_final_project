package org.cpp.food_delivery.fooditem.dietaryRestriction;
import org.cpp.food_delivery.customer.Customer;
import org.cpp.food_delivery.fooditem.dietaryRestriction.DietaryRestrictionStrategy;

import java.util.List;

public class NoRestriction implements DietaryRestrictionStrategy {
    public NoRestriction() {
    }

    public void applyRestriction(List<String> carbs, List<String> proteins, List<String> fats) {
        System.out.println("Diet plan is No Restriction. All food items are allowed.");
    }
}