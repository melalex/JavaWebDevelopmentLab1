package com.room414.taxipark.application.model.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Description goes here.
 *
 * @author Alexander Melashchenko
 * @version 1.0 09 Feb 2017
 */
class ParkBuilderTest {
    private static final String BUILDING_NUMBER = "4A";
    private static final String CITY = "Qwe";
    private static final String COUNTRY = "Asd";
    private static final String NAME = "Zxc";
    private static final String STREET = "Rty";

    @Test
    void build() {
        Park park = Park.parkBuilder()
                .setBuildingNumber(BUILDING_NUMBER)
                .setCity(CITY)
                .setCountry(COUNTRY)
                .setName(NAME)
                .setStreet(STREET)
                .build();

        assert park.getStreet().equals(STREET);
        assert park.getBuildingNumber().equals(BUILDING_NUMBER);
        assert park.getCity().equals(CITY);
        assert park.getCountry().equals(COUNTRY);
        assert park.getName().equals(NAME);
    }

}