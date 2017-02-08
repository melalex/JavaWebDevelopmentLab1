package com.room414.taxipark.application.controller.executors;

import com.room414.taxipark.application.controller.infrastucture.Query;
import com.room414.taxipark.application.controller.infrastucture.QueryType;
import com.room414.taxipark.application.controller.interfaces.QueryExecutor;
import com.room414.taxipark.application.controller.interfaces.QueryExecutorFactory;
import com.room414.taxipark.application.model.interfaces.DataStore;
import com.room414.taxipark.application.view.interfaces.View;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by melalex on 2/8/17.
 */
public class SimpleQueryExecutorFactory implements QueryExecutorFactory {
    private Map<QueryType, QueryExecutor> queryExecutorMap;

    public SimpleQueryExecutorFactory(DataStore dataStore, View view) {
        queryExecutorMap = new HashMap<QueryType, QueryExecutor>() {{
            put(QueryType.CARS_COST, new CarsCostExecutor());
            put(QueryType.CONSUMPTION, new SortByConsumptionExecutor());
            put(QueryType.CREATE_CAR, new CreateCarExecutor(dataStore.getCarRepository(), view));
            put(QueryType.CREATE_PARK, new CreateParkExecutor(dataStore.getParkRepository(), view));
            put(QueryType.FIND_ALL_CARS, new FindAllCarsInParkExecutor(dataStore.getCarRepository(), view));
            put(QueryType.FIND_ALL_PARKS, new FindAllParks(dataStore.getParkRepository(), view));
            put(QueryType.DELETE_CAR, new DeleteCarExecutor());
            put(QueryType.DELETE_PARK, new DeleteParkExecutor());
            put(QueryType.SPEED, new InSpeedDiapasonExecutor());
            put(QueryType.GET_CAR, new FindCarExecutor(dataStore.getCarRepository(), view));
            put(QueryType.GET_PARK, new FindParkExecutor(dataStore.getParkRepository(), view));
        }};
    }

    @Override
    public QueryExecutor getQueryExecutor(QueryType type, Query query) {
        QueryExecutor result = queryExecutorMap.get(type);
        result.setQuery(query);
        return result;
    }
}
