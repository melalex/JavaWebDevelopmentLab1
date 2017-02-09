package com.room414.taxipark.application.controller.executors;

import com.room414.taxipark.application.model.repositories.TreeMapCarRepository;
import com.room414.taxipark.application.view.implementation.SimpleView;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

/**
 * Description goes here.
 *
 * @author Alexander Melashchenko
 * @version 1.0 09 Feb 2017
 */
class CarsCostExecutorTest extends CarsCostExecutor {
    private static final BigDecimal COST = new BigDecimal(10);

    CarsCostExecutorTest() {
        super(
                new TreeMapCarRepository() {
                    @Override
                    public BigDecimal carsCost(int parkId) {
                        return COST;
                    }
                },
                new SimpleView(System.out)
        );
    }

    @Test
    void executeTest() {
        execute();
        assert COST.equals(result);
    }
}