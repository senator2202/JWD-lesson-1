package com.kharitonov.lesson1.service;

import com.kharitonov.lesson1.entity.Circle;
import com.kharitonov.lesson1.entity.Square;

public class ShapeService {
    public double getSquareSide(double area) {
        if (area<0) {
            throw new NumberFormatException("Wrong square area value! " +
                    "It should be > 0!");
        }
        return Math.sqrt(area);
    }

    /*Described/inscribes square coefficient*/
    public double getSquareScale(Square describedSquare,
                                 Square inscribedSquare) {
        if (describedSquare.getSide()<=0) {
            throw new NumberFormatException("Side of described" +
                    " square must be > 0!");
        }
        if (inscribedSquare.getSide()<=0) {
            throw new NumberFormatException("Side of inscribed" +
                    " square must be > 0!");
        }
        return describedSquare.area() / inscribedSquare.area();
    }

    public Circle getInscribedCircle(Square square) {
        if (square.getSide()<=0) {
            throw new NumberFormatException("Side of square must be > 0!");
        }
        return new Circle(square.getSide() / 2);
    }

    public Square getInscribedSquare(Circle circle) {
        if (circle.getRadius()<=0) {
            throw new NumberFormatException("Radius of circle must be > 0!");
        }
        double side = 2 * circle.getRadius() / Math.sqrt(2);
        return new Square(side);
    }

    public double getCircleArea(Circle circle) {
        if (circle.getRadius()<=0) {
            throw new NumberFormatException("Circle radius must be > 0!");
        }
        return circle.area();
    }

    public double getCircumference(Circle circle) {
        if (circle.getRadius()<=0) {
            throw new NumberFormatException("Circle radius must be > 0!");
        }
        return circle.circumference();
    }
}
