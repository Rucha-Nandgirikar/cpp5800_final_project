package org.cpp.food_delivery.orders;

import org.cpp.food_delivery.customer.Customer;
import org.cpp.food_delivery.customer.CustomerOrder;
import org.cpp.food_delivery.customer.CustomerOrderObserver;
import org.cpp.food_delivery.drivers.Driver;
import org.cpp.food_delivery.fooditem.BasicFoodItem;
import org.cpp.food_delivery.fooditem.ToppingDecorator;
import org.cpp.food_delivery.orders.Order;
import org.cpp.food_delivery.restaurant.Restaurant;

import java.util.*;

public class OrderPlacement {
    private List<Customer> customers;
    private List<Restaurant> restaurants;
    private List<String> carbs;
    private List<String> proteins;
    private List<String> fats;
    private List<Driver> drivers;
    private Random random;

    public OrderPlacement(List<Customer> customers, List<Restaurant> restaurants, List<String> carbs, List<String> proteins, List<String> fats, List<Driver> drivers) {
        this.customers = customers;
        this.restaurants = restaurants;
        this.carbs = carbs;
        this.proteins = proteins;
        this.fats = fats;
        this.drivers = drivers;
        this.random = new Random();
    }

    public void placeOrders() {
        for (Customer customer : customers) {
            Restaurant restaurant = selectRandomRestaurant();
            Date orderCreationTime = new Date();
            printHeader(customer, restaurant);

            if (!restaurant.isOpenDuring(orderCreationTime)) {
                System.out.println("Restaurant " + restaurant.getName() + " is closed. Cannot place an order.");
                printFooter();
            } else {
                List<String> availableCarbs = new ArrayList<>(carbs);
                List<String> availableProteins = new ArrayList<>(proteins);
                List<String> availableFats = new ArrayList<>(fats);
                customer.applyDietaryRestriction(availableCarbs, availableProteins, availableFats);

                CustomerOrder customerOrder = createCustomerOrder(customer, restaurant, availableCarbs, availableProteins, availableFats);

                if (customerOrder.getFoodItems().isEmpty()) {
                    System.out.println("No suitable main food items available for customer " + customer.getName() + " based on their dietary restrictions.");
                } else {
                    addRandomToppings(customerOrder, restaurant);
                    processOrder(customer, restaurant, customerOrder, orderCreationTime);
                }
            }
        }
    }

    private Restaurant selectRandomRestaurant() {
        return restaurants.get(random.nextInt(restaurants.size()));
    }

    private void printHeader(Customer customer, Restaurant restaurant) {
        System.out.println("========================================================");
        System.out.println(customer.getName() + " is attempting to place an order at " + restaurant.getName());
    }

    private void printFooter() {
        System.out.println("========================================================");
    }

    private CustomerOrder createCustomerOrder(Customer customer, Restaurant restaurant, List<String> availableCarbs, List<String> availableProteins, List<String> availableFats) {
        CustomerOrder customerOrder = new CustomerOrder(customer);
        addFoodItemToOrder(customerOrder, restaurant, availableCarbs);
        addFoodItemToOrder(customerOrder, restaurant, availableProteins);
        addFoodItemToOrder(customerOrder, restaurant, availableFats);
        return customerOrder;
    }

    private void addFoodItemToOrder(CustomerOrder customerOrder, Restaurant restaurant, List<String> availableItems) {
        restaurant.getMenu().keySet().stream()
                .filter(availableItems::contains)
                .findAny()
                .ifPresent(item -> customerOrder.addFoodItem(new BasicFoodItem(item, restaurant.getMenu().get(item))));
    }

    private void addRandomToppings(CustomerOrder customerOrder, Restaurant restaurant) {
        restaurant.getToppings().keySet().forEach(topping -> {
            if (random.nextBoolean()) {
                customerOrder.addFoodItem(new ToppingDecorator(new BasicFoodItem("Topping", 0.0), topping, restaurant.getToppings().get(topping)));
            }
        });
    }

    private void processOrder(Customer customer, Restaurant restaurant, CustomerOrder customerOrder, Date orderCreationTime) {
        double totalCost = customerOrder.calculateTotalCost();
        List<Driver> availableDrivers = findAvailableDrivers(restaurant, orderCreationTime);

        if (availableDrivers.isEmpty()) {
            System.out.println("No available driver for customer " + customer.getName() + " at this time.");
            printFooter();
        } else {
            Driver driver = availableDrivers.get(random.nextInt(availableDrivers.size()));
            Order order = new Order(restaurant, customer, customer.getDietaryRestrictionStrategy().getClass().getSimpleName(), customerOrder.getFoodItems(), driver, orderCreationTime);
            CustomerOrderObserver observer = new CustomerOrderObserver(customer.getName());
            order.addObserver(observer);
            setOrderTimes(order, orderCreationTime);
            printOrderDetails(order, customerOrder, totalCost, driver);
            order.notifyObservers();
        }
    }

    private List<Driver> findAvailableDrivers(Restaurant restaurant, Date orderCreationTime) {
        List<Driver> availableDrivers = new ArrayList<>();
        for (Driver d : drivers) {
            if (d.getCounty().equals(restaurant.getCounty()) && d.isAvailableDuring(orderCreationTime)) {
                availableDrivers.add(d);
            }
        }
        return availableDrivers;
    }

    private void setOrderTimes(Order order, Date orderCreationTime) {
        Date orderPickUpTime = new Date(orderCreationTime.getTime() + random.nextInt(3600000));
        order.setOrderPickUpTime(orderPickUpTime);
        Date orderDeliveredTime = new Date(orderPickUpTime.getTime() + random.nextInt(7200000));
        order.setOrderDeliveredTime(orderDeliveredTime);
    }

    private void printOrderDetails(Order order, CustomerOrder customerOrder, double totalCost, Driver driver) {
        System.out.println("--------------------------------------------------------");
        System.out.println("Order Details:");
        System.out.println("Restaurant: " + order.getRestaurant().getName());
        System.out.println("Customer: " + order.getCustomer().getName());
        System.out.println("Dietary Restriction: " + order.getDietaryRestriction());
        System.out.println("Food Items:");
        customerOrder.getFoodItems().forEach(item -> System.out.println(" - " + item.getDescription() + ": $" + item.getCost()));
        System.out.println("Total Cost: $" + totalCost);
        System.out.println("Driver: " + driver.getName() + " (" + driver.getShift() + ": " + driver.getShiftStartHour() + ":00 - " + driver.getShiftEndHour() + ":00)");
        System.out.println("Order Creation Time: " + order.getOrderCreationTime());
        System.out.println("Order Pick Up Time: " + order.getOrderPickUpTime());
        System.out.println("Order Delivered Time: " + order.getOrderDeliveredTime());
        System.out.println("========================================================");
    }
}
