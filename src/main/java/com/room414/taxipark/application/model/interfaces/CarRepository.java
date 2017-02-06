package com.room414.taxipark.application.model.interfaces;

import com.room414.taxipark.application.model.entities.Car;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by melalex on 2/6/17.
 */
public interface CarRepository extends CrudRepository<Long, Car> {
    BigDecimal carsCost();
    List<Car> sortedByFuelConsumption();
    List<Car> carsInSpeedDiapason(float lowerBound, float upperBound);
}
