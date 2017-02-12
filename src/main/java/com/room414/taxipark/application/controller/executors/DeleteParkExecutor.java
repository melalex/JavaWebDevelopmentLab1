package com.room414.taxipark.application.controller.executors;

import com.room414.taxipark.application.controller.infrastucture.QueryType;
import com.room414.taxipark.application.controller.interfaces.QueryExecutor;
import com.room414.taxipark.application.model.interfaces.ParkRepository;
import com.room414.taxipark.application.view.interfaces.View;

/**
 * Execute query with type QueryType.DELETE_PARK
 *
 * @see QueryType#DELETE_PARK
 * @version 1.0 12 Feb 2017
 * @author melalex
 */
public class DeleteParkExecutor extends QueryWithOneIdArgumentExecutor {
    private ParkRepository parkRepository;

    DeleteParkExecutor(ParkRepository parkRepository, View view) {
        this.parkRepository = parkRepository;
        this.view = view;
        this.queryType = QueryType.DELETE_PARK;
    }

    @Override
    public void execute() {
        parkRepository.delete(id);
    }
}
