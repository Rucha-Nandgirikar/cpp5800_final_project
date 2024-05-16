package org.cpp.food_delivery.restaurant;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class RestaurantTest {
    private Restaurant restaurant;

    @BeforeEach
    void setUp() {
        Map<String, Double> menu = new HashMap<>();
        menu.put("Pizza", 10.0);
        menu.put("Pasta", 8.0);

        Map<String, Double> toppings = new HashMap<>();
        toppings.put("Cheese", 1.5);
        toppings.put("Bacon", 2.0);

        restaurant = new Restaurant("Test Restaurant", "123 Main St", "County A", "8AM - 8PM", "Italian", menu, toppings, 8, 20);
    }

    @Test
    void testGetAddress() {
        assertEquals("123 Main St", restaurant.getAddress());
    }

    @Test
    void testGetCounty() {
        assertEquals("County A", restaurant.getCounty());
    }

    @Test
    void testGetOperatingHours() {
        assertEquals("8AM - 8PM", restaurant.getOperatingHours());
    }

    @Test
    void testGetCuisineType() {
        assertEquals("Italian", restaurant.getCuisineType());
    }

    @Test
    void testGetMenu() {
        Map<String, Double> menu = restaurant.getMenu();
        assertEquals(2, menu.size());
        assertEquals(10.0, menu.get("Pizza"));
        assertEquals(8.0, menu.get("Pasta"));
    }

    @Test
    void testGetToppings() {
        Map<String, Double> toppings = restaurant.getToppings();
        assertEquals(2, toppings.size());
        assertEquals(1.5, toppings.get("Cheese"));
        assertEquals(2.0, toppings.get("Bacon"));
    }

    @Test
    void testIsOpenDuring_Open() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 10);
        Date time = cal.getTime();
        assertTrue(restaurant.isOpenDuring(time));
    }

    @Test
    void testIsOpenDuring_Closed() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 22);
        Date time = cal.getTime();
        assertFalse(restaurant.isOpenDuring(time));
    }

    @Test
    void testGetMenuWithPrices() {
        String menuWithPrices = restaurant.getMenuWithPrices();
        assertTrue(menuWithPrices.contains("Pizza ($10.0)"));
        assertTrue(menuWithPrices.contains("Pasta ($8.0)"));
    }

    @Test
    void testGetToppingsWithPrices() {
        String toppingsWithPrices = restaurant.getToppingsWithPrices();
        assertTrue(toppingsWithPrices.contains("Cheese ($1.5)"));
        assertTrue(toppingsWithPrices.contains("Bacon ($2.0)"));
    }
}
