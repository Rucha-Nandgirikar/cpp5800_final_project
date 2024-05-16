package org.cpp.food_delivery.drivers;

import org.cpp.food_delivery.user.User;

import java.util.Calendar;
import java.util.Date;

public class Driver extends User {
    private String address;
    private String county;
    private String shift;
    private int shiftStartHour;
    private int shiftEndHour;

    public Driver(String name, String address, String county, String shift, int shiftStartHour, int shiftEndHour) {
        super(name);
        this.address = address;
        this.county = county;
        this.shift = shift;
        this.shiftStartHour = shiftStartHour;
        this.shiftEndHour = shiftEndHour;
    }

    public String getAddress() {
        return this.address;
    }

    public String getCounty() {
        return this.county;
    }

    public String getShift() {
        return this.shift;
    }

    public int getShiftStartHour() {
        return this.shiftStartHour;
    }

    public int getShiftEndHour() {
        return this.shiftEndHour;
    }

    public boolean isAvailableDuring(Date time) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(time);
        int hour = cal.get(11);
        return hour >= this.shiftStartHour && hour < this.shiftEndHour;
    }
}
