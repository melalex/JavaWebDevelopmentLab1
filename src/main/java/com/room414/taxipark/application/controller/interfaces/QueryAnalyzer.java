package com.room414.taxipark.application.controller.interfaces;

import com.room414.taxipark.application.controller.infrastucture.Query;

/**
 * Created by melalex on 2/7/17.
 */
public interface QueryAnalyzer {
    Query analyze(String query);
}
