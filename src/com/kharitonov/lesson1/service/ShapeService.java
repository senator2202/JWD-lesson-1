package com.kharitonov.lesson1.service;

import com.kharitonov.lesson1.entity.MyCircle;
import com.kharitonov.lesson1.entity.MySquare;
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
    public double getSquareScale(MySquare describedSquare,
                                 MySquare inscribedSquare) {
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

    public MyCircle getInscribedCircle(MySquare mySquare) {
        if (!new ValueValidator().validatePositiveValue(mySquare.getSide())) {
            throw new NumberFormatException("Side of mySquare must be > 0!");
        }
        return new MyCircle(mySquare.getSide() / 2);
    }

    public MySquare getInscribedSquare(MyCircle myCircle) {
        if (!new ValueValidator().validatePositiveValue(myCircle.getRadius())) {
            throw new NumberFormatException("Radius of myCircle must be > 0!");
        }
        double side = 2 * myCircle.getRadius() / Math.sqrt(2);
        return new MySquare(side);
    }

    public double getCircleArea(MyCircle myCircle) {
        if (!new ValueValidator().validatePositiveValue(myCircle.getRadius())) {
            throw new NumberFormatException("MyCircle radius must be > 0!");
        }
        return myCircle.getArea();
    }

    public double getCircumference(MyCircle myCircle) {
        if (!new ValueValidator().validatePositiveValue(myCircle.getRadius())) {
            throw new NumberFormatException("MyCircle radius must be > 0!");
        }
        return myCircle.getCircumference();
    }
}
