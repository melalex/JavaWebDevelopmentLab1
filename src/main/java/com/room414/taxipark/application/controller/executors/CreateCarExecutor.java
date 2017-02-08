package com.room414.taxipark.application.controller.executors;

import com.room414.taxipark.application.controller.infrastucture.Query;
import com.room414.taxipark.application.controller.interfaces.QueryExecutor;
import com.room414.taxipark.application.model.entities.Car;
import com.room414.taxipark.application.model.interfaces.CarRepository;
import com.room414.taxipark.application.view.interfaces.View;

/**
 * Created by melalex on 2/8/17.
 */
public class CreateCarExecutor extends QueryExecutor {
    private CarRepository carRepository;

    CreateCarExecutor(CarRepository carRepository, View view) {
        this.carRepository = carRepository;
        this.view = view;
    }

    @Override
    public boolean isValid() {
        return false;
    }

    @Override
    public void execute() {
        Car car = Car.carBuilder()
                .setCarClass(Car.CarClass.valueOf(query.getArgument("CLASS")))
                .setConsumption(Float.parseFloat(query.getArgument("CONSUMPTION")))
                .setCurrency(Float.parseFloat(query.getArgument("CURRENCY")))
                .setManufacturer(query.getArgument("MANUFACTURER"))
                .setModel(query.getArgument("MODEL"))
                .setParkId(Integer.parseInt(query.getArgument("PARK")))
                .setSpeed(Float.parseFloat(query.getArgument("SPEED")))
                .build();

        carRepository.create(car);
    }

    @Override
    public void render() {

    }
}
