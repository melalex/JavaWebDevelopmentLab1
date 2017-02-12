package com.room414.taxipark.application.controller.executors;

import com.room414.taxipark.application.controller.infrastucture.QueryType;
import com.room414.taxipark.application.model.interfaces.CarRepository;
import com.room414.taxipark.application.view.interfaces.View;

import java.math.BigDecimal;

/**
 * Execute query with type QueryType.CARS_COST
 *
 * @see QueryType#CARS_COST
 * @version 1.0 12 Feb 2017
 * @author melalex
 */
public class CarsCostExecutor extends QueryWithOneIdArgumentExecutor {
    private CarRepository carRepository;
    protected BigDecimal result;

    CarsCostExecutor(CarRepository carRepository, View view) {
        this.carRepository = carRepository;
        this.view = view;
        this.queryType = QueryType.CARS_COST;
    }

    @Override
    public void execute() {
        result = carRepository.carsCost(id);
    }

    @Override
    public void render() {
        view.renderLine(String.format("Cars cost in park with id %d is %f", id, result));
    }
}
