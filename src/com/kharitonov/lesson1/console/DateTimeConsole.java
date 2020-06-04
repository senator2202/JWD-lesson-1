package com.kharitonov.lesson1.console;

public class DateTimeConsole {
    public void printNumberOfDays(int month, int year, int days) {
        System.out.printf("There are %d days in %d month of %d year%n",
                days, month, year);
    }

    public void printLeapYear(int year, boolean flag) {
        String result = (flag)
                ? year + " year is leap"
                : year + " year is not leap";
        System.out.println(result);
    }

    public void printSplitSeconds(int totalSeconds, int[] time) {
        System.out.printf("%d seconds will be %d hours, %d minutes, " +
                "%d seconds", totalSeconds, time[0], time[1], time[2]);
    }
}
