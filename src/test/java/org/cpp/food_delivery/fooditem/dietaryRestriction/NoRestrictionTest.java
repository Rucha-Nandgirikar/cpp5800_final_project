package org.cpp.food_delivery.fooditem.dietaryRestriction;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class NoRestrictionTest {
    private List<String> carbs;
    private List<String> proteins;
    private List<String> fats;

    @BeforeEach
    void setUp() {
        carbs = new ArrayList<>(Arrays.asList("Pizza", "Bread", "Rice"));
        proteins = new ArrayList<>(Arrays.asList("Chicken", "Tofu", "Fish"));
        fats = new ArrayList<>(Arrays.asList("Cheese", "Bacon", "Avocado"));
    }

    @Test
    void testApplyRestriction() {
        DietaryRestrictionStrategy noRestriction = new NoRestriction();
        noRestriction.applyRestriction(carbs, proteins, fats);

        assertTrue(carbs.contains("Pizza"));
        assertTrue(carbs.contains("Bread"));
        assertTrue(carbs.contains("Rice"));
        assertTrue(proteins.contains("Chicken"));
        assertTrue(proteins.contains("Tofu"));
        assertTrue(proteins.contains("Fish"));
        assertTrue(fats.contains("Cheese"));
        assertTrue(fats.contains("Bacon"));
        assertTrue(fats.contains("Avocado"));
    }
}
