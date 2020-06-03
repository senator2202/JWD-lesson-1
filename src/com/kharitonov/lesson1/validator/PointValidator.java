package com.kharitonov.lesson1.validator;

import com.kharitonov.lesson1.entity.MyPoint;

public class PointValidator {
    public static final double XSTART = -10;
    public static final double XEND = 10;
    public static final double YSTART = -10;
    public static final double YEND = 10;

    public boolean validatePoint(MyPoint point) {
        return (point.getX() >= XSTART &&
                point.getX() <= XEND &&
                point.getY() >= YSTART &&
                point.getY() <= YEND);
    }

    public boolean validateX(double x) {
        return (x>=XSTART && x<=XEND);
    }
}
