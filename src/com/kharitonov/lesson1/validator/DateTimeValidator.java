package com.kharitonov.lesson1.validator;

public class DateTimeValidator {
    public static final int MAXSECONDS = 86400;
    public static final int MAXMONTH = 12;

    public boolean validateYear(int year) {
        return (year > 0);
    }

    public boolean validateMonth(int month) {
        return (month >= 1 && month <= MAXMONTH);
    }

    public boolean validateDaySeconds(int totalSeconds) {
        return (totalSeconds >= 0 && totalSeconds <= MAXSECONDS);
    }
}
