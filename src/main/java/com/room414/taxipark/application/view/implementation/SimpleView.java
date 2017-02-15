package com.room414.taxipark.application.view.implementation;

import com.room414.taxipark.application.model.entities.Car;
import com.room414.taxipark.application.model.entities.Park;
import com.room414.taxipark.application.view.interfaces.View;

import java.io.PrintStream;
import java.util.List;

/**
 *
 * @version 1.0 12 Feb 2017
 * @author melalex
 */
public class SimpleView implements View {
    private static final String ID_COLUMN_NAME = "Id";
    private static final String PARK_ID_COLUMN_NAME = "Park id";
    private static final String MANUFACTURER_COLUMN_NAME = "Manufacturer";
    private static final String MODEL_COLUMN_NAME = "Model";
    private static final String CONSUMPTION_COLUMN_NAME = "Consumption";
    private static final String SPEED_COLUMN_NAME = "Speed";
    private static final String CURRENCY_COLUMN_NAME = "Currency";
    private static final String CAR_CLASS_COLUMN_NAME = "Car class";

    private static final String NAME_COLUMN_NAME = "Name";
    private static final String COUNTRY_COLUMN_NAME = "Country";
    private static final String CITY_COLUMN_NAME = "City";
    private static final String STREET_COLUMN_NAME = "Street";
    private static final String BUILDING_NUMBER_COLUMN_NAME = "Building number";

    private static final int CARS_DEFAULT_LINE_LENGTH = 9;
    private static final int PARKS_DEFAULT_LINE_LENGTH = 7;

    private PrintStream out;

    public SimpleView(PrintStream out) {
        this.out = out;
    }

    private String stringMerger(Object... objects) {
        StringBuilder stringBuilder = new StringBuilder();

        for (Object object : objects) {
            stringBuilder.append(object);
        }

        return stringBuilder.toString();
    }

    private String getLine(int length) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < length; i++) {
            stringBuilder.append("-");
        }

        return stringBuilder.toString();
    }

    @Override
    public void renderCarsList(List<Car> carList) {
        int idMaxLength = ID_COLUMN_NAME.length();
        int parkIdMaxLength = PARK_ID_COLUMN_NAME.length();
        int manufacturerMaxLength = MANUFACTURER_COLUMN_NAME.length();
        int modelMaxLength = MODEL_COLUMN_NAME.length();
        int consumptionMaxLength = CONSUMPTION_COLUMN_NAME.length();
        int speedMaxLength = SPEED_COLUMN_NAME.length();
        int currencyMaxLength = CURRENCY_COLUMN_NAME.length();
        int carClassMaxLength = CAR_CLASS_COLUMN_NAME.length();
        int buff;

        for (Car car : carList) {
            buff = String.valueOf(car.getId()).length();
            if (buff > idMaxLength) {
                idMaxLength = buff;
            }

            buff = String.valueOf(car.getParkId()).length();
            if (buff > parkIdMaxLength) {
                parkIdMaxLength = buff;
            }

            buff = car.getManufacturer().length();
            if (buff > manufacturerMaxLength) {
                manufacturerMaxLength = buff;
            }

            buff = car.getModel().length();
            if (buff > modelMaxLength) {
                modelMaxLength = buff;
            }

            buff = String.valueOf(car.getConsumption()).length();
            if (buff > consumptionMaxLength) {
                consumptionMaxLength = buff;
            }

            buff = String.valueOf(car.getSpeed()).length();
            if (buff > speedMaxLength) {
                speedMaxLength = buff;
            }

            buff = String.valueOf(car.getCurrency()).length();
            if (buff > currencyMaxLength) {
                currencyMaxLength = buff;
            }

            buff = String.valueOf(car.getCarClass()).length();
            if (buff > carClassMaxLength) {
                carClassMaxLength = buff;
            }
        }

        idMaxLength++;
        parkIdMaxLength++;
        manufacturerMaxLength++;
        modelMaxLength++;
        consumptionMaxLength++;
        speedMaxLength++;
        currencyMaxLength++;
        carClassMaxLength++;

        String formatString = stringMerger(
                "|%", idMaxLength,"s|%",
                parkIdMaxLength, "s|%",
                manufacturerMaxLength,"s|%",
                modelMaxLength, "s|%",
                consumptionMaxLength, "s|%",
                speedMaxLength, "s|%",
                currencyMaxLength, "s|%",
                carClassMaxLength, "s|"
        );

        int lineLength = CARS_DEFAULT_LINE_LENGTH + idMaxLength + parkIdMaxLength + manufacturerMaxLength +
                modelMaxLength + consumptionMaxLength + speedMaxLength + currencyMaxLength + carClassMaxLength;

        String line = getLine(lineLength);

        out.println(line);
        out.println(String.format(
                formatString,
                ID_COLUMN_NAME,
                PARK_ID_COLUMN_NAME,
                MANUFACTURER_COLUMN_NAME,
                MODEL_COLUMN_NAME,
                CONSUMPTION_COLUMN_NAME,
                SPEED_COLUMN_NAME,
                CURRENCY_COLUMN_NAME,
                CAR_CLASS_COLUMN_NAME
        ));
        out.println(line);

        for (Car car : carList) {
            out.println(String.format(
                    formatString,
                    car.getId(),
                    car.getParkId(),
                    car.getManufacturer(),
                    car.getModel(),
                    car.getConsumption(),
                    car.getSpeed(),
                    car.getCurrency(),
                    car.getCarClass()
            ));
            out.println(line);
        }
    }

    @Override
    public void renderParksList(List<Park> parkList) {
        int idMaxLength = ID_COLUMN_NAME.length();
        int nameMaxLength = NAME_COLUMN_NAME.length();
        int countryMaxLength = COUNTRY_COLUMN_NAME.length();
        int cityMaxLength = CITY_COLUMN_NAME.length();
        int streetMaxLength = STREET_COLUMN_NAME.length();
        int buildingNumberMaxLength = BUILDING_NUMBER_COLUMN_NAME.length();
        int buff;

        for (Park park : parkList) {
            buff = String.valueOf(park.getId()).length();
            if (buff > idMaxLength) {
                idMaxLength = buff;
            }

            buff = park.getName().length();
            if (buff > nameMaxLength) {
                nameMaxLength = buff;
            }

            buff = park.getCountry().length();
            if (buff > countryMaxLength) {
                countryMaxLength = buff;
            }

            buff = park.getCity().length();
            if (buff > cityMaxLength) {
                cityMaxLength = buff;
            }

            buff = park.getStreet().length();
            if (buff > streetMaxLength) {
                streetMaxLength = buff;
            }

            buff = park.getBuildingNumber().length();
            if (buff > buildingNumberMaxLength) {
                buildingNumberMaxLength = buff;
            }
        }

        idMaxLength++;
        nameMaxLength++;
        countryMaxLength++;
        cityMaxLength++;
        streetMaxLength++;
        buildingNumberMaxLength++;

        String formatString = stringMerger(
                "|%", idMaxLength,"s|%",
                nameMaxLength, "s|%",
                countryMaxLength,"s|%",
                cityMaxLength, "s|%",
                streetMaxLength, "s|%",
                buildingNumberMaxLength, "s|"
        );

        int lineLength = PARKS_DEFAULT_LINE_LENGTH + idMaxLength + nameMaxLength + countryMaxLength +
                cityMaxLength + streetMaxLength + buildingNumberMaxLength;

        String line = getLine(lineLength);

        out.println(line);
        out.println(String.format(
                formatString,
                ID_COLUMN_NAME,
                NAME_COLUMN_NAME,
                COUNTRY_COLUMN_NAME,
                CITY_COLUMN_NAME,
                STREET_COLUMN_NAME,
                BUILDING_NUMBER_COLUMN_NAME
        ));
        out.println(line);

        for (Park park : parkList) {
            out.println(String.format(
                    formatString,
                    park.getId(),
                    park.getName(),
                    park.getCountry(),
                    park.getCity(),
                    park.getStreet(),
                    park.getBuildingNumber()
            ));
            out.println(line);
        }
    }

    @Override
    public void renderMessage(String message) {
        out.print(message);
    }

    @Override
    public void renderLine(String line) {
        out.println(line);
    }
}
