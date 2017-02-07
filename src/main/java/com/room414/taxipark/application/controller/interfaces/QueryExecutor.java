package com.room414.taxipark.application.controller.interfaces;

import com.room414.taxipark.application.controller.infrastucture.Query;
import com.room414.taxipark.application.model.entities.Car;
import com.room414.taxipark.application.model.entities.Park;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by melalex on 2/7/17.
 */
public interface QueryExecutor {
    void createCar(Query query);
    void createPark(Query query);
    List<Car> findAllCars(Query query);
    List<Park> findAllParks(Query query);
    Car findCar(Query query);
    Park findPark(Query query);
    void updateCar(Query query);
    void updatePark(Query query);
    void deleteCar(Query query);
    void deletePark(Query query);
    BigDecimal carsCost(Query query);
    List<Car> sortByConsumption(Query query);
    List<Car> inSpeedDiapason(Query query);
}
