package com.com.kharitonov.lesson1.validator;

import java.io.IOException;

public class DateTimeValidator {
    public boolean validateYear(int year) throws IOException {
        if (year>0) {
            return true;
        } else {
            throw new IOException("Year can't be less, than 0!");
        }
    }

    public boolean validateMonth(int month) throws IOException {
        if (month>0 && month<13) {
            return true;
        } else {
            throw new IOException("Month number must be between 1 and 12!");
        }
    }
}
