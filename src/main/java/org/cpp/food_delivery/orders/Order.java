package org.cpp.food_delivery.orders;
import org.cpp.food_delivery.drivers.Driver;
import org.cpp.food_delivery.fooditem.FoodItem;
import org.cpp.food_delivery.restaurant.Restaurant;
import org.cpp.food_delivery.customer.Customer;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
public class Order {
// Implemented Observer Pattern
// All its dependents are notified and updated automatically.
    private Restaurant restaurant;
    private Customer customer;
    private String dietaryRestriction;
    private List<FoodItem> foodItems;
    private Driver driver;
    private Date orderCreationTime;
    private Date orderPickUpTime;
    private Date orderDeliveredTime;
    private List<OrderObserver> observers = new ArrayList();

    public Order(Restaurant restaurant, Customer customer, String dietaryRestriction, List<FoodItem> foodItems, Driver driver, Date orderCreationTime) {
        this.restaurant = restaurant;
        this.customer = customer;
        this.dietaryRestriction = dietaryRestriction;
        this.foodItems = foodItems;
        this.driver = driver;
        this.orderCreationTime = orderCreationTime;
    }

    public void addObserver(OrderObserver observer) {
        this.observers.add(observer);
    }

    public void notifyObservers() {
        Iterator var1 = this.observers.iterator();

        while(var1.hasNext()) {
            OrderObserver observer = (OrderObserver)var1.next();
            observer.update(this);
        }

    }

    public void setOrderPickUpTime(Date orderPickUpTime) {
        this.orderPickUpTime = orderPickUpTime;
    }

    public void setOrderDeliveredTime(Date orderDeliveredTime) {
        this.orderDeliveredTime = orderDeliveredTime;
    }

    public Restaurant getRestaurant() {
        return this.restaurant;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public String getDietaryRestriction() {
        return this.dietaryRestriction;
    }

    public List<FoodItem> getFoodItems() {
        return this.foodItems;
    }

    public Driver getDriver() {
        return this.driver;
    }

    public Date getOrderCreationTime() {
        return this.orderCreationTime;
    }

    public Date getOrderPickUpTime() {
        return this.orderPickUpTime;
    }

    public Date getOrderDeliveredTime() {
        return this.orderDeliveredTime;
    }
}
