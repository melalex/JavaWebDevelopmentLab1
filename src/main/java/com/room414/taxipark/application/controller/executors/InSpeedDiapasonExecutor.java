package com.room414.taxipark.application.controller.executors;

import com.room414.taxipark.application.controller.infrastucture.QueryType;
import com.room414.taxipark.application.controller.interfaces.QueryExecutor;
import com.room414.taxipark.application.model.entities.Car;
import com.room414.taxipark.application.model.interfaces.CarRepository;
import com.room414.taxipark.application.view.interfaces.View;

import java.util.List;

/**
 * Execute query with type QueryType.SPEED
 *
 * @see QueryType#SPEED
 * @version 1.0 12 Feb 2017
 * @author melalex
 */
public class InSpeedDiapasonExecutor extends QueryExecutor {
    private static final int ARGUMENTS_COUNT = 3;

    private static final String ID_ARGUMENT_NAME = "ID";
    private static final String MIN_ARGUMENT_NAME = "MIN";
    private static final String MAX_ARGUMENT_NAME = "MAX";
    private static final QueryType QUERY_TYPE = QueryType.SPEED;

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
        if (QUERY_TYPE != query.getQueryType()) {
            return false;
        }

        if (ARGUMENTS_COUNT != query.argumentsCount()) {
            return false;
        }

        String id = query.getArgument(ID_ARGUMENT_NAME);

        if (id == null || !IsParsable.isParsableToInt(id)) {
            return false;
        }

        idArgument = Integer.parseInt(id);

        String min = query.getArgument(MIN_ARGUMENT_NAME);

        if (min == null || !IsParsable.isParsableToFloat(min)) {
            return false;
        }

        minArgument = Float.parseFloat(min);

        String max = query.getArgument(MAX_ARGUMENT_NAME);

        if (max == null || !IsParsable.isParsableToFloat(max)) {
            return false;
        }

        maxArgument = Float.parseFloat(max);

        return minArgument < maxArgument;
    }

    @Override
    public void execute() {
        result = carRepository.carsInSpeedDiapason(idArgument, minArgument, maxArgument);
    }

    @Override
    public void render() {
        view.renderCarsList(result);
    }
}
