package com.room414.taxipark.application.controller.implementation;

import com.room414.taxipark.application.controller.infrastucture.QueryChain;
import com.room414.taxipark.application.controller.interfaces.QueryAnalyzer;
import com.room414.taxipark.application.controller.interfaces.QueryExecutor;

/**
 * Created by melalex on 2/5/17.
 */
public class SimpleQueryExecutor implements QueryExecutor {
    private QueryAnalyzer queryAnalyzer;

    public SimpleQueryExecutor(QueryAnalyzer queryAnalyzer) {
        this.queryAnalyzer = queryAnalyzer;
    }

    @Override
    public void executeQuery(String query) {
        QueryChain queryChain = queryAnalyzer.analyze(query);
    }
}
