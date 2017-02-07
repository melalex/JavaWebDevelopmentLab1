package com.room414.taxipark.application.model.interfaces;

import com.room414.taxipark.application.model.entities.Car;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by melalex on 2/6/17.
 */
public interface CarRepository extends CrudRepository<Integer, Car> {
    BigDecimal carsCost(int parkId);
    List<Car> findAllCarsFromPark(int parkId);
    List<Car> sortedByFuelConsumption(int parkId);
    List<Car> carsInSpeedDiapason(int parkId, float lowerBound, float upperBound);
}
