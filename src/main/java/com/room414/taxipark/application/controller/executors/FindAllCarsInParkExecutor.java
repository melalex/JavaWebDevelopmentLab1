package com.room414.taxipark.application.controller.executors;

import com.room414.taxipark.application.controller.infrastucture.QueryType;
import com.room414.taxipark.application.model.entities.Car;
import com.room414.taxipark.application.model.interfaces.CarRepository;
import com.room414.taxipark.application.view.interfaces.View;

import java.util.List;

/**
 * Execute query with type QueryType.FIND_ALL_CARS
 *
 * @see QueryType#FIND_ALL_CARS
 * @version 1.0 12 Feb 2017
 * @author melalex
 */
public class FindAllCarsInParkExecutor extends QueryWithOneIdArgumentExecutor {
    private CarRepository carRepository;
    private List<Car> result;

    FindAllCarsInParkExecutor(CarRepository carRepository, View view) {
        this.carRepository = carRepository;
        this.view = view;
        this.queryType = QueryType.FIND_ALL_CARS;
    }

    @Override
    public void execute() {
        result = carRepository.findAllCarsFromPark(id);
    }

    @Override
    public void render() {
        view.renderCarsList(result);
    }
}
