package com.room414.taxipark.application.model.repositories;

import com.room414.taxipark.application.model.entities.Car;
import com.room414.taxipark.application.model.interfaces.CarRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by melalex on 2/7/17.
 */
public class TreeMapCarRepository extends TreeMapRepository<Integer, Car> implements CarRepository {
    @Override
    public BigDecimal carsCost(int parkId) {
        List<Car> cars = findAll();
        return cars.stream()
                .filter(c -> c.getParkId() == parkId)
                .map(Car::getCurrency)
                .reduce(BigDecimal.ZERO ,BigDecimal::add);
    }

    @Override
    public List<Car> findAllCarsFromPark(int parkId) {
        return findAll()
                .stream()
                .filter(c -> c.getParkId() == parkId)
                .collect(Collectors.toList());
    }

    @Override
    public List<Car> sortedByFuelConsumption(int parkId) {
        List<Car> cars = findAll();
        return cars.stream()
                .filter(c -> c.getParkId() == parkId)
                .sorted((c1, c2) -> (int) (c1.getConsumption() - c2.getConsumption()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Car> carsInSpeedDiapason(int parkId, float lowerBound, float upperBound) {
        List<Car> cars = findAll();
        return cars.stream().filter(c -> {
            float speed = c.getSpeed();
            return (c.getParkId() == parkId) && (speed >= lowerBound) && (speed <= upperBound);
        }).collect(Collectors.toList());
    }
}
