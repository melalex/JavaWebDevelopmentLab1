package com.room414.taxipark.application.controller.executors;

import com.room414.taxipark.application.controller.infrastucture.Query;
import com.room414.taxipark.application.controller.infrastucture.QueryType;
import com.room414.taxipark.application.model.entities.Park;
import com.room414.taxipark.application.model.interfaces.ParkRepository;
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
class CreateParkExecutorTest extends CreateParkExecutor {
    private static Park lastParkCreated = null;

    private static final ParkRepository testParkRepository = new TreeMapParkRepository() {
        @Override
        public void create(Park entity) {
            lastParkCreated = entity;
        }
    };
    private static final View testView = new SimpleView(System.out);


    CreateParkExecutorTest() {
        super(testParkRepository, testView);
    }

    @Test
    void prepareTest() {
        query = Query
                .queryBuilder()
                .setQueryType(QueryType.CREATE_PARK)
                .setArgument("NUMBER", "qwe")
                .setArgument("CITY", "qwe")
                .setArgument("COUNTRY", "qwe")
                .setArgument("STREET", "qwe")
                .setArgument("NAME", "qwe")
                .build();

        if (!prepare()) {
            throw new AssertionError();
        }

        query = Query
                .queryBuilder()
                .setQueryType(QueryType.CREATE_PARK)
                .setArgument("CITY", "qwe")
                .setArgument("COUNTRY", "qwe")
                .setArgument("STREET", "qwe")
                .setArgument("NAME", "qwe")
                .build();

        if (prepare()) {
            throw new AssertionError();
        }

        query = Query
                .queryBuilder()
                .setQueryType(QueryType.INVALID)
                .setArgument("NUMBER", "qwe")
                .setArgument("CITY", "qwe")
                .setArgument("COUNTRY", "qwe")
                .setArgument("STREET", "qwe")
                .setArgument("NAME", "qwe")
                .build();

        if (prepare()) {
            throw new AssertionError();
        }

        query = Query
                .queryBuilder()
                .setQueryType(QueryType.CREATE_PARK)
                .setArgument("qwe", "qwe")
                .setArgument("CITY", "qwe")
                .setArgument("COUNTRY", "qwe")
                .setArgument("STREET", "qwe")
                .setArgument("NAME", "qwe")
                .build();

        if (prepare()) {
            throw new AssertionError();
        }
    }

    @Test
    void executeTest() {
        query = Query
                .queryBuilder()
                .setQueryType(QueryType.CREATE_PARK)
                .setArgument("NUMBER", "qwe")
                .setArgument("CITY", "qwe")
                .setArgument("COUNTRY", "qwe")
                .setArgument("STREET", "qwe")
                .setArgument("NAME", "qwe")
                .build();

        prepare();
        execute();

        assert lastParkCreated != null;
    }

}