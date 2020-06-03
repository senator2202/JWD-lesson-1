package com.kharitonov.lesson1.main;

import com.kharitonov.lesson1.console.NumberConsole;
import com.kharitonov.lesson1.service.NumberService;

public class FoursTaskMain {
    public static void main(String[] args) {
        int a = 2;
        int b = 11;
        int c = 7;
        int d = 9;
        boolean flag = new NumberService().checkForTwoEven(a, b, c, d);
        new NumberConsole().printResultForTwoEven(flag, a, b, c, d);
    }
}
