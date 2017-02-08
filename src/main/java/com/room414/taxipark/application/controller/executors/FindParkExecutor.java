package com.room414.taxipark.application.controller.executors;

import com.room414.taxipark.application.controller.infrastucture.Query;
import com.room414.taxipark.application.controller.interfaces.QueryExecutor;
import com.room414.taxipark.application.model.entities.Park;
import com.room414.taxipark.application.model.interfaces.ParkRepository;
import com.room414.taxipark.application.view.interfaces.View;

/**
 * Created by melalex on 2/8/17.
 */
public class FindParkExecutor extends QueryExecutor {
    private ParkRepository parkRepository;
    private Park result;

    public FindParkExecutor(ParkRepository parkRepository, View view) {
        this.parkRepository = parkRepository;
        this.view = view;
    }

    @Override
    public boolean isValid() {
        return false;
    }

    @Override
    public void execute() {
        result = parkRepository.find(Integer.parseInt(query.getArgument("ID")));
    }

    @Override
    public void render() {

    }
}
