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
    private ParkRepository parkRepository;

    CreateParkExecutor(ParkRepository parkRepository, View view) {
        this.parkRepository = parkRepository;
        this.view = view;
    }

    @Override
    public boolean isValid() {
        return false;
    }

    @Override
    public void execute() {
        Park park = Park.parkBuilder()
                .setBuildingNumber(query.getArgument("NUMBER"))
                .setCity(query.getArgument("CITY"))
                .setCountry(query.getArgument("COUNTRY"))
                .setStreet(query.getArgument("STREET"))
                .setName(query.getArgument("NAME"))
                .build();

        parkRepository.create(park);
    }

    @Override
    public void render() {

    }
}
