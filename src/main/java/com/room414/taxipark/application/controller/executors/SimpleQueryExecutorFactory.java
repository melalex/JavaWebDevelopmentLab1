package com.room414.taxipark.application.controller.executors;

import com.room414.taxipark.application.controller.infrastucture.Query;
import com.room414.taxipark.application.controller.infrastucture.QueryType;
import com.room414.taxipark.application.controller.interfaces.QueryExecutor;
import com.room414.taxipark.application.controller.interfaces.QueryExecutorFactory;
import com.room414.taxipark.application.model.interfaces.DataStore;
import com.room414.taxipark.application.view.interfaces.View;

import java.util.EnumMap;
import java.util.Map;

/**
 *
 * @version 1.0 12 Feb 2017
 * @author melalex
 */
public class SimpleQueryExecutorFactory implements QueryExecutorFactory {
    private Map<QueryType, QueryExecutor> queryExecutorMap;

    public SimpleQueryExecutorFactory(DataStore dataStore, View out) {
        queryExecutorMap = new EnumMap<>(QueryType.class);
        queryExecutorMap.put(QueryType.CARS_COST, new CarsCostExecutor(dataStore.getCarRepository(), out));
        queryExecutorMap.put(QueryType.CONSUMPTION, new SortByConsumptionExecutor(dataStore.getCarRepository(), out));
        queryExecutorMap.put(QueryType.CREATE_PARK, new CreateParkExecutor(dataStore.getParkRepository(), out));
        queryExecutorMap.put(QueryType.FIND_ALL_CARS, new FindAllCarsInParkExecutor(dataStore.getCarRepository(), out));
        queryExecutorMap.put(QueryType.FIND_ALL_PARKS, new FindAllParks(dataStore.getParkRepository(), out));
        queryExecutorMap.put(QueryType.DELETE_CAR, new DeleteCarExecutor(dataStore.getCarRepository(), out));
        queryExecutorMap.put(QueryType.DELETE_PARK, new DeleteParkExecutor(dataStore.getParkRepository(), out));
        queryExecutorMap.put(QueryType.SPEED, new InSpeedDiapasonExecutor(dataStore.getCarRepository(), out));
        queryExecutorMap.put(QueryType.GET_CAR, new FindCarExecutor(dataStore.getCarRepository(), out));
        queryExecutorMap.put(QueryType.GET_PARK, new FindParkExecutor(dataStore.getParkRepository(), out));
        queryExecutorMap.put(QueryType.CREATE_CAR, new CreateCarExecutor(
                dataStore.getCarRepository(),
                dataStore.getParkRepository(),
                out)
        );
        queryExecutorMap.put(QueryType.INVALID, new QueryExecutor() {
            @Override
            protected void renderErrors() {
                out.renderLine("Invalid command: " + query);
            }
        });
    }

    @Override
    public QueryExecutor getQueryExecutor(Query query) {
        QueryExecutor result = queryExecutorMap.get(query.getQueryType());
        result.setQuery(query);
        return result;
    }
}
