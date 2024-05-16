package org.cpp.food_delivery;

import static org.mockito.Mockito.*;

import org.cpp.food_delivery.customer.Customer;
import org.cpp.food_delivery.drivers.Driver;
import org.cpp.food_delivery.orders.OrderPlacement;
import org.cpp.food_delivery.restaurant.Restaurant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class OrderPlacementTest {
    @Mock
    private Restaurant mockRestaurant;
    @Mock
    private Customer mockCustomer;
    @Mock
    private Driver mockDriver;

    private OrderPlacement orderPlacement;

    @BeforeEach
    void setUp() {
        List<Customer> customers = Arrays.asList(mockCustomer);
        List<Restaurant> restaurants = Arrays.asList(mockRestaurant);
        List<String> carbs = Arrays.asList("Rice", "Pasta");
        List<String> proteins = Arrays.asList("Chicken", "Beef");
        List<String> fats = Arrays.asList("Butter", "Olive oil");
        List<Driver> drivers = Arrays.asList(mockDriver);

        orderPlacement = new OrderPlacement(customers, restaurants, carbs, proteins, fats, drivers);
    }

    @Test
    void testPlaceOrders_RestaurantClosed() {
        when(mockRestaurant.isOpenDuring(any())).thenReturn(false);
        when(mockRestaurant.getName()).thenReturn("Gourmet Place");

        orderPlacement.placeOrders();

    }

}
