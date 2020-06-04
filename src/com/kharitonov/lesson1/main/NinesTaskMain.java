package com.kharitonov.lesson1.main;

import com.kharitonov.lesson1.console.ShapeConsole;
import com.kharitonov.lesson1.entity.MyCircle;
import com.kharitonov.lesson1.service.ShapeService;

public class NinesTaskMain {
    public static void main(String[] args) {
        double radius = 55.2;
        ShapeService shapeService = new ShapeService();
        MyCircle myCircle = new MyCircle(radius);
        try {
            double area = shapeService.getCircleArea(myCircle);
            double circumference = shapeService.getCircumference(myCircle);
            ShapeConsole shapeConsole = new ShapeConsole();
            shapeConsole.printCircleArea(radius, area);
            shapeConsole.printCircumference(radius, circumference);
        } catch (NumberFormatException ex) {
            System.out.println(ex);
        }
    }
}
