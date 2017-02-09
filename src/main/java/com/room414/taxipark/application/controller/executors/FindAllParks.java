package com.room414.taxipark.application.controller.executors;

import com.room414.taxipark.application.controller.infrastucture.Query;
import com.room414.taxipark.application.controller.interfaces.QueryExecutor;
import com.room414.taxipark.application.controller.interfaces.QueryExecutorFactory;
import com.room414.taxipark.application.model.entities.Park;
import com.room414.taxipark.application.model.interfaces.ParkRepository;
import com.room414.taxipark.application.view.interfaces.View;

import java.util.List;

/**
 * Created by melalex on 2/8/17.
 */
public class FindAllParks extends QueryExecutor {
    private ParkRepository parkRepository;
    private List<Park> result;

    FindAllParks(ParkRepository parkRepository, View view) {
        this.parkRepository = parkRepository;
        this.view = view;
    }

    @Override
    public boolean prepare() {
        return query.argumentsCount() == 0;
    }

    @Override
    public void execute() {
        result = parkRepository.findAll();
    }

    @Override
    public void render() {
        view.renderParksList(result);
    }
}
