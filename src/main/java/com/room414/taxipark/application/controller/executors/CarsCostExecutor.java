package com.room414.taxipark.application.controller.executors;

import com.room414.taxipark.application.controller.interfaces.QueryExecutor;
import com.room414.taxipark.application.model.interfaces.CarRepository;
import com.room414.taxipark.application.view.interfaces.View;

import java.math.BigDecimal;

/**
 * Created by melalex on 2/8/17.
 */
public class CarsCostExecutor extends QueryWithOneIdArgumentExecutor {
    private CarRepository carRepository;
    private BigDecimal result;

    CarsCostExecutor(CarRepository carRepository, View view) {
        this.carRepository = carRepository;
        this.view = view;
    }

    @Override
    public void execute() {
        result = carRepository.carsCost(id);
    }

    @Override
    public void render() {
        view.renderMessage(String.format("Cars cost in park with id %d is %f", id, result));
    }
}
