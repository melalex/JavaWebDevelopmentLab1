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
 *
 * @version 1.0 12 Feb 2017
 * @author melalex
 */
public class SimpleController implements Controller {
    private QueryAnalyzer queryAnalyzer = new SimpleQueryAnalyzer();
    private QueryExecutorFactory queryExecutorFactory;
    private View view;

    public SimpleController(DataStore dataStore, View view) {
        this.view = view;
        this.queryExecutorFactory = new SimpleQueryExecutorFactory(dataStore, view);
    }

    @Override
    public void executeQuery(String request) {
        Query query = queryAnalyzer.analyze(request);
        QueryExecutor queryExecutor = queryExecutorFactory.getQueryExecutor(query);
        queryExecutor.complete();
    }

    @Override
    public void addMessage(String message) {
        view.renderMessage(message);
    }

    @Override
    public void addLine(String line) {
        view.renderLine(line);
    }

}
