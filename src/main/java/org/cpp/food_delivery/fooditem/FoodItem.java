package org.cpp.food_delivery.fooditem;

import org.cpp.food_delivery.customer.Customer;
import org.cpp.food_delivery.fooditem.dietaryRestriction.DietaryRestrictionStrategy;

import java.util.Arrays;
import java.util.List;

public interface FoodItem {
    String getDescription();

    double getCost();

    class Paleo implements DietaryRestrictionStrategy {
        public Paleo() {
        }

        @Override
        public void applyRestriction(List<String> carbs, List<String> proteins, List<String> fats) {
//            System.out.println(customerName + "'s diet plan is Paleo. No Carbs except pistachio, No Tofu, No Dairy.");
            carbs.removeIf((item) -> {
                return !item.equals("Pistachio");
            });
            proteins.remove("Tofu");
            fats.removeAll(Arrays.asList("Cheese", "Sour cream"));
        }
    }
}
