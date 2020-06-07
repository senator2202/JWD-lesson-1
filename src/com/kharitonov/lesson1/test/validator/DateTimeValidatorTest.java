package com.kharitonov.lesson1.test.validator;

import com.kharitonov.lesson1.validator.DateTimeValidator;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class DateTimeValidatorTest {
    private DateTimeValidator dateTimeValidator = new DateTimeValidator();

    @Test(groups = "year")
    public void testValidateYearTrue() {
        boolean actual = dateTimeValidator.validateYear(2015);
        assertEquals(actual, true);
    }

    @Test(groups = "year")
    public void testValidateYearFalse() {
        boolean actual = dateTimeValidator.validateYear(-36);
        assertEquals(actual, false);
    }

    @DataProvider(name = "dataForValidateYear")
    @Test(groups = "year")
    public Object[][] testDataForValidateYear() {
        return new Object[][]{
                {2015, true},
                {0, false},
                {-36, false},
                {21444, true}
        };
    }

    @Parameters({"year", "expected"})
    @Test(dataProvider = "dataForValidateYear", groups = "year")
    public void testValidateYear(int year, boolean expected) {
        boolean actual = dateTimeValidator.validateYear(year);
        assertEquals(actual, expected);
    }

    @Test(groups = "month")
    public void testValidateMonthTrue() {
        boolean actual = dateTimeValidator.validateMonth(3);
        assertEquals(actual, true);
    }

    @Test(groups = "month")
    public void testValidateMonthFalse() {
        boolean actual = dateTimeValidator.validateMonth(13);
        assertEquals(actual, false);
    }

    @DataProvider(name = "dataForValidateMonth")
    @Test(groups = "month")
    public Object[][] testDataForValidateMonth() {
        return new Object[][]{
                {1, true},
                {0, false},
                {-25, false},
                {9, true}
        };
    }

    @Parameters({"month", "expected"})
    @Test(dataProvider = "dataForValidateMonth", groups = "month")
    public void testValidateMonth(int month, boolean expected) {
        boolean actual = dateTimeValidator.validateMonth(month);
        assertEquals(actual, expected);
    }

    @Test(groups = "daySeconds")
    public void testValidateDaySecondsTrue() {
        boolean actual = dateTimeValidator.validateDaySeconds(1116);
        assertEquals(actual, true);
    }

    @Test(groups = "daySeconds")
    public void testValidateDaySecondsFalse() {
        boolean actual = dateTimeValidator.validateDaySeconds(-25);
        assertEquals(actual, false);
    }

    @DataProvider(name = "testDataForValidateDaySeconds")
    @Test(groups = "daySeconds")
    public Object[][] testDataForValidateDaySeconds() {
        return new Object[][]{
                {25000, true},
                {0, true},
                {-50, false},
                {100000, false}
        };
    }

    @Parameters({"seconds", "expected"})
    @Test(dataProvider = "testDataForValidateDaySeconds", groups = "daySeconds")
    public void testValidateDaySeconds(int seconds, boolean expected) {
        boolean actual = dateTimeValidator.validateDaySeconds(seconds);
        assertEquals(actual, expected);
    }
}