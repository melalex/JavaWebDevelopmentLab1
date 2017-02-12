package com.room414.taxipark.application.controller.executors;

import com.room414.taxipark.application.controller.infrastucture.QueryType;
import com.room414.taxipark.application.controller.interfaces.QueryExecutor;
import com.room414.taxipark.application.model.entities.Park;
import com.room414.taxipark.application.model.interfaces.ParkRepository;
import com.room414.taxipark.application.view.interfaces.View;

/**
 * Execute query with type QueryType.CREATE_PARK
 *
 * @see QueryType#CREATE_PARK
 * @version 1.0 12 Feb 2017
 * @author melalex
 */
public class CreateParkExecutor extends QueryExecutor {
    private static final int ARGUMENTS_COUNT = 5;
    private static final QueryType QUERY_TYPE = QueryType.CREATE_PARK;

    private static final String NUMBER_ARGUMENT_NAME = "NUMBER";
    private static final String CITY_ARGUMENT_NAME = "CITY";
    private static final String COUNTRY_ARGUMENT_NAME = "COUNTRY";
    private static final String STREET_ARGUMENT_NAME = "STREET";
    private static final String NAME_ARGUMENT_NAME = "NAME";

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
        if (QUERY_TYPE != query.getQueryType()) {
            return false;
        }

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
