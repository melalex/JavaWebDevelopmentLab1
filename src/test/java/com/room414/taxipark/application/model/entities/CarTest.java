package com.room414.taxipark.application.model.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Description goes here.
 *
 * @author Alexander Melashchenko
 * @version 1.0 09 Feb 2017
 */
class CarTest {
    private static final int PARK_ID = 20;
    private static final Car.CarClass CAR_CLASS = Car.CarClass.A;
    private static final float CONSUMPTION = 100;
    private static final float CURRENCY = 1000;
    private static final String MANUFACTURER = "Qwe qwe";
    private static final String MODEL = "Asd asd";
    private static final float SPEED = 50;

    @Test
    void carCopyBuilder() {
        Car car1 = Car.carBuilder()
                .setParkId(PARK_ID)
                .setCarClass(CAR_CLASS)
                .setConsumption(CONSUMPTION)
                .setCurrency(CURRENCY)
                .setManufacturer(MANUFACTURER)
                .setModel(MODEL)
                .setSpeed(SPEED)
                .build();

        Car car2 = car1.carCopyBuilder().build();

        assert car1.getId().equals(car2.getId());
        assert car1.getParkId() == car2.getParkId();
        assert car1.getCarClass() == car2.getCarClass();
        assert car1.getConsumption() == car2.getConsumption();
        assert car1.getCurrency().floatValue() == car2.getCurrency().floatValue();
        assert car1.getManufacturer().equals(car2.getManufacturer());
        assert car1.getModel().equals(car2.getModel());
        assert car1.getSpeed() == car2.getSpeed();
    }
}