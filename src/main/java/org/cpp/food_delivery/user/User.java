package org.cpp.food_delivery.user;

public abstract class User {
    protected String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
