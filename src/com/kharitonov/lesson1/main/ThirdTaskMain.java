package com.kharitonov.lesson1.main;

import com.kharitonov.lesson1.console.ShapeConsole;
import com.kharitonov.lesson1.entity.Circle;
import com.kharitonov.lesson1.entity.Square;
import com.kharitonov.lesson1.service.ShapeService;


public class ThirdTaskMain {
    /*Demonstration of task3*/
    public static void main(String[] args) {
        double area = -122.56;
        try {
            ShapeService shapeService = new ShapeService();
            ShapeConsole shapeConsole = new ShapeConsole();
            double side = shapeService.getSquareSide(area);
            Square describedSquare = new Square(side);
            Circle circle = shapeService.getInscribedCircle(describedSquare);
            Square inscribedSquare = shapeService.getInscribedSquare(circle);
            shapeConsole.printSquareArea(inscribedSquare.getArea());
            shapeConsole.printSquareScale(shapeService.
                    getSquareScale(describedSquare, inscribedSquare));
        } catch (NumberFormatException ex) {
            System.out.println(ex);
        }
    }
}
