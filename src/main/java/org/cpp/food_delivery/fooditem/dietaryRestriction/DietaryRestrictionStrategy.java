package org.cpp.food_delivery.fooditem.dietaryRestriction;

import org.cpp.food_delivery.customer.Customer;

import java.util.List;

public interface DietaryRestrictionStrategy {
        void applyRestriction(List<String> carbs, List<String> proteins, List<String> fats);
}
