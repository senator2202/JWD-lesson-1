package com.kharitonov.lesson1.validator;

public class ValueValidator {
    public static final int RANGE_START = -100;
    public static final int RANGE_END = 100;

    public boolean validateInRange(int value) {
        return (value >= RANGE_START && value <= RANGE_END);
    }

    public String getRange() {
        StringBuilder sb = new StringBuilder();
        sb.append('[').append(RANGE_START).append(';');
        sb.append(RANGE_END).append(']');
        return sb.toString();
    }
}
