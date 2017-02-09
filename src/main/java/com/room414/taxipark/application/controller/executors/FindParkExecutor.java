package com.room414.taxipark.application.controller.executors;

import com.room414.taxipark.application.model.entities.Park;
import com.room414.taxipark.application.model.interfaces.ParkRepository;
import com.room414.taxipark.application.view.interfaces.View;

import java.util.LinkedList;

/**
 * Created by melalex on 2/8/17.
 */
public class FindParkExecutor extends QueryWithOneIdArgumentExecutor {
    private ParkRepository parkRepository;
    private Park result;

    FindParkExecutor(ParkRepository parkRepository, View view) {
        this.parkRepository = parkRepository;
        this.view = view;
    }

    @Override
    public void execute() {
        result = parkRepository.find(id);
    }

    @Override
    public void render() {
        view.renderParksList(new LinkedList<Park>(){{addLast(result);}});
    }
}
