package com.room414.taxipark;

import com.room414.taxipark.application.Application;

/**
 *
 * @version 1.0 12 Feb 2017
 * @author melalex
 */
public class Main {
    public static void main(String[] args) {
        Application app = new Application(System.in, System.out);
        app.start();
    }
}
