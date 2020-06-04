package com.kharitonov.lesson1.main;

import com.kharitonov.lesson1.console.FunctionConsole;
import com.kharitonov.lesson1.entity.MyFunction;
import com.kharitonov.lesson1.service.FunctionService;

public class EightsTaskMain {
    public static void main(String[] args) {
        MyFunction myFunction = new MyFunction();
        double x = -12.2;
        try {
            FunctionService functionService = new FunctionService();
            double result = functionService.getFunctionValue(myFunction, x);
            String functionSign = functionService.
                    getFunctionSignature(myFunction, x);
            new FunctionConsole().
                    printFunctionValue(functionSign, x, result);
        } catch (NumberFormatException ex) {
            System.out.println(ex);
        }
    }
}
