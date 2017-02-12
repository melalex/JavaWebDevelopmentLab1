package com.room414.taxipark.application.model.repositories;

import com.room414.taxipark.application.model.interfaces.CarRepository;
import com.room414.taxipark.application.model.interfaces.DataStore;
import com.room414.taxipark.application.model.interfaces.ParkRepository;
import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonMethod;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.File;
import java.io.IOException;

/**
 * Simple implementation of DataStore interface.
 *
 * @see DataStore
 * @version 1.0 09 Feb 2017
 * @author melalex
 */
public class SimpleDataStore implements DataStore {
    private CarRepository carRepository;
    private ParkRepository parkRepository;

    private SimpleDataStore() {

    }

    /**
     * Creates new SimpleDataStore instance from file.
     *
     * @param filePath Path to file where DataStore should be saved.
     * @return new SimpleDataStore instance.
     * @throws IOException when I/O exception of some sort has occurred.
     */
    public static SimpleDataStore simpleDataStore(String filePath) throws IOException {
        SimpleDataStore result = new SimpleDataStore();
        result.reconstruct(filePath);
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

    /**
     * @param filePath Path to file where DataStore should be saved.
     * @throws IOException when I/O exception of some sort has occurred.
     */
    @Override
    public void persistence(String filePath) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setVisibility(JsonMethod.FIELD, JsonAutoDetect.Visibility.ANY);
        mapper.writeValue(new File(filePath), this);
    }

    /**
     * Reconstruct DataStore from file.
     *
     * @param filePath Path to file where DataStore saved.
     * @throws IOException when I/O exception of some sort has occurred.
     */
    @Override
    public void reconstruct(String filePath) throws IOException {
        File json = new File(filePath);
        if (json.exists() && !json.isDirectory()) {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.setVisibility(JsonMethod.FIELD, JsonAutoDetect.Visibility.ANY);
            DataStore dataStore = objectMapper.readValue(json, SimpleDataStore.class);
            this.parkRepository = dataStore.getParkRepository();
            this.carRepository = dataStore.getCarRepository();
        } else {
            this.carRepository = new TreeMapCarRepository();
            this.parkRepository = new TreeMapParkRepository();
        }
    }
}
