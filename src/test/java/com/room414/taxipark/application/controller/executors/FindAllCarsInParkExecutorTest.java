package com.room414.taxipark.application.controller.executors;

import com.room414.taxipark.application.model.entities.Car;
import com.room414.taxipark.application.model.interfaces.CarRepository;
import com.room414.taxipark.application.model.repositories.TreeMapCarRepository;
import com.room414.taxipark.application.view.implementation.SimpleView;
import com.room414.taxipark.application.view.interfaces.View;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * Description goes here.
 *
 * @author Alexander Melashchenko
 * @version 1.0 10 Feb 2017
 */
class FindAllCarsInParkExecutorTest extends FindAllCarsInParkExecutor {
    private static List<Car> expectedResult = new LinkedList<Car>(){{
        Car.carBuilder().build();
        Car.carBuilder().build();
        Car.carBuilder().build();
    }};

    private static final CarRepository testCarRepository = new TreeMapCarRepository() {
        @Override
        public List<Car> findAll() {
            return expectedResult;
        }
    };
    private static final View testView = new SimpleView(System.out);

    FindAllCarsInParkExecutorTest() {
        super(testCarRepository, testView);
    }

    @Test
    void executeTest() {

    }
}