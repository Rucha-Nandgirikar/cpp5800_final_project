package org.cpp.food_delivery.customer;


import org.cpp.food_delivery.fooditem.dietaryRestriction.DietaryRestrictionStrategy;
import org.cpp.food_delivery.user.User;


import java.util.List;

public class Customer extends User {
    private String address;
    private String county;
    private DietaryRestrictionStrategy dietaryRestrictionStrategy;

    public Customer(String name, String address, String county) {
        super(name);
        this.address = address;
        this.county = county;
    }
    public Customer(String name, String address, String county, DietaryRestrictionStrategy dietaryRestrictionStrategy) {
        super(name);
        this.address = address;
        this.county = county;
        this.dietaryRestrictionStrategy = dietaryRestrictionStrategy;
    }

    public String getAddress() {
        return this.address;
    }

    public String getCounty() {
        return this.county;
    }

    public DietaryRestrictionStrategy getDietaryRestrictionStrategy() {
        return this.dietaryRestrictionStrategy;
    }

    public void setDietaryRestrictionStrategy(DietaryRestrictionStrategy strategy) {
        this.dietaryRestrictionStrategy = strategy;
    }
    public void applyDietaryRestriction(List<String> availableCarbs, List<String> availableProteins, List<String> availableFats) {
        this.dietaryRestrictionStrategy.applyRestriction(availableCarbs, availableProteins, availableFats);
    }
}
