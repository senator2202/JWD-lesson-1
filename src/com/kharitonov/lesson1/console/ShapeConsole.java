package com.kharitonov.lesson1.console;

public class ShapeConsole {
    public void printSquareArea(double area) {
        System.out.printf("%nArea of square is %f", area);
    }

    public void printSquareScale(double scale) {
        System.out.printf("%nScale of described square and inscribed is %f",
                scale);
    }

    public void printCircleArea(double radius, double area) {
        System.out.printf("%nCircle with radius %5.2f has area of %5.2f",
                radius, area);
    }

    public void printCircumference(double radius, double circumference) {
        System.out.printf("%nCircle with radius %5.2f has circumference" +
                " of %5.2f", radius, circumference);
    }
}
