package com.kharitonov.lesson1.service;

import com.kharitonov.lesson1.entity.MyFunction;
import com.kharitonov.lesson1.entity.TangentFunction;
import com.kharitonov.lesson1.validator.PointValidator;

public class FunctionService {
    private static final String XERROR = "X coordinate must be between "
            + PointValidator.XSTART + " and " + PointValidator.XEND;

    public double getFunctionValue(MyFunction function, double x) {
        if (!new PointValidator().validateX(x)) {
            throw new NumberFormatException(XERROR);
        }
        return function.getValue(x);
    }

    public String getFunctionSignature(MyFunction function, double x) {
        if (!new PointValidator().validateX(x)) {
            throw new NumberFormatException(XERROR);
        }
        return function.getSignature(x);
    }

    public double getFunctionValue(TangentFunction tg, double x) {
        if (!new PointValidator().validateX(x)) {
            throw new NumberFormatException(XERROR);
        }
        return tg.getValue(x);
    }

    public double[][] getFunctionValues(TangentFunction tg, double a,
                                        double b, double h) {
        int size = (int) ((b - a) / h) + 1;
        double[][] msXAndValues = new double[2][size];
        int count = 0;
        for (double i = a; i < b; i += h) {
            msXAndValues[0][count] = i;
            msXAndValues[1][count++] = getFunctionValue(tg, i);
        }
        return msXAndValues;
    }
}
