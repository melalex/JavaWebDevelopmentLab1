package com.room414.taxipark.application.controller.interfaces;

/**
 * Execute queries and show result on View.
 *
 * @version 1.0 12 Feb 2017
 * @author melalex
 */
public interface Controller {
    /**
     * Execute query and show result on View.
     *
     * @param query query to execute
     */
    void executeQuery(String query);

    /**
     * Add message to View
     *
     * @param message message to add.
     */
    void addMessage(String message);

    /**
     * Add message to View and go to new line.
     *
     * @param line message to add.
     */
    void addLine(String line);
}
