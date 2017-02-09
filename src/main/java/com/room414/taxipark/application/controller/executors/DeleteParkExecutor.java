package com.room414.taxipark.application.controller.executors;

import com.room414.taxipark.application.controller.interfaces.QueryExecutor;
import com.room414.taxipark.application.model.interfaces.ParkRepository;
import com.room414.taxipark.application.view.interfaces.View;

/**
 * Created by melalex on 2/8/17.
 */
public class DeleteParkExecutor extends QueryWithOneIdArgumentExecutor {
    private ParkRepository parkRepository;

    DeleteParkExecutor(ParkRepository parkRepository, View view) {
        this.parkRepository = parkRepository;
        this.view = view;
    }

    @Override
    public void execute() {
        parkRepository.delete(id);
    }
}
