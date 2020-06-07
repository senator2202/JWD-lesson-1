package com.kharitonov.lesson1.console;

import java.util.Map;

public class FunctionConsole {
    public void printFunctionValue(String signature, double x, double value) {
        System.out.println("F(x) = " + signature);
        System.out.printf("F(%5.2f) = %5.9f", x, value);
    }

    public void printFunctionValues(String signature,
                                    Map<Double, Double> data) {
        System.out.println("F(x) = " + signature);

        for (Map.Entry<Double, Double> item : data.entrySet()) {
            System.out.printf("%nF(%5.1f) = %5.2f", item.getKey(),
                    item.getValue());
        }
    }
}
