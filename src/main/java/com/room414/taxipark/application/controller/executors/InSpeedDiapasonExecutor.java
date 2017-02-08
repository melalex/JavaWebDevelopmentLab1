package com.room414.taxipark.application.controller.executors;

import com.room414.taxipark.application.controller.interfaces.QueryExecutor;
import com.room414.taxipark.application.model.entities.Car;
import com.room414.taxipark.application.model.interfaces.CarRepository;
import com.room414.taxipark.application.view.interfaces.View;

import java.util.List;

/**
 * Created by melalex on 2/8/17.
 */
public class InSpeedDiapasonExecutor extends QueryExecutor {
    private final static int ARGUMENTS_COUNT = 3;

    private final static String ID_ARGUMENT_NAME = "ID";
    private final static String MIN_ARGUMENT_NAME = "MIN";
    private final static String MAX_ARGUMENT_NAME = "MAX";

    private CarRepository carRepository;
    private List<Car> result;

    private int idArgument;
    private float minArgument;
    private float maxArgument;

    InSpeedDiapasonExecutor(CarRepository carRepository, View view) {
        this.carRepository = carRepository;
        this.view = view;
    }

    @Override
    public boolean prepare() {
        String id = query.getArgument(ID_ARGUMENT_NAME);

        if (id == null || IsParsable.isParsableToInt(id)) {
            return false;
        }

        idArgument = Integer.parseInt(id);

        String min = query.getArgument(MIN_ARGUMENT_NAME);

        if (min == null || IsParsable.isParsableToFloat(min)) {
            return false;
        }

        minArgument = Float.parseFloat(min);

        String max = query.getArgument(MAX_ARGUMENT_NAME);

        if (max == null || IsParsable.isParsableToFloat(max)) {
            return false;
        }

        minArgument = Float.parseFloat(max);

        return minArgument < maxArgument;
    }

    @Override
    public void execute() {
        result = carRepository.carsInSpeedDiapason(idArgument, minArgument, maxArgument);
    }

    @Override
    public void render() {

    }
}
