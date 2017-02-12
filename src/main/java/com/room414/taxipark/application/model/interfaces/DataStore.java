package com.room414.taxipark.application.model.interfaces;

import com.room414.taxipark.application.model.repositories.SimpleDataStore;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

import java.io.IOException;

/**
 * Provides persistence of CarRepository and ParkRepository instance.
 *
 * @see CarRepository
 * @see ParkRepository
 * @version 1.0 12 Feb 2017
 * @author melalex
 */
@JsonDeserialize(as = SimpleDataStore.class)
public interface DataStore {
    CarRepository getCarRepository();
    ParkRepository getParkRepository();

    /**
     * Writes DataStore to file.
     *
     * @param filePath Path to file where DataStore should be saved.
     * @throws IOException when I/O exception of some sort has occurred.
     */
    void persistence(String filePath) throws IOException;

    /**
     * Reconstruct DataStore from file.
     *
     * @param filePath Path to file where DataStore saved.
     * @throws IOException when I/O exception of some sort has occurred.
     */
    void reconstruct(String filePath) throws IOException;
}
