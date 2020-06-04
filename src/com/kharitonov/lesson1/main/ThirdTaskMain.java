package com.kharitonov.lesson1.main;

import com.kharitonov.lesson1.console.ShapeConsole;
import com.kharitonov.lesson1.entity.MyCircle;
import com.kharitonov.lesson1.entity.MySquare;
import com.kharitonov.lesson1.service.ShapeService;


public class ThirdTaskMain {
    /*Demonstration of task3*/
    public static void main(String[] args) {
        double area = 122.56;
        try {
            ShapeService shapeService = new ShapeService();
            ShapeConsole shapeConsole = new ShapeConsole();
            double side = shapeService.getSquareSide(area);
            MySquare describedSquare = new MySquare(side);
            MyCircle myCircle = shapeService.getInscribedCircle(describedSquare);
            MySquare inscribedSquare = shapeService.getInscribedSquare(myCircle);
            shapeConsole.printSquareArea(inscribedSquare.getArea());
            shapeConsole.printSquareScale(shapeService.
                    getSquareScale(describedSquare, inscribedSquare));
        } catch (NumberFormatException ex) {
            System.out.println(ex);
        }
    }
}
