package com.room414.taxipark.application.model.entities;

import com.room414.taxipark.application.model.interfaces.CarRepository;
import com.room414.taxipark.application.model.repositories.TreeMapCarRepository;


/**
 * Created by melalex on 2/6/17.
 */
public class Park extends Entity<Long> {

    public static class ParkBuilder {
        private static long nextId = 0;

        private String name;
        private String country;
        private String city;
        private String street;
        private String buildingNumber;

        private ParkBuilder() {

        }

        public void setName(String name) {
            this.name = name;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public void setStreet(String street) {
            this.street = street;
        }

        public void setBuildingNumber(String buildingNumber) {
            this.buildingNumber = buildingNumber;
        }

        public Park build() {
            Park park = new Park();

            park.id = nextId++;
            park.name = this.name;
            park.country = this.country;
            park.city = this.city;
            park.street = this.street;
            park.buildingNumber = this.buildingNumber;
            park.carRepository = new TreeMapCarRepository();

            return park;
        }
    }

    private long id;
    private String name;
    private String country;
    private String city;
    private String street;
    private String buildingNumber;
    private CarRepository carRepository;

    private Park() {

    }

    public static ParkBuilder parkBuilder() {
        return new ParkBuilder();
    }

    @Override
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getBuildingNumber() {
        return buildingNumber;
    }

    public CarRepository getCarRepository() {
        return carRepository;
    }
}
