package com.room414.taxipark.application.controller.executors;

import com.room414.taxipark.application.controller.infrastucture.Query;
import com.room414.taxipark.application.controller.interfaces.QueryExecutor;
import com.room414.taxipark.application.model.entities.Park;
import com.room414.taxipark.application.model.interfaces.ParkRepository;
import com.room414.taxipark.application.view.interfaces.View;

/**
 * Created by melalex on 2/8/17.
 */
public class CreateParkExecutor extends QueryExecutor {
    private final static int ARGUMENTS_COUNT = 5;

    private final static String NUMBER_ARGUMENT_NAME = "NUMBER";
    private final static String CITY_ARGUMENT_NAME = "CITY";
    private final static String COUNTRY_ARGUMENT_NAME = "COUNTRY";
    private final static String STREET_ARGUMENT_NAME = "STREET";
    private final static String NAME_ARGUMENT_NAME = "NAME";

    private ParkRepository parkRepository;

    private String numberArgument;
    private String cityArgument;
    private String countryArgument;
    private String streetArgument;
    private String nameArgument;

    CreateParkExecutor(ParkRepository parkRepository, View view) {
        this.parkRepository = parkRepository;
        this.view = view;
    }

    @Override
    public boolean prepare() {
        if (ARGUMENTS_COUNT != query.argumentsCount()) {
            return false;
        }

        numberArgument = query.getArgument(NUMBER_ARGUMENT_NAME);
        cityArgument = query.getArgument(CITY_ARGUMENT_NAME);
        countryArgument = query.getArgument(COUNTRY_ARGUMENT_NAME);
        streetArgument = query.getArgument(STREET_ARGUMENT_NAME);
        nameArgument = query.getArgument(NAME_ARGUMENT_NAME);

        return !(numberArgument == null
                || cityArgument == null
                || countryArgument == null
                || streetArgument == null
                || nameArgument == null);
    }

    @Override
    public void execute() {
        Park park = Park.parkBuilder()
                .setBuildingNumber(numberArgument)
                .setCity(cityArgument)
                .setCountry(countryArgument)
                .setStreet(streetArgument)
                .setName(nameArgument)
                .build();

        parkRepository.create(park);
    }
}
