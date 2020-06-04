package com.kharitonov.lesson1.console;

import com.kharitonov.lesson1.entity.MyPoint;

public class PointConsole {
    private static final String CLOSERMESSAGE = " is closer to origin than ";
    private static final String SAMEMESSAGE = " has the same distance " +
            "to origin as ";

    public void printClosestPoint(MyPoint point1, MyPoint point2, int flag) {
        String result;
        switch (flag) {
            case 0:
                result = point1 + SAMEMESSAGE + point2;
                break;

            case 1:
                result = point1 + CLOSERMESSAGE + point2;
                break;

            case 2:
                result = point2 + CLOSERMESSAGE + point1;
                break;

            default:
                result = "";
        }
        System.out.println(result);
    }
}
