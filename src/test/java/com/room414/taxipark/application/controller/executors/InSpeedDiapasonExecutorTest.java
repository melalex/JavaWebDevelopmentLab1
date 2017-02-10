package com.room414.taxipark.application.controller.executors;

import com.room414.taxipark.application.controller.infrastucture.Query;
import com.room414.taxipark.application.controller.infrastucture.QueryType;
import com.room414.taxipark.application.model.entities.Car;
import com.room414.taxipark.application.model.interfaces.CarRepository;
import com.room414.taxipark.application.model.repositories.TreeMapCarRepository;
import com.room414.taxipark.application.view.implementation.SimpleView;
import com.room414.taxipark.application.view.interfaces.View;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Description goes here.
 *
 * @author Alexander Melashchenko
 * @version 1.0 10 Feb 2017
 */
class InSpeedDiapasonExecutorTest extends InSpeedDiapasonExecutor {
    private static final CarRepository testCarRepository = new TreeMapCarRepository();
    private static final View testView = new SimpleView(System.out);

    private final static String ID_ARGUMENT_NAME = "ID";
    private final static String MIN_ARGUMENT_NAME = "MIN";
    private final static String MAX_ARGUMENT_NAME = "MAX";


    InSpeedDiapasonExecutorTest() {
        super(testCarRepository, testView);
    }

    @Test
    void prepareTest() {
        query = Query
                .queryBuilder()
                .setQueryType(QueryType.SPEED)
                .setArgument("ID", "1")
                .setArgument("MIN", "3")
                .setArgument("MAX", "5")
                .build();

        if (!prepare()) {
            throw new AssertionError();
        }

        query = Query
                .queryBuilder()
                .setQueryType(QueryType.SPEED)
                .setArgument("MIN", "3")
                .setArgument("MAX", "5")
                .build();

        if (prepare()) {
            throw new AssertionError();
        }

        query = Query
                .queryBuilder()
                .setQueryType(QueryType.INVALID)
                .setArgument("ID", "1")
                .setArgument("MIN", "3")
                .setArgument("MAX", "5")
                .build();

        if (prepare()) {
            throw new AssertionError();
        }

        query = Query
                .queryBuilder()
                .setQueryType(QueryType.INVALID)
                .setArgument("ID", "1a")
                .setArgument("MIN", "3")
                .setArgument("MAX", "5")
                .build();

        if (prepare()) {
            throw new AssertionError();
        }

        query = Query
                .queryBuilder()
                .setQueryType(QueryType.INVALID)
                .setArgument("ID", "1")
                .setArgument("MIN", "3b")
                .setArgument("MAX", "5")
                .build();

        if (prepare()) {
            throw new AssertionError();
        }

        query = Query
                .queryBuilder()
                .setQueryType(QueryType.INVALID)
                .setArgument("ID", "1")
                .setArgument("MIN", "3")
                .setArgument("MAX", "5t")
                .build();

        if (prepare()) {
            throw new AssertionError();
        }

        query = Query
                .queryBuilder()
                .setQueryType(QueryType.INVALID)
                .setArgument("ID", "1")
                .setArgument("MIN", "5")
                .setArgument("MAX", "3")
                .build();

        if (prepare()) {
            throw new AssertionError();
        }
    }

}