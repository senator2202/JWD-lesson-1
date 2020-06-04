package com.kharitonov.lesson1.main;

import com.kharitonov.lesson1.console.DateTimeConsole;
import com.kharitonov.lesson1.service.DateTimeService;

public class SixthTaskMain {
    public static void main(String[] args) {
        int totalSeconds = 25379;
        try {
            int[] time = new DateTimeService().splitSeconds(totalSeconds);
            new DateTimeConsole().printSplitSeconds(totalSeconds, time);

        } catch (NumberFormatException ex) {
            System.out.println(ex);
        }
    }
}
