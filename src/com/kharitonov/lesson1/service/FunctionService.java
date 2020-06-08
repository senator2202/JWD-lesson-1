package com.kharitonov.lesson1.service;

import com.kharitonov.lesson1.entity.TangentFunction;
import com.kharitonov.lesson1.entity.TaskFunction;
import com.kharitonov.lesson1.exception.TaskException;
import com.kharitonov.lesson1.validator.PointValidator;

import java.util.HashMap;
import java.util.Map;

public class FunctionService {
    private static final String X_ERROR = "X coordinate must be between "
            + PointValidator.X_START + " and " + PointValidator.X_END;

    public double getTaskFunctionValue(TaskFunction function, double x)
            throws TaskException {
        if (!new PointValidator().validateX(x)) {
            throw new TaskException(X_ERROR);
        }
        return function.value(x);
    }

    public String getTaskFunctionSignature(TaskFunction function, double x)
            throws TaskException {
        if (!new PointValidator().validateX(x)) {
            throw new TaskException(X_ERROR);
        }
        return function.getSignature(x);
    }

    public double getTangentValue(TangentFunction tg, double x)
            throws TaskException {
        if (!new PointValidator().validateX(x)) {
            throw new TaskException(X_ERROR);
        }
        return tg.getValue(x);
    }

    public Map<Double, Double> getTangentValues(TangentFunction tg,
                                                double rangeStart,
                                                double rangeEnd,
                                                double step)
            throws TaskException {
        PointValidator pointValidator = new PointValidator();
        if (!pointValidator.validateX(rangeStart) ||
                !pointValidator.validateX(rangeEnd)) {
            throw new TaskException(X_ERROR);
        }
        HashMap<Double, Double> data = new HashMap<>();
        for (double i = rangeStart; i <= rangeEnd; i += step) {
            data.put(i, getTangentValue(tg, i));
        }
        return data;
    }
}
