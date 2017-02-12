package com.room414.taxipark.application.model.entities;

import java.math.BigDecimal;

/**
 *
 * @version 1.0 09 Feb 2017
 * @author melalex
 */
public class Car extends Entity<Integer> {
    public enum CarClass {A, B, C, D, E, F, J, M, S }

    public static class CarBuilder {
        private static int nextId = 0;

        private int id = -1;
        private int parkId;
        private String manufacturer;
        private String model;
        private float consumption;
        private float speed;
        private BigDecimal currency;
        private CarClass carClass;

        private CarBuilder() {

        }

        public CarBuilder setParkId(int parkId) {
            this.parkId = parkId;
            return this;
        }

        public CarBuilder setManufacturer(String manufacturer) {
            this.manufacturer = manufacturer;
            return this;
        }

        public CarBuilder setModel(String model) {
            this.model = model;
            return this;
        }

        public CarBuilder setConsumption(float consumption) {
            this.consumption = consumption;
            return this;
        }

        public CarBuilder setSpeed(float speed) {
            this.speed = speed;
            return this;
        }

        public CarBuilder setCurrency(float currency) {
            this.currency = new BigDecimal(currency);
            return this;
        }

        public CarBuilder setCarClass(CarClass carClass) {
            this.carClass = carClass;
            return this;
        }

        public Car build() {
            Car newCar = new Car();

            if (id == -1) {
                newCar.id = nextId++;
            }

            newCar.parkId = this.parkId;
            newCar.manufacturer = this.manufacturer;
            newCar.model = this.model;
            newCar.consumption = this.consumption;
            newCar.speed = this.speed;
            newCar.currency = this.currency;
            newCar.carClass = this.carClass;

            return newCar;
        }
    }

    private int id;
    private int parkId;
    private String manufacturer;
    private String model;
    private float consumption;
    private float speed;
    private BigDecimal currency;
    private CarClass carClass;

    private Car() {

    }

    public static CarBuilder carBuilder() {
        return new CarBuilder();
    }

    public CarBuilder carCopyBuilder() {
        CarBuilder carBuilder = new CarBuilder()
                .setParkId(parkId)
                .setCarClass(carClass)
                .setConsumption(consumption)
                .setCurrency(currency.floatValue())
                .setManufacturer(manufacturer)
                .setModel(model)
                .setSpeed(speed);
        carBuilder.id = id;
        return carBuilder;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public int getParkId() {
        return parkId;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public float getConsumption() {
        return consumption;
    }

    public float getSpeed() {
        return speed;
    }

    public BigDecimal getCurrency() {
        return currency;
    }

    public CarClass getCarClass() {
        return carClass;
    }
}
