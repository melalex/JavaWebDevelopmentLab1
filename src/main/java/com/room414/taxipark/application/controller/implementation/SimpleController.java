package com.room414.taxipark.application.controller.implementation;

import com.room414.taxipark.application.controller.executors.*;
import com.room414.taxipark.application.controller.infrastucture.Query;
import com.room414.taxipark.application.controller.interfaces.Controller;
import com.room414.taxipark.application.controller.interfaces.QueryAnalyzer;
import com.room414.taxipark.application.controller.interfaces.QueryExecutor;
import com.room414.taxipark.application.controller.interfaces.QueryExecutorFactory;
import com.room414.taxipark.application.model.interfaces.DataStore;
import com.room414.taxipark.application.view.interfaces.View;


/**
 * Created by melalex on 2/5/17.
 */
public class SimpleController implements Controller {
    private QueryAnalyzer queryAnalyzer = new SimpleQueryAnalyzer();
    private QueryExecutorFactory queryExecutorFactory;

    public SimpleController(DataStore dataStore, View view) {
        this.queryExecutorFactory = new SimpleQueryExecutorFactory(dataStore, view);
    }

    @Override
    public void executeQuery(String request) {
        Query query = queryAnalyzer.analyze(request);
        QueryExecutor queryExecutor = queryExecutorFactory.getQueryExecutor(query.getQueryType(), query);
        queryExecutor.complete();
    }
}
