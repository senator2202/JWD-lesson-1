package com.kharitonov.lesson1.console;

public class FunctionConsole {
    public void printFunctionValue(String signature, double x, double value) {
        System.out.println("F(x) = " + signature);
        System.out.printf("F(%5.2f) = %5.9f", x, value);
    }

    public void printFunctionValues(String signature, double[][] msXAndValues) {
        System.out.println("F(x) = " + signature);
        for (int i = 0; i < msXAndValues[0].length; i++) {
            System.out.printf("%nF(%5.1f) = %5.2f",
                    msXAndValues[0][i],
                    msXAndValues[1][i]);
        }
    }
}
