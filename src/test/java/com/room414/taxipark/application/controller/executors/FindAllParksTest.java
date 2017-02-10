package com.room414.taxipark.application.controller.executors;

import com.room414.taxipark.application.controller.infrastucture.Query;
import com.room414.taxipark.application.controller.infrastucture.QueryType;
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
class FindAllParksTest extends FindAllParks {
    private static final ParkRepository testParkRepository = new TreeMapParkRepository();
    private static final View testView = new SimpleView(System.out);

    FindAllParksTest() {
        super(testParkRepository, testView);
    }

    @Test
    void prepareTest() {
        query = Query
                .queryBuilder()
                .setQueryType(QueryType.FIND_ALL_PARKS)
                .build();

        if (!prepare()) {
            throw new AssertionError();
        }

        query = Query
                .queryBuilder()
                .setQueryType(QueryType.FIND_ALL_CARS)
                .build();

        if (prepare()) {
            throw new AssertionError();
        }

        query = Query
                .queryBuilder()
                .setQueryType(QueryType.FIND_ALL_PARKS)
                .setArgument("qwe", "qwe")
                .build();

        if (prepare()) {
            throw new AssertionError();
        }
    }

}