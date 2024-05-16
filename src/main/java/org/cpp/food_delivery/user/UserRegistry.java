package org.cpp.food_delivery.user;

import org.cpp.food_delivery.customer.Customer;
import org.cpp.food_delivery.drivers.Driver;
import org.cpp.food_delivery.restaurant.Restaurant;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class UserRegistry {

    //implemented Singleton pattern
    private static UserRegistry instance;
    private final List<User> users = new ArrayList<>();

    private UserRegistry() {
    }

    public static UserRegistry getInstance() {
        if (instance == null) {
            instance = new UserRegistry();
        }

        return instance;
    }

    public void registerUser(User user) {
        this.users.add(user);
        switch (user) {
            case Restaurant restaurant -> {
                System.out.println(restaurant.getName() + " has been registered with CPPFoodDelivery.");
                System.out.println("Address: " + restaurant.getAddress());
                System.out.println("County: " + restaurant.getCounty());
                System.out.println("Operating Hours: " + restaurant.getOperatingHours());
                System.out.println("Cuisine Type: " + restaurant.getCuisineType());
                System.out.println("Menu: " + restaurant.getMenuWithPrices());
                System.out.println("Optional Meal Toppings: " + restaurant.getToppingsWithPrices());
            }
            case Driver driver -> {
                System.out.println(driver.getName() + " has been registered with CPPFoodDelivery.");
                System.out.println("Address: " + driver.getAddress());
                System.out.println("Shift: " + driver.getShift() + " (" + driver.getShiftStartHour() + ":00 - " + driver.getShiftEndHour() + ":00)");
                System.out.println("Operating County: " + driver.getCounty());
            }
            case Customer customer -> {
                System.out.println(customer.getName() + " has been registered with CPPFoodDelivery.");
                System.out.println("Address: " + customer.getAddress());
                System.out.println("County: " + customer.getCounty());
                // customer dietary restrictions need to be printed
            }
            case null, default -> System.out.println(user.getName() + " has been registered with CPPFoodDelivery.");
        }

    }
}
