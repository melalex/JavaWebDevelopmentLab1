package com.room414.taxipark;

import com.room414.taxipark.application.Application;

/**
 * Created by melalex on 2/5/17.
 */
public class Main {
    public static void main(String[] args) {
        Application app = new Application(System.in, System.out);
        app.start();
    }
}
