package com.room414.taxipark.application.controller.executors;

import com.room414.taxipark.application.controller.infrastucture.QueryType;
import com.room414.taxipark.application.model.entities.Car;
import com.room414.taxipark.application.model.interfaces.CarRepository;
import com.room414.taxipark.application.view.interfaces.View;

import java.util.LinkedList;


/**
 * Execute query with type QueryType.GET_CAR
 *
 * @see QueryType#GET_CAR
 * @version 1.0 12 Feb 2017
 * @author melalex
 */
public class FindCarExecutor extends QueryWithOneIdArgumentExecutor {
    private CarRepository carRepository;
    private Car result;

    public FindCarExecutor(CarRepository carRepository, View view) {
        this.carRepository = carRepository;
        this.view = view;
        this.queryType = QueryType.GET_CAR;
    }

    @Override
    public void execute() {
        result = carRepository.find(id);
    }

    @Override
    public void render() {
        if (result != null) {
            view.renderCarsList(new LinkedList<Car>() {{
                addLast(result);
            }});
        } else {
            view.renderCarsList(new LinkedList<>());
        }
    }
}
