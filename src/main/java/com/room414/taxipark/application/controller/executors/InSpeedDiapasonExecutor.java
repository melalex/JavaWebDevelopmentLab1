package com.room414.taxipark.application.controller.executors;

import com.room414.taxipark.application.controller.infrastucture.Query;
import com.room414.taxipark.application.controller.interfaces.QueryExecutor;

/**
 * Created by melalex on 2/8/17.
 */
public class InSpeedDiapasonExecutor extends QueryExecutor {
    @Override
    public boolean isValid() {
        return false;
    }

    @Override
    public void execute() {

    }

    @Override
    public void render() {

    }
}
