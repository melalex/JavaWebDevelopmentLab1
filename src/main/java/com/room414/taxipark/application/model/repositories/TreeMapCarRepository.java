package com.room414.taxipark.application.model.repositories;

import com.room414.taxipark.application.model.entities.Car;
import com.room414.taxipark.application.model.interfaces.CarRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Repository that provides operations specific to car repository.
 *
 * @version 1.0 09 Feb 2017
 * @author melalex
 */
public class TreeMapCarRepository extends TreeMapRepository<Integer, Car> implements CarRepository {
    /**
     *
     * @param parkId id of existed park
     * @return cost of cars in park with id == parkId
     */
    @Override
    public BigDecimal carsCost(int parkId) {
        List<Car> cars = findAll();
        return cars.stream()
                .filter(c -> c.getParkId() == parkId)
                .map(Car::getCurrency)
                .reduce(BigDecimal.ZERO ,BigDecimal::add);
    }

    /**
     *
     * @param parkId id of existed park
     * @return List of cars from park with id == parkId
     */
    @Override
    public List<Car> findAllCarsFromPark(int parkId) {
        return findAll()
                .stream()
                .filter(c -> c.getParkId() == parkId)
                .collect(Collectors.toList());
    }

    /**
     *
     * @param parkId id of existed park
     * @return List of cars from park with id == parkId sorted by fuel consumption
     */
    @Override
    public List<Car> sortedByFuelConsumption(int parkId) {
        List<Car> cars = findAll();
        return cars.stream()
                .filter(c -> c.getParkId() == parkId)
                .sorted((c1, c2) -> (int) (c1.getConsumption() - c2.getConsumption()))
                .collect(Collectors.toList());
    }

    /**
     *
     * @param parkId id of existed park
     * @return List of cars where {@code parkId == parkId && speed >= lowerBound && speed <= upperBound}
     */
    @Override
    public List<Car> carsInSpeedDiapason(int parkId, float lowerBound, float upperBound) {
        List<Car> cars = findAll();
        return cars.stream().filter(c -> {
            float speed = c.getSpeed();
            return (c.getParkId() == parkId) && (speed >= lowerBound) && (speed <= upperBound);
        }).collect(Collectors.toList());
    }
}
