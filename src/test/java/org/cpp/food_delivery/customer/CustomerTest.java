package org.cpp.food_delivery.customer;

import org.cpp.food_delivery.fooditem.dietaryRestriction.DietaryRestrictionStrategy;
import org.cpp.food_delivery.fooditem.dietaryRestriction.Vegan;
import org.cpp.food_delivery.fooditem.dietaryRestriction.Paleo;
import org.cpp.food_delivery.fooditem.dietaryRestriction.NoRestriction;
import org.cpp.food_delivery.fooditem.dietaryRestriction.NutAllergy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {
    private Customer customer;
    private DietaryRestrictionStrategy veganStrategy;
    private DietaryRestrictionStrategy paleoStrategy;
    private DietaryRestrictionStrategy noRestrictionStrategy;
    private DietaryRestrictionStrategy nutAllergyStrategy;

    @BeforeEach
    void setUp() {
        veganStrategy = new Vegan();
        paleoStrategy = new Paleo();
        noRestrictionStrategy = new NoRestriction();
        nutAllergyStrategy = new NutAllergy();
        customer = new Customer("John Doe", "123 Maple St", "County A", veganStrategy);
    }

    @Test
    void testGetAddress() {
        assertEquals("123 Maple St", customer.getAddress());
    }

    @Test
    void testGetCounty() {
        assertEquals("County A", customer.getCounty());
    }

    @Test
    void testGetDietaryRestrictionStrategy() {
        assertEquals(veganStrategy, customer.getDietaryRestrictionStrategy());
    }

    @Test
    void testSetDietaryRestrictionStrategy() {
        customer.setDietaryRestrictionStrategy(paleoStrategy);
        assertEquals(paleoStrategy, customer.getDietaryRestrictionStrategy());
    }

    @Test
    void testApplyDietaryRestriction() {
        List<String> carbs = new ArrayList<>(Arrays.asList("Pizza", "Bread", "Rice"));
        List<String> proteins = new ArrayList<>(Arrays.asList("Chicken", "Tofu", "Fish"));
        List<String> fats = new ArrayList<>(Arrays.asList("Cheese", "Bacon", "Avocado"));

        // Apply vegan strategy
        customer.applyDietaryRestriction(carbs, proteins, fats);
        assertTrue(carbs.contains("Bread")); // Vegan diet excludes Bread
        assertTrue(proteins.contains("Tofu")); // Vegan diet includes Tofu
        assertTrue(fats.contains("Bacon")); // Vegan diet excludes Bacon

        // Change to paleo strategy and re-test
        customer.setDietaryRestrictionStrategy(paleoStrategy);
        carbs = new ArrayList<>(Arrays.asList("Pizza", "Bread", "Rice"));
        proteins = new ArrayList<>(Arrays.asList("Chicken", "Tofu", "Fish"));
        fats = new ArrayList<>(Arrays.asList("Cheese", "Bacon", "Avocado"));

        customer.applyDietaryRestriction(carbs, proteins, fats);
        assertFalse(carbs.contains("Bread")); // Paleo diet excludes Bread
        assertFalse(carbs.contains("Rice")); // Paleo diet excludes Rice
        assertTrue(proteins.contains("Chicken")); // Paleo diet includes Chicken
        assertFalse(proteins.contains("Tofu")); // Paleo diet excludes Tofu
        assertTrue(fats.contains("Avocado")); // Paleo diet includes Avocado

        // Change to no restriction strategy and re-test
        customer.setDietaryRestrictionStrategy(noRestrictionStrategy);
        carbs = new ArrayList<>(Arrays.asList("Pizza", "Bread", "Rice"));
        proteins = new ArrayList<>(Arrays.asList("Chicken", "Tofu", "Fish"));
        fats = new ArrayList<>(Arrays.asList("Cheese", "Bacon", "Avocado"));

        customer.applyDietaryRestriction(carbs, proteins, fats);
        assertTrue(carbs.contains("Pizza")); // No restriction diet includes Pizza
        assertTrue(carbs.contains("Bread")); // No restriction diet includes Bread
        assertTrue(proteins.contains("Tofu")); // No restriction diet includes Tofu
        assertTrue(fats.contains("Bacon")); // No restriction diet includes Bacon

        // Change to nut allergy strategy and re-test
        customer.setDietaryRestrictionStrategy(nutAllergyStrategy);
        carbs = new ArrayList<>(Arrays.asList("Pizza", "Bread", "Rice"));
        proteins = new ArrayList<>(Arrays.asList("Chicken", "Tofu", "Fish"));
        fats = new ArrayList<>(Arrays.asList("Cheese", "Bacon", "Avocado", "Peanuts"));

        customer.applyDietaryRestriction(carbs, proteins, fats);
        assertTrue(carbs.contains("Pizza")); // Nut allergy diet includes Pizza
        assertTrue(proteins.contains("Tofu")); // Nut allergy diet includes Tofu
        assertFalse(fats.contains("Peanuts")); // Nut allergy diet excludes Peanuts
    }
}
