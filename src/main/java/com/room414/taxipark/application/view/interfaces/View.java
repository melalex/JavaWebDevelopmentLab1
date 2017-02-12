package com.room414.taxipark.application.view.interfaces;

import com.room414.taxipark.application.model.entities.Car;
import com.room414.taxipark.application.model.entities.Park;

import java.util.List;

/**
 * Show result of queries to user.
 *
 * @version 1.0 12 Feb 2017
 * @author melalex
 */
public interface View {
    /**
     * Render List of Car instances
     *
     * @see Car
     * @param carList source
     */
    void renderCarsList(List<Car> carList);

    /**
     * Render List of Park instances
     *
     * @see Park
     * @param parkList source
     */
    void renderParksList(List<Park> parkList);

    /**
     * Add message to View
     *
     * @param message message to add.
     */
    void renderMessage(String message);

    /**
     * Add message to View and go to new line.
     *
     * @param line message to add.
     */
    void renderLine(String line);
}
