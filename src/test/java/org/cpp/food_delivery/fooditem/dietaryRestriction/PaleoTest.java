package org.cpp.food_delivery.fooditem.dietaryRestriction;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PaleoTest {
    private List<String> carbs;
    private List<String> proteins;
    private List<String> fats;

    @BeforeEach
    void setUp() {
        carbs = new ArrayList<>(Arrays.asList("Pistachio", "Pizza", "Bread", "Rice"));
        proteins = new ArrayList<>(Arrays.asList("Chicken", "Tofu", "Fish", "Beef"));
        fats = new ArrayList<>(Arrays.asList("Cheese", "Bacon", "Sour cream", "Avocado"));
    }

    @Test
    void testApplyRestriction() {
        DietaryRestrictionStrategy paleo = new Paleo();
        paleo.applyRestriction(carbs, proteins, fats);

        // Check carbs
        assertTrue(carbs.contains("Pistachio"), "Paleo diet should include Pistachio");
        assertFalse(carbs.contains("Pizza"), "Paleo diet should exclude Pizza");
        assertFalse(carbs.contains("Bread"), "Paleo diet should exclude Bread");
        assertFalse(carbs.contains("Rice"), "Paleo diet should exclude Rice");

        // Check proteins
        assertFalse(proteins.contains("Tofu"), "Paleo diet should exclude Tofu");
        assertTrue(proteins.contains("Chicken"), "Paleo diet should include Chicken");
        assertTrue(proteins.contains("Fish"), "Paleo diet should include Fish");
        assertTrue(proteins.contains("Beef"), "Paleo diet should include Beef");

        // Check fats
        assertFalse(fats.contains("Cheese"), "Paleo diet should exclude Cheese");
        assertTrue(fats.contains("Bacon"), "Paleo diet should include Bacon");
        assertFalse(fats.contains("Sour cream"), "Paleo diet should exclude Sour cream");
        assertTrue(fats.contains("Avocado"), "Paleo diet should include Avocado");
    }
}
