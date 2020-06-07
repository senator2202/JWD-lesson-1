package com.kharitonov.lesson1.console;

import com.kharitonov.lesson1.entity.Point;

public class PointConsole {
    private static final String CLOSER = " is closer to origin than ";
    private static final String SAME = " has the same distance " +
            "to origin as ";

    public void printClosestPoint(Point point1, Point point2, int flag) {
        String result;
        switch (flag) {
            case 0:
                result = point1 + SAME + point2;
                break;

            case 1:
                result = point1 + CLOSER + point2;
                break;

            case 2:
                result = point2 + CLOSER + point1;
                break;

            default:
                result = "";
        }
        System.out.println(result);
    }
}
