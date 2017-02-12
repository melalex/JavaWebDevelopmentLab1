package com.room414.taxipark.application.controller.interfaces;

import com.room414.taxipark.application.controller.infrastucture.Query;

/**
 * Make lexical analyze of query.
 *
 * @version 1.0 12 Feb 2017
 * @author melalex
 */
public interface QueryAnalyzer {
    /**
     * Make lexical analyze of query.
     *
     * @see Query
     * @param query query to analyze.
     * @return Query instance that represents query param
     */
    Query analyze(String query);
}
