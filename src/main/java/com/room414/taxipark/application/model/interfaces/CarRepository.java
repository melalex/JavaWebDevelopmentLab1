package com.room414.taxipark.application.model.interfaces;

import com.room414.taxipark.application.model.entities.Car;
import com.room414.taxipark.application.model.repositories.TreeMapCarRepository;
import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

import java.math.BigDecimal;
import java.util.List;

/**
 * Interface of repository that provides operations specific to car repository.
 *
 * @see Car
 * @version 1.0 12 Feb 2017
 * @author melalex
 */
@JsonDeserialize(as = TreeMapCarRepository.class)
public interface CarRepository extends CrudRepository<Integer, Car> {
    /**
     *
     * @param parkId id of existed park
     * @return cost of cars in park with id == parkId
     */
    BigDecimal carsCost(int parkId);

    /**
     *
     * @param parkId id of existed park
     * @return List of cars from park with id == parkId
     */
    List<Car> findAllCarsFromPark(int parkId);

    /**
     *
     * @param parkId id of existed park
     * @return List of cars from park with id == parkId sorted by fuel consumption
     */
    List<Car> sortedByFuelConsumption(int parkId);

    /**
     *
     * @param parkId id of existed park
     * @return List of cars where {@code parkId == parkId && speed >= lowerBound && speed <= upperBound}
     */
    List<Car> carsInSpeedDiapason(int parkId, float lowerBound, float upperBound);
}
