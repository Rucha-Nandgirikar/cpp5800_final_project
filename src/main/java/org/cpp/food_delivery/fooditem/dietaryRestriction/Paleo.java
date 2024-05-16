package org.cpp.food_delivery.fooditem.dietaryRestriction;

import org.cpp.food_delivery.customer.Customer;
import org.cpp.food_delivery.fooditem.dietaryRestriction.DietaryRestrictionStrategy;

import java.util.Arrays;
import java.util.List;

public class Paleo implements DietaryRestrictionStrategy {
    @Override
    public void applyRestriction(List<String> carbs, List<String> proteins, List<String> fats) {
        carbs.removeIf((item) -> {
            return !item.equals("Pistachio");
        });
        proteins.remove("Tofu");
        fats.removeAll(Arrays.asList("Cheese", "Sour cream"));
    }

}