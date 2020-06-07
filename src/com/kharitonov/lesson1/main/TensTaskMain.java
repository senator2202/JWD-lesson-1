package com.kharitonov.lesson1.main;

import com.kharitonov.lesson1.console.FunctionConsole;
import com.kharitonov.lesson1.entity.TangentFunction;
import com.kharitonov.lesson1.service.FunctionService;

import java.util.HashMap;

public class TensTaskMain {
    public static void main(String[] args) {
        double a = 0.0;
        double b = 0.0;
        double h = 1.0;
        try {
            TangentFunction tg = new TangentFunction();
            FunctionService functionService = new FunctionService();
            HashMap<Double,Double> result =
                    (HashMap<Double, Double>) functionService.
                    getTangentValues(tg, a, b, h);
            FunctionConsole functionConsole = new FunctionConsole();
            functionConsole.printFunctionValues(tg.getSignature(),
                    result);
        } catch (NumberFormatException ex) {
            System.out.println(ex);
        }
    }
}
