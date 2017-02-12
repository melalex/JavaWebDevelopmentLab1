package com.room414.taxipark.application.controller.executors;

import com.room414.taxipark.application.controller.infrastucture.QueryType;
import com.room414.taxipark.application.controller.interfaces.QueryExecutor;
import com.room414.taxipark.application.model.entities.Park;
import com.room414.taxipark.application.model.interfaces.ParkRepository;
import com.room414.taxipark.application.view.interfaces.View;

import java.util.List;

/**
 * Execute query with type QueryType.FIND_ALL_PARKS
 *
 * @see QueryType#FIND_ALL_PARKS
 * @version 1.0 12 Feb 2017
 * @author melalex
 */
public class FindAllParks extends QueryExecutor {
    private final static QueryType QUERY_TYPE = QueryType.FIND_ALL_PARKS;

    private ParkRepository parkRepository;
    private List<Park> result;

    FindAllParks(ParkRepository parkRepository, View view) {
        this.parkRepository = parkRepository;
        this.view = view;
    }

    @Override
    public boolean prepare() {
        return QUERY_TYPE == query.getQueryType() && query.argumentsCount() == 0;

    }

    @Override
    public void execute() {
        result = parkRepository.findAll();
    }

    @Override
    public void render() {
        view.renderParksList(result);
    }
}
