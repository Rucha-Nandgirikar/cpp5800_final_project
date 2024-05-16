package org.cpp.food_delivery.drivers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class DriverTest {
    private Driver driver;

    @BeforeEach
    void setUp() {
        driver = new Driver("Driver A", "123 Main St", "County A", "Morning", 8, 16);
    }

    @Test
    void testGetAddress() {
        assertEquals("123 Main St", driver.getAddress());
    }

    @Test
    void testGetCounty() {
        assertEquals("County A", driver.getCounty());
    }

    @Test
    void testGetShift() {
        assertEquals("Morning", driver.getShift());
    }

    @Test
    void testGetShiftStartHour() {
        assertEquals(8, driver.getShiftStartHour());
    }

    @Test
    void testGetShiftEndHour() {
        assertEquals(16, driver.getShiftEndHour());
    }

    @Test
    void testIsAvailableDuring_ShiftStart() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 8);
        Date time = cal.getTime();
        assertTrue(driver.isAvailableDuring(time));
    }

    @Test
    void testIsAvailableDuring_ShiftEnd() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 15);
        Date time = cal.getTime();
        assertTrue(driver.isAvailableDuring(time));
    }

    @Test
    void testIsAvailableDuring_BeforeShift() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 7);
        Date time = cal.getTime();
        assertFalse(driver.isAvailableDuring(time));
    }

    @Test
    void testIsAvailableDuring_AfterShift() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 17);
        Date time = cal.getTime();
        assertFalse(driver.isAvailableDuring(time));
    }
}
