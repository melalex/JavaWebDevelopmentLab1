package com.room414.taxipark.application.model.entities;

import org.junit.jupiter.api.Test;

/**
 * Description goes here.
 *
 * @author Alexander Melashchenko
 * @version 1.0 09 Feb 2017
 */
class CarBuilderTest {
    private static final int PARK_ID = 20;
    private static final Car.CarClass CAR_CLASS = Car.CarClass.A;
    private static final float CONSUMPTION = 100;
    private static final float CURRENCY = 1000;
    private static final String MANUFACTURER = "Qwe qwe";
    private static final String MODEL = "Asd asd";
    private static final float SPEED = 50;

    @Test
    void build() {
        Car car = Car.carBuilder()
                .setParkId(PARK_ID)
                .setCarClass(CAR_CLASS)
                .setConsumption(CONSUMPTION)
                .setCurrency(CURRENCY)
                .setManufacturer(MANUFACTURER)
                .setModel(MODEL)
                .setSpeed(SPEED)
                .build();

        assert car.getParkId() == PARK_ID;
        assert car.getCarClass() == CAR_CLASS;
        assert car.getConsumption() == CONSUMPTION;
        assert car.getCurrency().floatValue() == CURRENCY;
        assert car.getManufacturer().equals(MANUFACTURER);
        assert car.getModel().equals(MODEL);
        assert car.getSpeed() == SPEED;
    }
}