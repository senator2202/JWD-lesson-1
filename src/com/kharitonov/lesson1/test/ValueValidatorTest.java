package com.kharitonov.lesson1.test;

import com.kharitonov.lesson1.validator.ValueValidator;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import static org.testng.Assert.*;

public class ValueValidatorTest {
    private ValueValidator valueValidator = new ValueValidator();

    @Test(groups = "inRange")
    public void testValidateInRangeTrue() {
        boolean actual = valueValidator.validateInRange(2);
        boolean expected = true;
        assertEquals(actual, expected);
    }

    @Test(groups = "inRange")
    public void testValidateInRangeFalse() {
        boolean actual = valueValidator.validateInRange(222);
        boolean expected = false;
        assertEquals(actual, expected);
    }

    @DataProvider(name = "dataForValidateInRange")
    @Test(groups = "inRange")
    public Object[][] dataForValidateInRange() {
        return new Object[][]{
                {2, true},
                {-2, true},
                {222, false},
                {-101, false},
                {0, true}
        };
    }

    @Parameters({"number", "expected"})
    @Test(dataProvider = "dataForValidateInRange", groups = "inRange")
    public void testValidateInRange(int number, boolean expected) {
        boolean actual = valueValidator.validateInRange(number);
        assertEquals(actual, expected);
    }

    @Test
    public void testGetRange() {
        String actual = valueValidator.getRange();
        String expected = "[-100;100]";
        assertEquals(actual, expected);
    }
}