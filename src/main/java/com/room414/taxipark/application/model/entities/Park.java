package com.room414.taxipark.application.model.entities;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by melalex on 2/6/17.
 */
public class Park {

    public static class ParkBuilder {
        private String name;
        private String country;
        private String city;
        private String street;
        private String buildingNumber;

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

            park.name = this.name;
            park.country = this.country;
            park.city = this.city;
            park.street = this.street;
            park.buildingNumber = this.buildingNumber;

            return park;
        }
    }

    private String name;
    private String country;
    private String city;
    private String street;
    private String buildingNumber;
    private Map<Integer, Car> carList = new TreeMap<>();

    private Park() {

    }

    public static ParkBuilder parkBuilder() {
        return new ParkBuilder();
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
