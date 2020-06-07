package com.kharitonov.lesson1.service;

import com.kharitonov.lesson1.entity.Circle;
import com.kharitonov.lesson1.entity.Square;

public class ShapeService {
    public double getSquareSide(double area) {
        if (area < 0) {
            throw new NumberFormatException("Wrong square area value! " +
                    "It must be > 0!");
        }
        return Math.sqrt(area);
    }

    /*square scale coefficient*/
    public double getSquareScale(Square firstSquare,
                                 Square secondSquare) {
        String message = "Side of square must be > 0!";
        if (firstSquare.getSide() <= 0) {
            throw new NumberFormatException(message);
        }
        if (secondSquare.getSide() <= 0) {
            throw new NumberFormatException(message);
        }
        return firstSquare.area() / secondSquare.area();
    }

    public Circle getInscribedCircle(Square square) {
        if (square.getSide() <= 0) {
            throw new NumberFormatException("Side of square must be > 0!");
        }
        return new Circle(square.getSide() / 2);
    }

    public Square getInscribedSquare(Circle circle) {
        if (circle.getRadius() <= 0) {
            throw new NumberFormatException("Radius of circle must be > 0!");
        }
        double side = 2 * circle.getRadius() / Math.sqrt(2);
        return new Square(side);
    }

    public double getCircleArea(Circle circle) {
        if (circle.getRadius() <= 0) {
            throw new NumberFormatException("Circle radius must be > 0!");
        }
        return circle.area();
    }

    public double getCircumference(Circle circle) {
        if (circle.getRadius() <= 0) {
            throw new NumberFormatException("Circle radius must be > 0!");
        }
        return circle.circumference();
    }
}
