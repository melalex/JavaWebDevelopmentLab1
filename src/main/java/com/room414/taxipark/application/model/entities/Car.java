package com.room414.taxipark.application.model.entities;

import java.math.BigDecimal;

/**
 * Created by melalex on 2/6/17.
 */
public class Car extends Entity<Long> {
    enum CarClass {A, B, C, D, E, F, J, M, S }

    public static class CarBuilder {
        private static long nextId = 0;

        private String manufacturer;
        private String model;
        private float consumption;
        private float speed;
        private BigDecimal currency;
        private CarClass carClass;

        private CarBuilder() {

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

            newCar.id = nextId++;
            newCar.manufacturer = this.manufacturer;
            newCar.model = this.model;
            newCar.fuelConsumption = this.consumption;
            newCar.speed = this.speed;
            newCar.currency = this.currency;
            newCar.carClass = this.carClass;

            return newCar;
        }
    }

    private long id;
    private String manufacturer;
    private String model;
    private float fuelConsumption;
    private float speed;
    private BigDecimal currency;
    private CarClass carClass;

    private Car() {

    }

    public static CarBuilder carBuilder() {
        return new CarBuilder();
    }

    @Override
    public Long getId() {
        return id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public float getFuelConsumption() {
        return fuelConsumption;
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
