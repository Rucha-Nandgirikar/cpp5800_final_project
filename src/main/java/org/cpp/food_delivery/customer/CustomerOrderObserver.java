package org.cpp.food_delivery.customer;

import org.cpp.food_delivery.orders.Order;
import org.cpp.food_delivery.orders.OrderObserver;

public class CustomerOrderObserver implements OrderObserver {
    // Implemented Observer Pattern
    // All its dependents are notified and updated automatically.
    private String name;

    public CustomerOrderObserver(String name) {
        this.name = name;
    }

    public void update(Order order) {
        System.out.println("Customer " + this.name + " received an update about their order: " + order.getRestaurant().getName() + " has prepared . It's on the way with " + order.getDriver().getName() + ". Estimated delivery time: " + order.getOrderDeliveredTime());
    }
}
