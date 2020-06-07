package com.kharitonov.lesson1.service;

import com.kharitonov.lesson1.entity.MyFunction;
import com.kharitonov.lesson1.entity.TangentFunction;
import com.kharitonov.lesson1.validator.PointValidator;

import java.util.HashMap;
import java.util.Map;

public class FunctionService {
    private static final String X_ERROR = "X coordinate must be between "
            + PointValidator.X_START + " and " + PointValidator.X_END;

    public double getMyFunctionValue(MyFunction function, double x) {
        if (!new PointValidator().validateX(x)) {
            throw new NumberFormatException(X_ERROR);
        }
        return function.getValue(x);
    }

    public String getMyFunctionSignature(MyFunction function, double x) {
        if (!new PointValidator().validateX(x)) {
            throw new NumberFormatException(X_ERROR);
        }
        return function.getSignature(x);
    }

    public double getTangentValue(TangentFunction tg, double x) {
        if (!new PointValidator().validateX(x)) {
            throw new NumberFormatException(X_ERROR);
        }
        return tg.getValue(x);
    }

    public Map<Double, Double> getTangentValues(TangentFunction tg, double rangeStart,
                                                double rangeEnd, double step) {
        PointValidator pointValidator = new PointValidator();
        if (!pointValidator.validateX(rangeStart) ||
                !pointValidator.validateX(rangeEnd)) {
            throw new NumberFormatException(X_ERROR);
        }
        HashMap<Double, Double> data = new HashMap<>();
        for (double i = rangeStart; i <= rangeEnd; i += step) {
            data.put(i, getTangentValue(tg, i));
        }
        return data;
    }
}
