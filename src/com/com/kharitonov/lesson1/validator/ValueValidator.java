package com.com.kharitonov.lesson1.validator;

import java.io.IOException;

public class ValueValidator {
    public boolean validatePositiveValue(double value) throws IOException {
        if (value>0) {
            return true;
        } else {
            throw new IOException("Value must be greater than 0");
        }
    }
}
