package com.kharitonov.lesson1.validator;

public class DateTimeValidator {
    public static final int MAX_SECONDS = 86400;
    public static final int MAX_MONTH = 12;

    public boolean validateYear(int year) {
        return (year > 0);
    }

    public boolean validateMonth(int month) {
        return (month >= 1 && month <= MAX_MONTH);
    }

    public boolean validateDaySeconds(int totalSeconds) {
        return (totalSeconds >= 0 && totalSeconds <= MAX_SECONDS);
    }
}
