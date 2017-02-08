package com.room414.taxipark.application.controller.executors;

import com.room414.taxipark.application.model.entities.Car;

/**
 * Created by melalex on 2/8/17.
 */
class IsParsable {
    private IsParsable() {

    }

    static boolean isParsableToInt(String string) {
        if(string.isEmpty()) {
            return false;
        }
        for(int i = 0; i < string.length(); i++) {
            if(i == 0 && string.charAt(i) == '-') {
                if(string.length() == 1) {
                    return false;
                } else {
                    continue;
                }
            }
            if(Character.digit(string.charAt(i), 10) < 0) {
                return false;
            }
        }
        return true;
    }

    static boolean isParsableToCarType(String string) {
        try {
            Car.CarClass.valueOf(string);
        } catch (IllegalArgumentException ex) {
            return false;
        }
        return true;
    }

    static boolean isParsableToFloat(String string) {
        try {
            Float.parseFloat(string);
        } catch (NumberFormatException ex) {
            return false;
        }
        return true;
    }
}
