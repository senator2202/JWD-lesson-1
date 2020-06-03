package com.kharitonov.lesson1.validator;

public class DateTimeValidator {
    public boolean validateYear(int year) {
        return (year > 0);
    }

    public boolean validateMonth(int month) {
        return (month > 0 && month < 13);
    }

    public boolean validateDaySeconds(int totalSeconds) {
        return (totalSeconds >= 0 && totalSeconds <= 86400);
    }
}
