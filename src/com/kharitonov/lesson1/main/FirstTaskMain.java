package com.kharitonov.lesson1.main;

import com.kharitonov.lesson1.console.NumberConsole;
import com.kharitonov.lesson1.service.NumberService;

public class FirstTaskMain {
    /*Demonstration of task 1*/
    public static void main(String[] args) {
        int number = 4;
        int digit = new NumberService().getLastDigitOfSquare(number);
        new NumberConsole().printLastDigitOfSquare(number, digit);
    }
}
