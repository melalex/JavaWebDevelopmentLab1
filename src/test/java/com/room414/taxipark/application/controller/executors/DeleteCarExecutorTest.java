package com.room414.taxipark.application.controller.executors;

import com.room414.taxipark.application.controller.infrastucture.Query;
import com.room414.taxipark.application.controller.infrastucture.QueryType;
import com.room414.taxipark.application.model.interfaces.CarRepository;
import com.room414.taxipark.application.model.repositories.TreeMapCarRepository;
import com.room414.taxipark.application.view.implementation.SimpleView;
import com.room414.taxipark.application.view.interfaces.View;
import org.junit.jupiter.api.Test;


/**
 * Description goes here.
 *
 * @author Alexander Melashchenko
 * @version 1.0 10 Feb 2017
 */
class DeleteCarExecutorTest extends DeleteCarExecutor {
    private static boolean isDeleted = false;

    private static final CarRepository testCarRepository = new TreeMapCarRepository() {
        @Override
        public void delete(Integer id) {
            isDeleted = true;
        }
    };
    private static final View testView = new SimpleView(System.out);

    DeleteCarExecutorTest() {
        super(testCarRepository, testView);
    }

    @Test
    void executeTest() {
        query = Query
                .queryBuilder()
                .setQueryType(QueryType.DELETE_CAR)
                .setArgument("ID", "1")
                .build();

        prepare();
        execute();

        assert isDeleted;
    }

}