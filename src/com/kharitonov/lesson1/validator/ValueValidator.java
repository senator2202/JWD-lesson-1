package com.kharitonov.lesson1.validator;

public class ValueValidator {
    public static final int RANGESTART = -100;
    public static final int RANGEEND = 100;

    public boolean validateInRange(int value) {
        return (value >= RANGESTART && value <= RANGEEND);
    }

    public String getRange() {
        StringBuilder sb=new StringBuilder();
        sb.append("[");
        sb.append(RANGESTART);
        sb.append(";");
        sb.append(RANGEEND);
        sb.append("]");
        return sb.toString();
    }
}
