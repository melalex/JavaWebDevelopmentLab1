package com.room414.taxipark.application.controller.interfaces;

import com.room414.taxipark.application.controller.infrastucture.QueryChain;

/**
 * Created by melalex on 2/6/17.
 */
public interface QueryAnalyzer {
    QueryChain analyze(String query);
}
