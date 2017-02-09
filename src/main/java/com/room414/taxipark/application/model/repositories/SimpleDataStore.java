package com.room414.taxipark.application.model.repositories;

import com.room414.taxipark.application.model.interfaces.CarRepository;
import com.room414.taxipark.application.model.interfaces.DataStore;
import com.room414.taxipark.application.model.interfaces.ParkRepository;
import com.room414.taxipark.application.view.implementation.SimpleView;

/**
 * Created by melalex on 2/8/17.
 */
public class SimpleDataStore implements DataStore {
    private CarRepository carRepository;
    private ParkRepository parkRepository;

    private SimpleDataStore() {

    }

    public static SimpleDataStore simpleDataStore(String filePath) {
        return new SimpleDataStore();
    }

    @Override
    public CarRepository getCarRepository() {
        return carRepository;
    }

    @Override
    public ParkRepository getParkRepository() {
        return parkRepository;
    }

    @Override
    public void persistence(String filePath) {

    }
}
