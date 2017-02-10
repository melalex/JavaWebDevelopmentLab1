package com.room414.taxipark.application.controller.executors;

import com.room414.taxipark.application.controller.infrastucture.Query;
import com.room414.taxipark.application.controller.infrastucture.QueryType;
import com.room414.taxipark.application.model.interfaces.ParkRepository;
import com.room414.taxipark.application.model.repositories.TreeMapParkRepository;
import com.room414.taxipark.application.view.implementation.SimpleView;
import com.room414.taxipark.application.view.interfaces.View;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Description goes here.
 *
 * @author Alexander Melashchenko
 * @version 1.0 10 Feb 2017
 */
class DeleteParkExecutorTest extends DeleteParkExecutor {
    private static boolean isDeleted = false;

    private static final ParkRepository testParkRepository = new TreeMapParkRepository() {
        @Override
        public void delete(Integer id) {
            isDeleted = true;
        }
    };
    private static final View testView = new SimpleView(System.out);

    DeleteParkExecutorTest() {
        super(testParkRepository, testView);
    }

    @Test
    void executeTest() {
        query = Query
                .queryBuilder()
                .setQueryType(QueryType.DELETE_PARK)
                .setArgument("ID", "1")
                .build();

        prepare();
        execute();

        assert isDeleted;
    }

}