package com.kharitonov.lesson1.main;

import com.kharitonov.lesson1.console.DateTimeConsole;
import com.kharitonov.lesson1.entity.Time;
import com.kharitonov.lesson1.service.DateTimeService;

public class SixthTaskMain {
    public static void main(String[] args) {
        int totalSeconds = 55555;
        try {
            Time time = new DateTimeService().splitSeconds(totalSeconds);
            new DateTimeConsole().printSplitSeconds(totalSeconds, time);

        } catch (NumberFormatException ex) {
            System.out.println(ex);
        }
    }
}
