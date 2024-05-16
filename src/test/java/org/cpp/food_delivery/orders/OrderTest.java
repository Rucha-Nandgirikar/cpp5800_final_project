package org.cpp.food_delivery.orders;

import org.cpp.food_delivery.customer.Customer;
import org.cpp.food_delivery.drivers.Driver;
import org.cpp.food_delivery.fooditem.BasicFoodItem;
import org.cpp.food_delivery.fooditem.FoodItem;
import org.cpp.food_delivery.restaurant.Restaurant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class OrderTest {
    private Order order;
    private Restaurant restaurant;
    private Customer customer;
    private Driver driver;
    private FoodItem pizza;
    private FoodItem pasta;
    private OrderObserver observer;

    @BeforeEach
    void setUp() {
        restaurant = mock(Restaurant.class);
        customer = mock(Customer.class);
        driver = mock(Driver.class);
        pizza = new BasicFoodItem("Pizza", 10.0);
        pasta = new BasicFoodItem("Pasta", 8.0);
        List<FoodItem> foodItems = Arrays.asList(pizza, pasta);
        order = new Order(restaurant, customer, "NoRestriction", foodItems, driver, new Date());
        observer = mock(OrderObserver.class);
    }

    @Test
    void testAddObserver() {
        order.addObserver(observer);
        order.notifyObservers();
        verify(observer, times(1)).update(order);
    }

    @Test
    void testNotifyObservers() {
        order.addObserver(observer);
        order.notifyObservers();
        verify(observer).update(order);
    }

    @Test
    void testGetRestaurant() {
        assertEquals(restaurant, order.getRestaurant());
    }

    @Test
    void testGetCustomer() {
        assertEquals(customer, order.getCustomer());
    }

    @Test
    void testGetDietaryRestriction() {
        assertEquals("NoRestriction", order.getDietaryRestriction());
    }

    @Test
    void testGetFoodItems() {
        List<FoodItem> foodItems = order.getFoodItems();
        assertEquals(2, foodItems.size());
        assertEquals(pizza, foodItems.get(0));
        assertEquals(pasta, foodItems.get(1));
    }

    @Test
    void testGetDriver() {
        assertEquals(driver, order.getDriver());
    }

    @Test
    void testGetOrderCreationTime() {
        assertNotNull(order.getOrderCreationTime());
    }

    @Test
    void testSetAndGetOrderPickUpTime() {
        Date pickUpTime = new Date();
        order.setOrderPickUpTime(pickUpTime);
        assertEquals(pickUpTime, order.getOrderPickUpTime());
    }

    @Test
    void testSetAndGetOrderDeliveredTime() {
        Date deliveredTime = new Date();
        order.setOrderDeliveredTime(deliveredTime);
        assertEquals(deliveredTime, order.getOrderDeliveredTime());
    }
}
