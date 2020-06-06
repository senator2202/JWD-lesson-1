package com.kharitonov.lesson1.validator;

import com.kharitonov.lesson1.entity.Point;

public class PointValidator {
    public static final double XSTART = -10;
    public static final double XEND = 10;
    public static final double YSTART = -10;
    public static final double YEND = 10;

    public boolean validatePoint(Point point) {
        return (point.getX() >= XSTART &&
                point.getX() <= XEND &&
                point.getY() >= YSTART &&
                point.getY() <= YEND);
    }

    public boolean validateX(double x) {
        return (x >= XSTART && x <= XEND);
    }

    public String getXRange() {
        StringBuilder sb=new StringBuilder("[");
        sb.append(XSTART);
        sb.append(";");
        sb.append(XEND);
        sb.append("]");
        return sb.toString();
    }

    public String getYRange() {
        StringBuilder sb=new StringBuilder("[");
        sb.append(YSTART);
        sb.append(";");
        sb.append(YEND);
        sb.append("]");
        return sb.toString();
    }
}
