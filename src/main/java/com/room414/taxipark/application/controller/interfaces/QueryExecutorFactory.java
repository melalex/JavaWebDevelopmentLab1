package com.room414.taxipark.application.controller.interfaces;

import com.room414.taxipark.application.controller.infrastucture.Query;

/**
 *
 * @see QueryExecutor
 * @see Query
 * @version 1.0 12 Feb 2017
 * @author melalex
 */
public interface QueryExecutorFactory {
    /**
     * Select executor by query
     *
     * @param query to execute
     * @return QueryExecutor that ready complete query
     * @see QueryExecutor#complete()
     */
    QueryExecutor getQueryExecutor(Query query);
}
