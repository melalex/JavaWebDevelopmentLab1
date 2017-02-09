package com.room414.taxipark.application.controller.executors;

import com.room414.taxipark.application.controller.interfaces.QueryExecutor;
import com.room414.taxipark.application.model.entities.Car;
import com.room414.taxipark.application.model.interfaces.CarRepository;
import com.room414.taxipark.application.model.interfaces.ParkRepository;
import com.room414.taxipark.application.view.interfaces.View;

/**
 * Created by melalex on 2/8/17.
 */
public class CreateCarExecutor extends QueryExecutor {
    private final static int ARGUMENTS_COUNT = 7;

    private final static String CLASS_ARGUMENT_NAME = "CLASS";
    private final static String CONSUMPTION_ARGUMENT_NAME = "CONSUMPTION";
    private final static String CURRENCY_ARGUMENT_NAME = "CURRENCY";
    private final static String MANUFACTURER_ARGUMENT_NAME = "MANUFACTURER";
    private final static String MODEL_ARGUMENT_NAME = "MODEL";
    private final static String PARK_ARGUMENT_NAME = "PARK";
    private final static String SPEED_ARGUMENT_NAME = "SPEED";

    private CarRepository carRepository;
    private ParkRepository parkRepository;

    private Car.CarClass carClassArgument;
    private float consumptionArgument;
    private float currencyArgument;
    private String manufacturerArgument;
    private String modelArgument;
    private int parkArgument;
    private float speedArgument;

    CreateCarExecutor(CarRepository carRepository, ParkRepository parkRepository, View view) {
        this.carRepository = carRepository;
        this.parkRepository = parkRepository;
        this.view = view;
    }

    @Override
    public boolean prepare() {
        if (ARGUMENTS_COUNT != query.argumentsCount()) {
            return false;
        }

        String carClass = query.getArgument(CLASS_ARGUMENT_NAME);

        if (carClass == null || !IsParsable.isParsableToCarType(carClass)) {
            return false;
        }

        carClassArgument = Car.CarClass.valueOf(carClass);

        String consumption = query.getArgument(CONSUMPTION_ARGUMENT_NAME);

        if (consumption == null || !IsParsable.isParsableToFloat(consumption)) {
            return false;
        }

        consumptionArgument = Float.parseFloat(consumption);

        String currency = query.getArgument(CURRENCY_ARGUMENT_NAME);

        if (currency == null || !IsParsable.isParsableToFloat(currency)) {
            return false;
        }

        currencyArgument = Float.parseFloat(currency);

        String manufacturer = query.getArgument(MANUFACTURER_ARGUMENT_NAME);

        if (manufacturer == null) {
            return false;
        }

        manufacturerArgument = manufacturer;

        String model = query.getArgument(MODEL_ARGUMENT_NAME);

        if (model == null) {
            return false;
        }

        modelArgument = model;

        String park = query.getArgument(PARK_ARGUMENT_NAME);

        if (park == null
                || IsParsable.isParsableToInt(park)
                || parkRepository.find(Integer.parseInt(park)) == null) {
            return false;
        }

        parkArgument = Integer.parseInt(park);

        String speed = query.getArgument(SPEED_ARGUMENT_NAME);

        if (speed == null || !IsParsable.isParsableToFloat(speed)) {
            return false;
        }

        speedArgument = Float.parseFloat(currency);

        return true;
    }

    @Override
    public void execute() {
        Car car = Car.carBuilder()
                .setCarClass(carClassArgument)
                .setConsumption(consumptionArgument)
                .setCurrency(currencyArgument)
                .setManufacturer(manufacturerArgument)
                .setModel(modelArgument)
                .setParkId(parkArgument)
                .setSpeed(speedArgument)
                .build();

        carRepository.create(car);
    }
}