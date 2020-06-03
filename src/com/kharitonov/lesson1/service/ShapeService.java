package com.kharitonov.lesson1.service;

import com.kharitonov.lesson1.entity.Circle;
import com.kharitonov.lesson1.entity.Square;
import com.kharitonov.lesson1.validator.ValueValidator;

public class ShapeService {
    public double getSquareSide(double area) {
        if (!new ValueValidator().validatePositiveValue(area)) {
            throw new NumberFormatException("Wrong square area value! " +
                    "It should be > 0!");
        }
        return Math.sqrt(area);
    }

    /*Described/inscribes square coefficient*/
    public double getSquareScale(Square describedSquare,
                                 Square inscribedSquare) {
        ValueValidator valueValidator = new ValueValidator();
        if (!valueValidator.validatePositiveValue(describedSquare.getSide())) {
            throw new NumberFormatException("Side of described" +
                    " square must be > 0!");
        }
        if (!valueValidator.validatePositiveValue(inscribedSquare.getSide())) {
            throw new NumberFormatException("Side of inscribed" +
                    " square must be > 0!");
        }
        return describedSquare.getArea() / inscribedSquare.getArea();
    }

    public Circle getInscribedCircle(Square square) {
        if (!new ValueValidator().validatePositiveValue(square.getSide())) {
            throw new NumberFormatException("Side of square must be > 0!");
        }
        return new Circle(square.getSide() / 2);
    }

    public Square getInscribedSquare(Circle circle) {
        if (!new ValueValidator().validatePositiveValue(circle.getRadius())) {
            throw new NumberFormatException("Radius of circle must be > 0!");
        }
        double side = 2 * circle.getRadius() / Math.sqrt(2);
        return new Square(side);
    }

    public double getCircleArea(Circle circle) {
        if (!new ValueValidator().validatePositiveValue(circle.getRadius())) {
            throw new NumberFormatException("Circle radius must be > 0!");
        }
        return circle.getArea();
    }

    public double getCircumference(Circle circle) {
        if (!new ValueValidator().validatePositiveValue(circle.getRadius())) {
            throw new NumberFormatException("Circle radius must be > 0!");
        }
        return circle.getCircumference();
    }
}
