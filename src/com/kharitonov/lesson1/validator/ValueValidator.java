package com.kharitonov.lesson1.validator;

public class ValueValidator {
    public boolean validatePositiveValue(double value) {
        return value > 0;
    }

    public boolean validateNaturalValue(int value) {
        return value > 0;
    }
}
