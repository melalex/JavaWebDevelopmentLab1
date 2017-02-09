package com.room414.taxipark.application.controller.executors;

import com.room414.taxipark.application.controller.infrastucture.QueryType;
import com.room414.taxipark.application.controller.interfaces.QueryExecutor;
import com.room414.taxipark.application.model.interfaces.CarRepository;
import com.room414.taxipark.application.view.interfaces.View;

/**
 * Created by melalex on 2/8/17.
 */
public class DeleteCarExecutor extends QueryWithOneIdArgumentExecutor {
    private CarRepository carRepository;

    DeleteCarExecutor(CarRepository carRepository, View view) {
        this.carRepository = carRepository;
        this.view = view;
        this.queryType = QueryType.DELETE_CAR;
    }

    @Override
    public void execute() {
        carRepository.delete(id);
    }
}
