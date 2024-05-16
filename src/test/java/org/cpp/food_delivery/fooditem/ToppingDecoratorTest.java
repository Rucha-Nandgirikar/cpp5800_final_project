package org.cpp.food_delivery.fooditem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ToppingDecoratorTest {
    private FoodItem pizza;
    private FoodItem pizzaWithCheese;

    @BeforeEach
    void setUp() {
        pizza = new BasicFoodItem("Pizza", 10.0);
        pizzaWithCheese = new ToppingDecorator(pizza, "Cheese", 1.5);
    }

    @Test
    void testGetDescription() {
        assertEquals("Pizza, Cheese", pizzaWithCheese.getDescription());
    }

    @Test
    void testGetCost() {
        assertEquals(11.5, pizzaWithCheese.getCost());
    }

    @Test
    void testMultipleToppings() {
        FoodItem pizzaWithCheeseAndBacon = new ToppingDecorator(pizzaWithCheese, "Bacon", 2.0);
        assertEquals("Pizza, Cheese, Bacon", pizzaWithCheeseAndBacon.getDescription());
        assertEquals(13.5, pizzaWithCheeseAndBacon.getCost());
    }
}
