package com.room414.taxipark.application.model.entities;

import org.junit.jupiter.api.Test;

/**
 * Description goes here.
 *
 * @author Alexander Melashchenko
 * @version 1.0 09 Feb 2017
 */
class ParkTest {
    private static final String BUILDING_NUMBER = "4A";
    private static final String CITY = "Qwe";
    private static final String COUNTRY = "Asd";
    private static final String NAME = "Zxc";
    private static final String STREET = "Rty";

    @Test
    void parkCopyBuilder() {
        Park park1 = Park.parkBuilder()
                .setBuildingNumber(BUILDING_NUMBER)
                .setCity(CITY)
                .setCountry(COUNTRY)
                .setName(NAME)
                .setStreet(STREET)
                .build();

        Park park2 = park1.parkCopyBuilder().build();

        assert park1.getId().equals(park2.getId());
        assert park1.getStreet().equals(park2.getStreet());
        assert park1.getBuildingNumber().equals(park2.getBuildingNumber());
        assert park1.getCity().equals(park2.getCity());
        assert park1.getCountry().equals(park2.getCountry());
        assert park1.getName().equals(park2.getName());
    }

}