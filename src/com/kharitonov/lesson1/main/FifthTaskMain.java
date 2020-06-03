package com.kharitonov.lesson1.main;

import com.kharitonov.lesson1.console.NumberConsole;
import com.kharitonov.lesson1.service.NumberService;

public class FifthTaskMain {
    public static void main(String[] args) {
        int number = 6;
        try {
            boolean flag = new NumberService().isPerfect(number);
            new NumberConsole().printPerfect(number, flag);
        } catch (NumberFormatException ex) {
            System.out.println(ex);
        }
    }
}
