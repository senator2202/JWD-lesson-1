package com.kharitonov.lesson1.entity;

public class TaskFunction {
    public static final String SIGNATURE_A = "-x^2+3*x+9";
    public static final String SIGNATURE_B = "1/(x^3-6)";

    public String getSignature(double x) {
        return (x >= 3) ? SIGNATURE_A : SIGNATURE_B;
    }

    public double value(double x) {
        if (x >= 3) {
            return 3 * x + 9 - Math.pow(x, 2);
        } else {
            return 1 / (Math.pow(x, 3) - 6);
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TaskFunction{");
        sb.append('}');
        return sb.toString();
    }
}
