package com.room414.taxipark.application.model.repositories;

import com.room414.taxipark.application.model.interfaces.CarRepository;
import com.room414.taxipark.application.model.interfaces.DataStore;
import com.room414.taxipark.application.model.interfaces.ParkRepository;

/**
 * Created by melalex on 2/8/17.
 */
public class SimpleDataStore implements DataStore {
    @Override
    public CarRepository getCarRepository() {
        return null;
    }

    @Override
    public ParkRepository getParkRepository() {
        return null;
    }
}
