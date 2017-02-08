package com.room414.taxipark.application.controller.interfaces;

import com.room414.taxipark.application.controller.infrastucture.Query;
import com.room414.taxipark.application.controller.infrastucture.QueryType;

/**
 * Created by melalex on 2/8/17.
 */
public interface QueryExecutorFactory {
    QueryExecutor getQueryExecutor(QueryType type, Query query);
}
