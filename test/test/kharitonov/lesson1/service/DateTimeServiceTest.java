package test.kharitonov.lesson1.service;

import com.kharitonov.lesson1.entity.Time;
import com.kharitonov.lesson1.exception.TaskException;
import com.kharitonov.lesson1.service.DateTimeService;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class DateTimeServiceTest {
    DateTimeService dateTimeService;

    @BeforeTest
    private void init() {
        dateTimeService = new DateTimeService();
    }

    @DataProvider(name = "dataForDays")
    @Test(groups = "days")
    public Object[][] dataForDays() {
        return new Object[][]{
                {2, 2020, 29},
                {3, 2019, 31},
                {12, 1845, 31},
                {9, 1945, 30}
        };
    }

    @Parameters({"month", "year", "expectedResult"})
    @Test(groups = "days", dataProvider = "dataForDays")
    public void testGetDays(int month, int year, int expectedResult) {
        try {
            int actualResult = dateTimeService.getDays(month, year);
            assertEquals(actualResult, expectedResult);
        } catch (TaskException ex) {
            System.out.println(ex);
        }
    }

    @DataProvider(name = "dataForDaysException")
    @Test(groups = "days")
    public Object[][] dataForDaysException() {
        return new Object[][]{
                {-2, 2020},
                {3, -154},
                {13, 1845},
                {-9, -1945}
        };
    }

    @Parameters({"month", "year"})
    @Test(groups = "days", dataProvider = "dataForDaysException",
            expectedExceptions = AssertionError.class)
    public void testGetDaysException(int month, int year) {
        try {
            dateTimeService.getDays(month, year);
        } catch (TaskException ex) {
            System.out.println(ex);
            fail();
        }
    }

    @DataProvider(name = "dataForLeapYear")
    @Test(groups = "year")
    public Object[][] dataForLeapYear() {
        return new Object[][]{
                {2020, true},
                {2001, false},
                {4, true},
                {1861, false}
        };
    }

    @Parameters({"year", "expectedResult"})
    @Test(groups = "year", dataProvider = "dataForLeapYear")
    public void testIsLeapYear(int year, boolean expectedResult) {
        try {
            boolean actualResult = dateTimeService.isLeapYear(year);
            assertEquals(actualResult, expectedResult);
        } catch (TaskException ex) {
            System.out.println(ex);
        }
    }

    @DataProvider(name = "dataForLeapYearException")
    @Test(groups = "year")
    public Object[][] dataForLeapYearException() {
        return new Object[][]{
                {-2020},
                {0},
                {-4}
        };
    }

    @Parameters({"year"})
    @Test(groups = "year", dataProvider = "dataForLeapYearException",
            expectedExceptions = AssertionError.class)
    public void testIsLeapYearException(int year) {
        try {
            dateTimeService.isLeapYear(year);
        } catch (TaskException ex) {
            System.out.println(ex);
            fail();
        }
    }

    @DataProvider(name = "dataForSplitSeconds")
    @Test(groups = "seconds")
    public Object[][] dataForSplitSeconds() {
        return new Object[][]{
                {3600, new Time(1, 0, 0)},
                {36366, new Time(10, 6, 6)},
                {0, new Time(0, 0, 0)},
                {55555, new Time(15, 25, 55)}

        };
    }

    @Parameters({"totalSeconds", "expectedResult"})
    @Test(groups = "seconds", dataProvider = "dataForSplitSeconds")
    public void testSplitSeconds(int totalSeconds, Time expectedResult) {
        try {
            Time actualResult = dateTimeService.splitSeconds(totalSeconds);
            assertEquals(actualResult, expectedResult);
        } catch (TaskException e) {
            System.out.println(e);
        }
    }

    @DataProvider(name = "dataForSplitSecondsException")
    @Test(groups = "seconds")
    public Object[][] dataForSplitSecondsException() {
        return new Object[][]{
                {-3600},
                {100000},
                {-1},
        };
    }

    @Parameters({"totalSeconds"})
    @Test(groups = "seconds", dataProvider = "dataForSplitSecondsException",
            expectedExceptions = AssertionError.class)
    public void testSplitSecondsException(int totalSeconds) {
        try {
            dateTimeService.splitSeconds(totalSeconds);
        } catch (TaskException ex) {
            System.out.println(ex);
            fail();
        }
    }
}