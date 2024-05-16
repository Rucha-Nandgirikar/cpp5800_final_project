package org.cpp.food_delivery.fooditem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BasicFoodItemTest {
    private BasicFoodItem basicFoodItem;

    @BeforeEach
    void setUp() {
        basicFoodItem = new BasicFoodItem("Pizza", 10.0);
    }

    @Test
    void testGetDescription() {
        assertEquals("Pizza", basicFoodItem.getDescription());
    }

    @Test
    void testGetCost() {
        assertEquals(10.0, basicFoodItem.getCost());
    }

    @Test
    void testSetDescription() {
        basicFoodItem = new BasicFoodItem("Pasta", 8.0);
        assertEquals("Pasta", basicFoodItem.getDescription());
        assertEquals(8.0, basicFoodItem.getCost());
    }

    @Test
    void testZeroCost() {
        basicFoodItem = new BasicFoodItem("Free Sample", 0.0);
        assertEquals("Free Sample", basicFoodItem.getDescription());
        assertEquals(0.0, basicFoodItem.getCost());
    }

    @Test
    void testNegativeCost() {
        basicFoodItem = new BasicFoodItem("Negative Cost Item", -5.0);
        assertEquals("Negative Cost Item", basicFoodItem.getDescription());
        assertEquals(-5.0, basicFoodItem.getCost());
    }
}
