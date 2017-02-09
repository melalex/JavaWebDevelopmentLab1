package com.room414.taxipark.application.model.interfaces;

import java.io.IOException;

/**
 * Created by melalex on 2/8/17.
 */
public interface DataStore {
    CarRepository getCarRepository();
    ParkRepository getParkRepository();

    void persistence(String filePath) throws IOException;
}
