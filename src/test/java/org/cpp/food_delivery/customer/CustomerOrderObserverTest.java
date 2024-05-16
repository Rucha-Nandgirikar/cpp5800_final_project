package org.cpp.food_delivery.customer;

import org.cpp.food_delivery.orders.Order;
import org.cpp.food_delivery.restaurant.Restaurant;
import org.cpp.food_delivery.drivers.Driver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class CustomerOrderObserverTest {
    private CustomerOrderObserver customerOrderObserver;
    private Order order;
    private Restaurant restaurant;
    private Driver driver;

    @BeforeEach
    void setUp() {
        customerOrderObserver = new CustomerOrderObserver("John Doe");
        order = mock(Order.class);
        restaurant = mock(Restaurant.class);
        driver = mock(Driver.class);

        when(order.getRestaurant()).thenReturn(restaurant);
        when(order.getDriver()).thenReturn(driver);
        when(order.getOrderDeliveredTime()).thenReturn(new Date());
        when(restaurant.getName()).thenReturn("Test Restaurant");
        when(driver.getName()).thenReturn("Test Driver");
    }

    @Test
    void testUpdate() {
        // Capture the output
        PrintStream originalOut = System.out;
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        customerOrderObserver.update(order);

        // Restore the original System.out
        System.setOut(originalOut);

        String expectedOutput = "Customer John Doe received an update about their order: Test Restaurant has prepared . It's on the way with Test Driver. Estimated delivery time: ";
        assertTrue(outContent.toString().contains(expectedOutput));
    }
}
