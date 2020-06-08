package com.kharitonov.lesson1.main;

import com.kharitonov.lesson1.console.PointConsole;
import com.kharitonov.lesson1.entity.Point;
import com.kharitonov.lesson1.exception.TaskException;
import com.kharitonov.lesson1.service.PointService;

public class SevensTaskMain {
    public static void main(String[] args) {
        Point point1 = new Point(-4, 9);
        Point point2 = new Point(7, 3);
        try {
            PointService pointService = new PointService();
            int result = pointService.defineClosestPoint(point1, point2);
            new PointConsole().printClosestPoint(point1, point2, result);
        } catch (TaskException ex) {
            System.out.println(ex);
        }
    }
}
