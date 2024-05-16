package org.cpp.food_delivery.customer;

import org.cpp.food_delivery.fooditem.FoodItem;
import org.cpp.food_delivery.fooditem.BasicFoodItem;
import org.cpp.food_delivery.fooditem.ToppingDecorator;
import org.cpp.food_delivery.fooditem.dietaryRestriction.NoRestriction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CustomerOrderTest {
    private Customer customer;
    private CustomerOrder customerOrder;

    @BeforeEach
    void setUp() {
        customer = new Customer("John Doe", "123 Maple St", "County A", new NoRestriction());
        customerOrder = new CustomerOrder(customer);
    }

    @Test
    void testAddFoodItem() {
        FoodItem pizza = new BasicFoodItem("Pizza", 10.0);
        customerOrder.addFoodItem(pizza);

        List<FoodItem> foodItems = customerOrder.getFoodItems();
        assertEquals(1, foodItems.size());
        assertEquals(pizza, foodItems.get(0));
    }

    @Test
    void testCalculateTotalCost_SingleItem() {
        FoodItem pizza = new BasicFoodItem("Pizza", 10.0);
        customerOrder.addFoodItem(pizza);

        double totalCost = customerOrder.calculateTotalCost();
        assertEquals(10.0, totalCost);
    }

    @Test
    void testCalculateTotalCost_MultipleItems() {
        FoodItem pizza = new BasicFoodItem("Pizza", 10.0);
        FoodItem pasta = new BasicFoodItem("Pasta", 8.0);
        customerOrder.addFoodItem(pizza);
        customerOrder.addFoodItem(pasta);

        double totalCost = customerOrder.calculateTotalCost();
        assertEquals(18.0, totalCost);
    }

    @Test
    void testCalculateTotalCost_WithToppings() {
        FoodItem pizza = new BasicFoodItem("Pizza", 10.0);
        FoodItem pizzaWithCheese = new ToppingDecorator(pizza, "Cheese", 1.5);
        customerOrder.addFoodItem(pizzaWithCheese);

        double totalCost = customerOrder.calculateTotalCost();
        assertEquals(11.5, totalCost);
    }

    @Test
    void testGetFoodItems() {
        FoodItem pizza = new BasicFoodItem("Pizza", 10.0);
        FoodItem pasta = new BasicFoodItem("Pasta", 8.0);
        customerOrder.addFoodItem(pizza);
        customerOrder.addFoodItem(pasta);

        List<FoodItem> foodItems = customerOrder.getFoodItems();
        assertEquals(2, foodItems.size());
        assertEquals(pizza, foodItems.get(0));
        assertEquals(pasta, foodItems.get(1));
    }
}
