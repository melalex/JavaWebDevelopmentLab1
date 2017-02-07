package com.room414.taxipark.application.controller.implementation;

import com.room414.taxipark.application.controller.infrastucture.Query;
import com.room414.taxipark.application.controller.interfaces.QueryAnalyzer;
import com.room414.taxipark.application.controller.interfaces.QueryExecutor;

/**
 * Created by melalex on 2/5/17.
 */
public class SimpleQueryExecutor implements QueryExecutor {
    private QueryAnalyzer queryAnalyzer = new SimpleQueryAnalyzer();

    public SimpleQueryExecutor() {

    }

    @Override
    public void executeQuery(String request) {
        Query query = queryAnalyzer.analyze(request);
    }
}
