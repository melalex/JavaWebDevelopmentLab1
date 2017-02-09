package com.room414.taxipark.application.model.repositories;

import com.room414.taxipark.application.model.entities.Car;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

/**
 * Description goes here.
 *
 * @author Alexander Melashchenko
 * @version 1.0 09 Feb 2017
 */
class TreeMapCarRepositoryTest {
    @Test
    void carsCost() {
        Car car1 = Car.carBuilder().setCurrency(1).setParkId(1).build();
        Car car2 = Car.carBuilder().setCurrency(1).setParkId(1).build();
        Car car3 = Car.carBuilder().setCurrency(1).setParkId(2).build();
        TreeMapCarRepository repository = new TreeMapCarRepository();

        repository.create(car1);
        repository.create(car2);
        repository.create(car3);

        assert repository.carsCost(1).equals(new BigDecimal(2));
    }

    @Test
    void findAllCarsFromPark() {
        Car car1 = Car.carBuilder().setParkId(1).build();
        Car car2 = Car.carBuilder().setParkId(1).build();
        Car car3 = Car.carBuilder().setParkId(2).build();
        TreeMapCarRepository repository = new TreeMapCarRepository();

        repository.create(car1);
        repository.create(car2);
        repository.create(car3);

        List<Car> result = repository.findAllCarsFromPark(1);

        assert result.size() == 2;
        assert result.contains(car1);
        assert result.contains(car2);
    }

    @Test
    void sortedByFuelConsumption() {
        Car car1 = Car.carBuilder().setConsumption(4).setParkId(1).build();
        Car car2 = Car.carBuilder().setConsumption(3).setParkId(1).build();
        Car car3 = Car.carBuilder().setConsumption(2).setParkId(1).build();
        Car car4 = Car.carBuilder().setConsumption(1).setParkId(2).build();
        TreeMapCarRepository repository = new TreeMapCarRepository();

        repository.create(car1);
        repository.create(car2);
        repository.create(car3);
        repository.create(car4);

        List<Car> result = repository.sortedByFuelConsumption(1);

        assert result.size() == 3;
        assert result.get(0) == car3;
        assert result.get(1) == car2;
        assert result.get(2) == car1;
    }

    @Test
    void carsInSpeedDiapason() {
        Car car1 = Car.carBuilder().setSpeed(4).setParkId(1).build();
        Car car2 = Car.carBuilder().setSpeed(3).setParkId(1).build();
        Car car3 = Car.carBuilder().setSpeed(2).setParkId(1).build();
        Car car4 = Car.carBuilder().setSpeed(1).setParkId(1).build();
        Car car5 = Car.carBuilder().setSpeed(3).setParkId(2).build();
        TreeMapCarRepository repository = new TreeMapCarRepository();

        repository.create(car1);
        repository.create(car2);
        repository.create(car3);
        repository.create(car4);
        repository.create(car5);

        List<Car> result = repository.carsInSpeedDiapason(1, 2, 3);

        assert result.size() == 2;
        assert result.contains(car2);
        assert result.contains(car3);
    }
}