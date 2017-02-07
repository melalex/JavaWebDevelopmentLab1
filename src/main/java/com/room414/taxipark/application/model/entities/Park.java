package com.room414.taxipark.application.model.entities;

import com.room414.taxipark.application.model.interfaces.CarRepository;
import com.room414.taxipark.application.model.repositories.TreeMapCarRepository;


/**
 * Created by melalex on 2/6/17.
 */
public class Park extends Entity<Integer> {

    public static class ParkBuilder {
        private static int nextId = 0;

        private int id = -1;
        private String name;
        private String country;
        private String city;
        private String street;
        private String buildingNumber;

        private ParkBuilder() {

        }

        public ParkBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public ParkBuilder setCountry(String country) {
            this.country = country;
            return this;
        }

        public ParkBuilder setCity(String city) {
            this.city = city;
            return this;
        }

        public ParkBuilder setStreet(String street) {
            this.street = street;
            return this;
        }

        public ParkBuilder setBuildingNumber(String buildingNumber) {
            this.buildingNumber = buildingNumber;
            return this;
        }

        public Park build() {
            Park park = new Park();

            if (id == -1) {
                park.id = nextId++;
            }

            park.name = this.name;
            park.country = this.country;
            park.city = this.city;
            park.street = this.street;
            park.buildingNumber = this.buildingNumber;

            return park;
        }
    }

    private int id;
    private String name;
    private String country;
    private String city;
    private String street;
    private String buildingNumber;

    private Park() {

    }

    public static ParkBuilder parkBuilder() {
        return new ParkBuilder();
    }

    public ParkBuilder parkCopyBuilder() {
        ParkBuilder parkBuilder = new ParkBuilder()
                .setBuildingNumber(buildingNumber)
                .setCity(city)
                .setCountry(country)
                .setName(name)
                .setStreet(street);
        parkBuilder.id = id;
        return parkBuilder;
    }

    @Override
    public Integer getId() {
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
}
