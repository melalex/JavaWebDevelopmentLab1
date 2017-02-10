package com.room414.taxipark.application.controller.executors;

import com.room414.taxipark.application.controller.infrastucture.Query;
import com.room414.taxipark.application.controller.infrastucture.QueryType;
import com.room414.taxipark.application.model.entities.Car;
import com.room414.taxipark.application.model.entities.Park;
import com.room414.taxipark.application.model.interfaces.CarRepository;
import com.room414.taxipark.application.model.interfaces.ParkRepository;
import com.room414.taxipark.application.model.repositories.TreeMapCarRepository;
import com.room414.taxipark.application.model.repositories.TreeMapParkRepository;
import com.room414.taxipark.application.view.implementation.SimpleView;
import com.room414.taxipark.application.view.interfaces.View;
import org.junit.jupiter.api.Test;

/**
 * Description goes here.
 *
 * @author Alexander Melashchenko
 * @version 1.0 10 Feb 2017
 */
class CreateCarExecutorTest extends CreateCarExecutor {
    private static Car lastCreated = null;

    private static final CarRepository testCarRepository = new TreeMapCarRepository() {
        @Override
        public void create(Car entity) {
            lastCreated = entity;
        }
    };
    private static final ParkRepository testParkRepository = new TreeMapParkRepository() {
        @Override
        public Park find(Integer id) {
            if (id == 1) {
                return Park.parkBuilder().build();
            } else {
                return null;
            }
        }
    };
    private static final View testView = new SimpleView(System.out);

    CreateCarExecutorTest() {
        super(testCarRepository, testParkRepository, testView);
    }

    @Test
    void prepareTest() {
        query = Query
                .queryBuilder()
                .setQueryType(QueryType.CREATE_CAR)
                .setArgument("CLASS", "A")
                .setArgument("CONSUMPTION", "10")
                .setArgument("CURRENCY", "100")
                .setArgument("MANUFACTURER", "Qwe")
                .setArgument("MODEL", "Asd")
                .setArgument("PARK", "1")
                .setArgument("SPEED", "100")
                .build();

        if (!prepare()) {
            throw new AssertionError();
        }

        query = Query
                .queryBuilder()
                .setQueryType(QueryType.CREATE_CAR)
                .setArgument("CLASS", "A")
                .setArgument("CONSUMPTION", "10")
                .setArgument("CURRENCY", "100")
                .setArgument("MANUFACTURER", "Qwe")
                .setArgument("MODEL", "Asd")
                .setArgument("PARK", "1")
                .build();

        if (prepare()) {
            throw new AssertionError();
        }

        query = Query
                .queryBuilder()
                .setQueryType(QueryType.INVALID)
                .build();

        if (prepare()) {
            throw new AssertionError();
        }

        query = Query
                .queryBuilder()
                .setQueryType(QueryType.CREATE_CAR)
                .setArgument("CLASS", "I")
                .setArgument("CONSUMPTION", "10")
                .setArgument("CURRENCY", "100")
                .setArgument("MANUFACTURER", "Qwe")
                .setArgument("MODEL", "Asd")
                .setArgument("PARK", "1")
                .setArgument("SPEED", "100")
                .build();

        if (prepare()) {
            throw new AssertionError();
        }

        query = Query
                .queryBuilder()
                .setQueryType(QueryType.CREATE_CAR)
                .setArgument("CLASS", "A")
                .setArgument("CONSUMPTION", "10A")
                .setArgument("CURRENCY", "100")
                .setArgument("MANUFACTURER", "Qwe")
                .setArgument("MODEL", "Asd")
                .setArgument("PARK", "1")
                .setArgument("SPEED", "100")
                .build();

        if (prepare()) {
            throw new AssertionError();
        }

        query = Query
                .queryBuilder()
                .setQueryType(QueryType.CREATE_CAR)
                .setArgument("CLASS", "A")
                .setArgument("CONSUMPTION", "10")
                .setArgument("CURRENCY", "100t")
                .setArgument("MANUFACTURER", "Qwe")
                .setArgument("MODEL", "Asd")
                .setArgument("PARK", "1")
                .setArgument("SPEED", "100")
                .build();

        if (prepare()) {
            throw new AssertionError();
        }

        query = Query
                .queryBuilder()
                .setQueryType(QueryType.CREATE_CAR)
                .setArgument("CLASS", "A")
                .setArgument("CONSUMPTION", "10")
                .setArgument("CURRENCY", "100")
                .setArgument("MANUFACTURER", "Qwe")
                .setArgument("MODEL", "Asd")
                .setArgument("PARK", "2")
                .setArgument("SPEED", "100")
                .build();

        if (prepare()) {
            throw new AssertionError();
        }

        query = Query
                .queryBuilder()
                .setQueryType(QueryType.CREATE_CAR)
                .setArgument("CLASS", "A")
                .setArgument("CONSUMPTION", "10")
                .setArgument("CURRENCY", "100")
                .setArgument("MANUFACTURER", "Qwe")
                .setArgument("MODEL", "Asd")
                .setArgument("PARK", "v")
                .setArgument("SPEED", "100")
                .build();

        if (prepare()) {
            throw new AssertionError();
        }

        query = Query
                .queryBuilder()
                .setQueryType(QueryType.CREATE_CAR)
                .setArgument("CLASS", "A")
                .setArgument("CONSUMPTION", "10")
                .setArgument("CURRENCY", "100")
                .setArgument("MANUFACTURER", "Qwe")
                .setArgument("MODEL", "Asd")
                .setArgument("PARK", "1")
                .setArgument("SPEED", "100y")
                .build();

        if (prepare()) {
            throw new AssertionError();
        }

        query = Query
                .queryBuilder()
                .setQueryType(QueryType.CREATE_CAR)
                .setArgument("qwe", "A")
                .setArgument("CONSUMPTION", "10")
                .setArgument("CURRENCY", "100")
                .setArgument("MANUFACTURER", "Qwe")
                .setArgument("MODEL", "Asd")
                .setArgument("PARK", "1")
                .setArgument("SPEED", "100y")
                .build();

        if (prepare()) {
            throw new AssertionError();
        }
    }
    @Test
    void executeTest() {
        query = Query
                .queryBuilder()
                .setQueryType(QueryType.CREATE_CAR)
                .setArgument("CLASS", "A")
                .setArgument("CONSUMPTION", "10")
                .setArgument("CURRENCY", "100")
                .setArgument("MANUFACTURER", "Qwe")
                .setArgument("MODEL", "Asd")
                .setArgument("PARK", "1")
                .setArgument("SPEED", "100")
                .build();

        prepare();
        execute();

        assert lastCreated != null;
    }

}