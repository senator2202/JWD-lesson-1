package com.kharitonov.lesson1.service;

import com.kharitonov.lesson1.entity.MyFunction;
import com.kharitonov.lesson1.entity.TangentFunction;
import com.kharitonov.lesson1.validator.PointValidator;

import java.util.HashMap;
import java.util.Map;

public class FunctionService {
    private static final String XERROR = "X coordinate must be between "
            + PointValidator.XSTART + " and " + PointValidator.XEND;

    public double getMyFunctionValue(MyFunction function, double x) {
        if (!new PointValidator().validateX(x)) {
            throw new NumberFormatException(XERROR);
        }
        return function.getValue(x);
    }

    public String getMyFunctionSignature(MyFunction function, double x) {
        if (!new PointValidator().validateX(x)) {
            throw new NumberFormatException(XERROR);
        }
        return function.getSignature(x);
    }

    public double getTangentValue(TangentFunction tg, double x) {
        if (!new PointValidator().validateX(x)) {
            throw new NumberFormatException(XERROR);
        }
        return tg.getValue(x);
    }

    public Map<Double, Double> getTangentValues(TangentFunction tg, double rangeStart,
                                                double rangeEnd, double step) {
        PointValidator pointValidator = new PointValidator();
        if (!pointValidator.validateX(rangeStart) ||
                !pointValidator.validateX(rangeEnd)) {
            throw new NumberFormatException(XERROR);
        }
        HashMap<Double, Double> data = new HashMap<>();
        for (double i = rangeStart; i <= rangeEnd; i += step) {
            data.put(i, getTangentValue(tg, i));
        }
        return data;
    }
}
