package com.kharitonov.lesson1.service;

import com.kharitonov.lesson1.entity.Point;
import com.kharitonov.lesson1.exception.TaskException;
import com.kharitonov.lesson1.validator.PointValidator;

public class PointService {
    /*Method returns 1 if point1 closer than point2,
     * returns 2 if point2 closer than point1,
     * returns 0 if distance from origin to point1 equals to distance
     * from origin to point2*/
    public int defineClosestPoint(Point point1, Point point2)
            throws TaskException {
        PointValidator pointValidator = new PointValidator();
        String message = "\nX coordinates of points must be in range "
                + pointValidator.xRange() + ".\n"
                + "Y coordinates must be in range "
                + pointValidator.yRange();
        if (!pointValidator.validatePoint(point1) ||
                !pointValidator.validatePoint(point2)) {
            throw new TaskException(message);
        }
        if (point1.distanceFromOrigin() < point2.distanceFromOrigin()) {
            return 1;
        } else if (point2.distanceFromOrigin() < point1.distanceFromOrigin()) {
            return 2;
        }
        return 0;
    }
}
