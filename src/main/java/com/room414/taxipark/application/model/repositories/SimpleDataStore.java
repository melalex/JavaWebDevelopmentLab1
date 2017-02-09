package com.room414.taxipark.application.model.repositories;

import com.room414.taxipark.application.model.interfaces.CarRepository;
import com.room414.taxipark.application.model.interfaces.DataStore;
import com.room414.taxipark.application.model.interfaces.ParkRepository;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.File;
import java.io.IOException;

/**
 * Description goes here.
 *
 * @version 1.0 09 Feb 2017
 * @author melalex
 */
public class SimpleDataStore implements DataStore {
    private CarRepository carRepository;
    private ParkRepository parkRepository;

    private SimpleDataStore() {

    }

    public static SimpleDataStore simpleDataStore(String filePath) throws IOException {
        File json = new File(filePath);
        SimpleDataStore result;
        if (json.exists() && !json.isDirectory()) {
            ObjectMapper objectMapper = new ObjectMapper();
            result = objectMapper.readValue(json, SimpleDataStore.class);
        } else {
            result = new SimpleDataStore();
            result.carRepository = new TreeMapCarRepository();
            result.parkRepository = new TreeMapParkRepository();
        }
        return result;
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
    public void persistence(String filePath) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(filePath), this);
    }
}
