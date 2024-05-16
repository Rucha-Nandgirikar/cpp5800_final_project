package org.cpp.food_delivery.restaurant;

import org.cpp.food_delivery.user.User;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;

public class Restaurant extends User {
    private String address;
    private String county;
    private String operatingHours;
    private String cuisineType;
    private Map<String, Double> menu;
    private Map<String, Double> toppings;
    private int openingHour;
    private int closingHour;

    public Restaurant(String name, String address, String county, String operatingHours, String cuisineType, Map<String, Double> menu, Map<String, Double> toppings, int openingHour, int closingHour) {
        super(name);
        this.address = address;
        this.county = county;
        this.operatingHours = operatingHours;
        this.cuisineType = cuisineType;
        this.menu = menu;
        this.toppings = toppings;
        this.openingHour = openingHour;
        this.closingHour = closingHour;
    }

    public String getAddress() {
        return this.address;
    }

    public String getCounty() {
        return this.county;
    }

    public String getOperatingHours() {
        return this.operatingHours;
    }

    public String getCuisineType() {
        return this.cuisineType;
    }

    public Map<String, Double> getMenu() {
        return this.menu;
    }

    public Map<String, Double> getToppings() {
        return this.toppings;
    }

    public boolean isOpenDuring(Date time) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(time);
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        return hour >= this.openingHour && hour < this.closingHour;
    }

    public String getMenuWithPrices() {
        StringBuilder menuWithPrices = new StringBuilder();
        for (Map.Entry<String, Double> entry : this.menu.entrySet()) {
            menuWithPrices.append(entry.getKey()).append(" ($").append(entry.getValue()).append("), ");
        }
        return menuWithPrices.toString();
    }

    public String getToppingsWithPrices() {
        StringBuilder toppingsWithPrices = new StringBuilder();
        for (Map.Entry<String, Double> entry : this.toppings.entrySet()) {
            toppingsWithPrices.append(entry.getKey()).append(" ($").append(entry.getValue()).append("), ");
        }
        return toppingsWithPrices.toString();
    }
}
