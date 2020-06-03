package com.kharitonov.lesson1.main;

import com.kharitonov.lesson1.console.PointConsole;
import com.kharitonov.lesson1.entity.MyPoint;
import com.kharitonov.lesson1.service.PointService;

public class SevensTaskMain {
    public static void main(String[] args) {
        MyPoint point1 = new MyPoint(4, 5);
        MyPoint point2 = new MyPoint(10, -4);
        try {
            PointService pointService = new PointService();
            int result = pointService.defineClosestPoint(point1, point2);
            new PointConsole().printClosestPoint(point1, point2, result);
        } catch (NumberFormatException ex) {
            System.out.println(ex);
        }
    }
}
