package com.kharitonov.lesson1.service;

import com.kharitonov.lesson1.entity.Circle;
import com.kharitonov.lesson1.entity.Square;
import com.kharitonov.lesson1.exception.TaskException;

public class ShapeService {
    public double getSquareSide(double area) throws TaskException {
        if (area < 0) {
            throw new TaskException("Wrong square area value! " +
                    "It must be > 0!");
        }
        return Math.sqrt(area);
    }

    /*square scale coefficient*/
    public double getSquareScale(Square firstSquare,
                                 Square secondSquare) throws TaskException {
        String message = "Side of square must be > 0!";
        if (firstSquare.getSide() <= 0) {
            throw new TaskException(message);
        }
        if (secondSquare.getSide() <= 0) {
            throw new TaskException(message);
        }
        return firstSquare.area() / secondSquare.area();
    }

    public Circle getInscribedCircle(Square square) throws TaskException {
        if (square.getSide() <= 0) {
            throw new TaskException("Side of square must be > 0!");
        }
        return new Circle(square.getSide() / 2);
    }

    public Square getInscribedSquare(Circle circle) throws TaskException {
        if (circle.getRadius() <= 0) {
            throw new TaskException("Radius of circle must be > 0!");
        }
        double side = 2 * circle.getRadius() / Math.sqrt(2);
        return new Square(side);
    }

    public double getCircleArea(Circle circle) throws TaskException {
        if (circle.getRadius() <= 0) {
            throw new TaskException("Circle radius must be > 0!");
        }
        return circle.area();
    }

    public double getCircumference(Circle circle) throws TaskException {
        if (circle.getRadius() <= 0) {
            throw new TaskException("Circle radius must be > 0!");
        }
        return circle.circumference();
    }
}
