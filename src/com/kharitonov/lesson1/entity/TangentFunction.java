package com.kharitonov.lesson1.entity;

public class TangentFunction {
    private static final String SIGNATURE = "tg(x)";

    public String getSignature() {
        return SIGNATURE;
    }

    public double getValue(double x) {
        return Math.tan(x);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("x = ");
        sb.append(SIGNATURE);
        return sb.toString();
    }
}
