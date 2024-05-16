package org.cpp.food_delivery;

import org.cpp.food_delivery.customer.Customer;
import org.cpp.food_delivery.drivers.Driver;
import org.cpp.food_delivery.fooditem.dietaryRestriction.NoRestriction;
import org.cpp.food_delivery.fooditem.dietaryRestriction.NutAllergy;
import org.cpp.food_delivery.fooditem.dietaryRestriction.Vegan;
import org.cpp.food_delivery.fooditem.dietaryRestriction.Paleo;
import org.cpp.food_delivery.orders.OrderPlacement;
import org.cpp.food_delivery.restaurant.Restaurant;
import org.cpp.food_delivery.user.UserRegistry;
import java.util.*;


public class Main {

    public static void main(String[] args) {
        UserRegistry registry = UserRegistry.getInstance();

        List<Customer> customers = new ArrayList<>();
        List<Restaurant> restaurants = new ArrayList<>();
        List<String> carbs = Arrays.asList("Pizza", "Pasta", "Bread", "Rice", "Noodles");
        List<String> proteins = Arrays.asList("Steak", "Chicken", "Tofu", "Fish", "Lentils");
        List<String> fats = Arrays.asList("Cheese", "Bacon", "Avocado", "Butter", "Olive Oil");
        List<Driver> drivers = new ArrayList<>();

        // Register restaurants with full details
        restaurants.add(new Restaurant("Restaurant A", "Address 1", "LA County", "8AM - 4PM", "Mexican", createMenu(), createToppings(), 8, 16));
        restaurants.add(new Restaurant("Restaurant B", "Address 2", "Orange County", "7 AM - 11 PM", "American", createMenu(), createToppings(), 7, 23));
        restaurants.add(new Restaurant("Restaurant C", "Address 3", "San Bernardino County", "8 AM - 9 PM", "Chinese", createMenu(), createToppings(), 8, 21));
        restaurants.add(new Restaurant("Restaurant D", "Address 4", "LA County", "9 AM - 12 AM", "Mexican", createMenu(), createToppings(), 9, 24));

        for (Restaurant restaurant : restaurants) {
            registry.registerUser(restaurant);
        }

        // Register drivers with timings that match the restaurant operating hours
        drivers.add(new Driver("Driver A", "321 Maple St", "LA County", "Morning", 8, 16));
        drivers.add(new Driver("Driver B", "654 Birch St", "Orange County", "Evening", 16, 24));
        drivers.add(new Driver("Driver C", "987 Cedar St", "San Bernardino County", "Morning", 8, 16));
        drivers.add(new Driver("Driver D", "210 Spruce St", "LA County", "Evening", 16, 24));
        drivers.add(new Driver("Driver E", "543 Ash St", "LA County", "Night", 0, 8));
        drivers.add(new Driver("Driver F", "876 Walnut St", "San Bernardino County", "Evening", 16, 24));
        drivers.add(new Driver("Driver G", "109 Poplar St", "LA County", "Morning", 8, 16));
        drivers.add(new Driver("Driver H", "432 Pine St", "Orange County", "Evening", 16, 24));

        for (Driver driver : drivers) {
            registry.registerUser(driver);
        }

        // Register customers
        customers.add(new Customer("John Doe - 1", "123 Maple St", "LA County", new Vegan()));
        customers.add(new Customer("Jane Smith - 2", "456 Birch St", "Orange County", new Paleo()));
        customers.add(new Customer("Bob Johnson - 3", "789 Cedar St", "San Bernardino County", new NutAllergy()));
        customers.add(new Customer("Alice Williams - 4", "101 Spruce St", "Orange County", new NoRestriction()));
        customers.add(new Customer("Charlie Brown - 5", "202 Ash St", "San Bernardino County", new Vegan()));
        customers.add(new Customer("Diana Prince - 6", "303 Walnut St", "San Bernardino County", new Paleo()));
        customers.add(new Customer("Clark Kent - 7", "404 Poplar St", "LA County", new NoRestriction()));
        customers.add(new Customer("Bruce Wayne - 8", "505 Pine St", "LA County", new NutAllergy()));
        customers.add(new Customer("Peter Parker - 9", "606 Elm St", "LA County", new Paleo()));
        customers.add(new Customer("Tony Stark - 10", "707 Oak St", "Orange County", new Vegan()));

        for (Customer customer : customers) {
            registry.registerUser(customer);
        }

        // Create an instance of OrderPlacement
        OrderPlacement orderPlacement = new OrderPlacement(customers, restaurants, carbs, proteins, fats, drivers);

        // Place orders
        orderPlacement.placeOrders();
    }
    private static Map<String, Double> createMenu() {
        Map<String, Double> menu = new HashMap<>();
        menu.put("Pizza", 10.0);
        menu.put("Pasta", 8.0);
        menu.put("Bread", 2.0);
        menu.put("Rice", 3.0);
        menu.put("Noodles", 5.0);
        menu.put("Steak", 15.0);
        menu.put("Chicken", 12.0);
        menu.put("Tofu", 7.0);
        menu.put("Fish", 14.0);
        menu.put("Lentils", 6.0);
        menu.put("Cheese", 4.0);
        menu.put("Bacon", 5.0);
        menu.put("Avocado", 3.0);
        menu.put("Butter", 2.0);
        menu.put("Olive Oil", 1.0);
        return menu;
    }

    private static Map<String, Double> createToppings() {
        Map<String, Double> toppings = new HashMap<>();
        toppings.put("Cheese", 1.5);
        toppings.put("Bacon", 2.0);
        toppings.put("Avocado", 1.0);
        toppings.put("Croutons", 0.5);
        toppings.put("Parmesan", 1.0);
        return toppings;
    }
}
