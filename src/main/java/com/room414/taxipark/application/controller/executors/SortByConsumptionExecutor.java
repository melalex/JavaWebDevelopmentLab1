package com.room414.taxipark.application.controller.executors;

import com.room414.taxipark.application.controller.infrastucture.QueryType;
import com.room414.taxipark.application.model.entities.Car;
import com.room414.taxipark.application.model.interfaces.CarRepository;
import com.room414.taxipark.application.view.interfaces.View;

import java.util.List;

/**
 * Execute query with type QueryType.CONSUMPTION
 *
 * @see QueryType#CONSUMPTION
 * @version 1.0 12 Feb 2017
 * @author melalex
 */
public class SortByConsumptionExecutor extends QueryWithOneIdArgumentExecutor {
    private CarRepository carRepository;
    private List<Car> result;

    SortByConsumptionExecutor(CarRepository carRepository, View view) {
        this.carRepository = carRepository;
        this.view = view;
        this.queryType = QueryType.CONSUMPTION;
    }

    @Override
    public void execute() {
        result = carRepository.sortedByFuelConsumption(id);
    }

    @Override
    public void render() {
        view.renderCarsList(result);
    }
}
