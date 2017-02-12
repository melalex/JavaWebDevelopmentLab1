package com.room414.taxipark.application.controller.executors;

import com.room414.taxipark.application.controller.infrastucture.QueryType;
import com.room414.taxipark.application.model.entities.Park;
import com.room414.taxipark.application.model.interfaces.ParkRepository;
import com.room414.taxipark.application.view.interfaces.View;

import java.util.LinkedList;

/**
 * Execute query with type QueryType.GET_PARK
 *
 * @see QueryType#GET_PARK
 * @version 1.0 12 Feb 2017
 * @author melalex
 */
public class FindParkExecutor extends QueryWithOneIdArgumentExecutor {
    private ParkRepository parkRepository;
    private Park result;

    FindParkExecutor(ParkRepository parkRepository, View view) {
        this.parkRepository = parkRepository;
        this.view = view;
        this.queryType = QueryType.GET_PARK;
    }

    @Override
    public void execute() {
        result = parkRepository.find(id);
    }

    @Override
    public void render() {
        if (result != null) {
            view.renderParksList(new LinkedList<Park>() {{
                addLast(result);
            }});
        } else {
            view.renderParksList(new LinkedList<>());
        }
    }
}
