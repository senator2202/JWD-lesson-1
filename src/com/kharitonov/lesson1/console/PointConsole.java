package com.kharitonov.lesson1.console;

import com.kharitonov.lesson1.entity.MyPoint;

public class PointConsole {
    public void printClosestPoint(MyPoint point1, MyPoint point2, int flag) {
        String result;
        switch (flag) {
            case 0:
                result = "Point [" + point1.getX() + ";" + point1.getY() + "]"
                        + " has the same distance to origin as Point "
                        + "[" + point2.getX() + ";" + point2.getY() + "]";
                break;

            case 1:
                result = "Point [" + point1.getX() + ";" + point1.getY() + "]"
                        + "is closer to origin than Point "
                        + "[" + point2.getX() + ";" + point2.getY() + "]";
                break;

            case 2:
                result = "Point [" + point2.getX() + ";" + point2.getY() + "]"
                        + "is closer to origin than Point "
                        + "[" + point1.getX() + ";" + point1.getY() + "]";
                break;

            default:
                result="";
        }
        System.out.println(result);
    }
}
