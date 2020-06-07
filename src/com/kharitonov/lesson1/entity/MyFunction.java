package com.kharitonov.lesson1.entity;

public class MyFunction {
    public static final String SIGNATUREA = "-x^3+3*x+9";
    public static final String SIGNATUREB = "1/(x^3-6)";

    public String getSignature(double x) {
        return (x >= 3) ? SIGNATUREA : SIGNATUREB;
    }

    public double getValue(double x) {
        if (x >= 3) {
            return 3 * x + 9 - Math.pow(x, 2);
        } else {
            return 1 / (Math.pow(x, 3) - 6);
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("MyFunction{");
        sb.append('}');
        return sb.toString();
    }
}
