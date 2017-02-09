package com.room414.taxipark.application.view.interfaces;

import com.room414.taxipark.application.model.entities.Car;
import com.room414.taxipark.application.model.entities.Park;

import java.util.List;

/**
 * Created by melalex on 2/6/17.
 */
public interface View {
    void renderCarsList(List<Car> carList);
    void renderParksList(List<Park> parkList);
    void renderMessage(String message);
}
