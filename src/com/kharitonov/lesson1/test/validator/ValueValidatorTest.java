package com.kharitonov.lesson1.test.validator;

import com.kharitonov.lesson1.validator.ValueValidator;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;


import static org.testng.Assert.*;

public class ValueValidatorTest {
    private final ValueValidator valueValidator = new ValueValidator();

    private final int number;//number to validate
    private final boolean expected;//expected validating value

    /*Factory creates new test objects via constructor with params*/
    @Factory(dataProvider = "dataForValidateInRange")
    public ValueValidatorTest(int number, boolean expected) {
        this.number = number;
        this.expected = expected;
    }

    @Test(groups = "inRange")
    public void testValidateInRangeTrue() {
        boolean actual = valueValidator.validateInRange(2);
        assertEquals(actual, true);
    }

    @Test(groups = "inRange")
    public void testValidateInRangeFalse() {
        boolean actual = valueValidator.validateInRange(222);
        assertEquals(actual, false);
    }

    @DataProvider(name = "dataForValidateInRange")
    @Test(groups = "inRange")
    public static Object[][] dataForValidateInRange() {
        return new Object[][]{
                {2, true},
                {-2, true},
                {222, false},
                {-101, false},
                {0, true}
        };
    }


    @Test(groups = "inRange")
    public void testValidateInRange() {
        boolean actual = valueValidator.validateInRange(number);
        assertEquals(actual, expected);
    }

    @Test
    public void testGetRange() {
        String actual = valueValidator.getRange();
        assertEquals(actual, "[-100;100]");
    }
}