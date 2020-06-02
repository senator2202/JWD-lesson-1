package com.com.kharitonov.lesson1.service;

import com.com.kharitonov.lesson1.entity.Circle;
import com.com.kharitonov.lesson1.entity.Square;

public class ShapeService {
    public double getSquareArea(double side) {
        return side*side;
    }

    public double getSquareSide(double area) {
        return Math.sqrt(area);
    }

    public double getSquareAreaByDiagonal(double diagonal) {
        return Math.pow(diagonal,2)/2;
    }

    /*Described/inscribes square coefficient*/
    public double getSquareScale(Square describedSquare,
                                 Square inscribedSquare) {
        return describedSquare.getArea()/inscribedSquare.getArea();
    }

    public double getCircleArea(double radius) {
        return Math.PI*Math.pow(radius,2);
    }

    public double getCircumference(double radius) {
        return 2*Math.PI*radius;
    }

    public Circle getInscribedCircle(Square square) {
        return new Circle(square.getSide()/2);
    }

    public Square getInscribedSquare(Circle circle) {
        double side=2*circle.getRadius()/Math.sqrt(2);
        return new Square(side);
    }
}
