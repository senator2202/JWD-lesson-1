package com.kharitonov.lesson1.main;

import com.kharitonov.lesson1.console.FunctionConsole;
import com.kharitonov.lesson1.entity.TangentFunction;
import com.kharitonov.lesson1.service.FunctionService;

public class TensTaskMain {
    public static void main(String[] args) {
        double a = -5;
        double b = 10;
        double h = 1.5;
        try {
            TangentFunction tg = new TangentFunction();
            FunctionService functionService = new FunctionService();
            double[][] msXAndValues = functionService.
                    getFunctionValues(tg, a, b, h);
            FunctionConsole functionConsole = new FunctionConsole();
            functionConsole.printFunctionValues(tg.getSignature(),
                    msXAndValues);
        } catch (NumberFormatException ex) {
            System.out.println(ex);
        }
    }
}
