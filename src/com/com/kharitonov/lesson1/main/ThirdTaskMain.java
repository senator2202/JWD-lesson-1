package com.com.kharitonov.lesson1.main;

import com.com.kharitonov.lesson1.console.ShapeConsole;
import com.com.kharitonov.lesson1.entity.Circle;
import com.com.kharitonov.lesson1.entity.Square;
import com.com.kharitonov.lesson1.service.ShapeService;
import com.com.kharitonov.lesson1.validator.ValueValidator;

import java.io.IOException;

import static java.lang.System.exit;


public class ThirdTaskMain {
    /*Demonstration of task3*/
    public static void main(String []args) {
        double area=-122.56;
        try {
            new ValueValidator().validatePositiveValue(area);
        } catch (IOException ex) {
            System.out.println(ex);
            exit(1);
        }
        ShapeService shapeService=new ShapeService();
        ShapeConsole shapeConsole=new ShapeConsole();
        double side=shapeService.getSquareSide(area);
        Square describedSquare=new Square(side);
        Circle circle=shapeService.getInscribedCircle(describedSquare);
        Square inscribedSquare=shapeService.getInscribedSquare(circle);
        shapeConsole.printSquareArea(inscribedSquare.getArea());
        shapeConsole.printSquareScale(shapeService.
                getSquareScale(describedSquare, inscribedSquare));


    }
}
