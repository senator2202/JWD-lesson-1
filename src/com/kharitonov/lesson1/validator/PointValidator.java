package com.kharitonov.lesson1.validator;

import com.kharitonov.lesson1.entity.Point;

public class PointValidator {
    public static final double X_START = -10;
    public static final double X_END = 10;
    public static final double Y_START = -10;
    public static final double Y_END = 10;

    public boolean validatePoint(Point point) {
        return (point.getX() >= X_START &&
                point.getX() <= X_END &&
                point.getY() >= Y_START &&
                point.getY() <= Y_END);
    }

    public boolean validateX(double x) {
        return (x >= X_START && x <= X_END);
    }

    public String xRange() {
        StringBuilder sb = new StringBuilder();
        sb.append('[').append(X_START).append(';');
        sb.append(X_END).append(']');
        return sb.toString();
    }

    public String yRange() {
        StringBuilder sb = new StringBuilder();
        sb.append('[').append(Y_START).append(';');
        sb.append(Y_END).append(']');
        return sb.toString();
    }
}
