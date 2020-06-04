package com.kharitonov.lesson1.validator;

public class ValueValidator {
    public static final int RANGESTART = -100;
    public static final int RANGEEND = 100;

    public boolean validatePositiveValue(double value) {
        return value > 0;
    }

    public boolean validateNaturalValue(int value) {
        return value > 0;
    }

    public boolean validateInRange(int value) {
        return (value >= RANGESTART && value <= RANGEEND);
    }

    public String getRange() {
        return "[" + RANGESTART + ";" + RANGEEND + "]";
    }
}
