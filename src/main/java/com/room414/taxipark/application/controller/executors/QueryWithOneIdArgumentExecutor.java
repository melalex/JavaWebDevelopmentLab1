package com.room414.taxipark.application.controller.executors;

import com.room414.taxipark.application.controller.infrastucture.QueryType;
import com.room414.taxipark.application.controller.interfaces.QueryExecutor;

/**
 *
 * @version 1.0 12 Feb 2017
 * @author melalex
 */
abstract class QueryWithOneIdArgumentExecutor extends QueryExecutor {
    private static final int ARGUMENTS_COUNT = 1;
    private static final String ID_ARGUMENT_NAME = "ID";

    protected int id;
    protected QueryType queryType;

    @Override
    protected boolean prepare() {
        if (query.getQueryType() != queryType) {
            return false;
        }

        if (ARGUMENTS_COUNT != query.argumentsCount()) {
            return false;
        }

        String idString = query.getArgument(ID_ARGUMENT_NAME);

        if (idString == null || !IsParsable.isParsableToInt(idString)) {
            return false;
        }

        id = Integer.parseInt(idString);

        return true;
    }
}
