package com.room414.taxipark.application.model.repositories;

import com.room414.taxipark.application.model.entities.Car;
import com.room414.taxipark.application.model.interfaces.CarRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by melalex on 2/7/17.
 */
public class TreeMapCarRepository extends TreeMapRepository<Long, Car> implements CarRepository {
    @Override
    public BigDecimal carsCost() {
        List<Car> cars = findAll();
        return cars.stream().map(Car::getCurrency).reduce(BigDecimal.ZERO ,BigDecimal::add);
    }

    @Override
    public List<Car> sortedByFuelConsumption() {
        List<Car> cars = findAll();
        return cars.stream()
                .sorted((c1, c2) -> (int) (c1.getFuelConsumption() - c2.getFuelConsumption()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Car> carsInSpeedDiapason(float lowerBound, float upperBound) {
        List<Car> cars = findAll();
        return cars.stream().filter(c -> {
            float speed = c.getSpeed();
            return speed >= lowerBound && speed <= upperBound;
        }).collect(Collectors.toList());
    }
}
