package org.cpp.food_delivery.fooditem.dietaryRestriction;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DietaryRestrictionStrategyTest {
    private List<String> carbs;
    private List<String> proteins;
    private List<String> fats;

    @BeforeEach
    void setUp() {
        carbs = new ArrayList<>(Arrays.asList("Pizza", "Bread", "Rice", "Pasta"));
        proteins = new ArrayList<>(Arrays.asList("Chicken", "Tofu", "Fish", "Beef"));
        fats = new ArrayList<>(Arrays.asList("Cheese", "Bacon", "Avocado", "Peanuts"));
    }

    @Test
    void testNoRestrictionDietaryRestriction() {
        DietaryRestrictionStrategy noRestriction = new NoRestriction();
        noRestriction.applyRestriction(carbs, proteins, fats);

        assertTrue(carbs.contains("Pizza"), "No restriction diet should include Pizza");
        assertTrue(carbs.contains("Bread"), "No restriction diet should include Bread");
        assertTrue(proteins.contains("Chicken"), "No restriction diet should include Chicken");
        assertTrue(proteins.contains("Tofu"), "No restriction diet should include Tofu");
        assertTrue(fats.contains("Bacon"), "No restriction diet should include Bacon");
    }

    @Test
    void testNutAllergyDietaryRestriction() {
        DietaryRestrictionStrategy nutAllergy = new NutAllergy();
        nutAllergy.applyRestriction(carbs, proteins, fats);

        assertTrue(carbs.contains("Pizza"), "Nut allergy diet should include Pizza");
        assertTrue(proteins.contains("Tofu"), "Nut allergy diet should include Tofu");
        assertFalse(fats.contains("Peanuts"), "Nut allergy diet should exclude Peanuts");
        assertTrue(fats.contains("Bacon"), "Nut allergy diet should include Bacon");
    }
}
