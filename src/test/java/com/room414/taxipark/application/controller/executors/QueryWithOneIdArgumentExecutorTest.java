package com.room414.taxipark.application.controller.executors;

import com.room414.taxipark.application.controller.infrastucture.Query;
import com.room414.taxipark.application.controller.infrastucture.QueryType;
import org.junit.jupiter.api.Test;

/**
 * Description goes here.
 *
 * @author Alexander Melashchenko
 * @version 1.0 09 Feb 2017
 */
class QueryWithOneIdArgumentExecutorTest extends QueryWithOneIdArgumentExecutor {
    @Test
    void prepareTest() {
        queryType = QueryType.CARS_COST;

        query = Query
                .queryBuilder()
                .setQueryType(QueryType.CARS_COST)
                .setArgument("ID", "1")
                .build();

        if (!prepare()) {
            throw new AssertionError();
        }

        query = Query
                .queryBuilder()
                .setQueryType(QueryType.CARS_COST)
                .setArgument("A", "1")
                .build();

        if (prepare()) {
            throw new AssertionError();
        }

        query = Query
                .queryBuilder()
                .setQueryType(QueryType.CARS_COST)
                .setArgument("ID", "i")
                .build();

        if (prepare()) {
            throw new AssertionError();
        }

        query = Query
                .queryBuilder()
                .setQueryType(QueryType.INVALID)
                .setArgument("ID", "1")
                .build();

        if (prepare()) {
            throw new AssertionError();
        }
    }
}