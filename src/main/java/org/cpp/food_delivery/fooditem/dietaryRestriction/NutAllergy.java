package org.cpp.food_delivery.fooditem.dietaryRestriction;

import org.cpp.food_delivery.customer.Customer;
import org.cpp.food_delivery.fooditem.dietaryRestriction.DietaryRestrictionStrategy;

import java.util.List;

public class NutAllergy implements DietaryRestrictionStrategy {
    public NutAllergy() {
    }

    public void applyRestriction(List<String> carbs, List<String> proteins, List<String> fats) {
        carbs.remove("Pistachio");
        fats.remove("Peanuts");
    }
}