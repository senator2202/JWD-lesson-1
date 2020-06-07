package com.kharitonov.lesson1.test.service;

import com.kharitonov.lesson1.service.NumberService;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class NumberServiceTest {
    NumberService numberService;

    @BeforeTest
    public void init() {
        numberService = new NumberService();
    }

    @DataProvider(name = "dataForLastDigitOfSquare")
    @Test(groups = "lastDigit")
    public Object[][] dataForLastDigitOfSquare() {
        return new Object[][]{
                {2, 4},
                {-13, 9},
                {0, 0},
                {30, 0}
        };
    }

    @Parameters({"number", "expectedResult"})
    @Test(groups = "lastDigit", dataProvider = "dataForLastDigitOfSquare")
    public void testGetLastDigitOfSquare(int number, int expectedResult) {
        int actualResult = numberService.getLastDigitOfSquare(number);
        assertEquals(actualResult, expectedResult);
    }

    @DataProvider(name = "dataForLastDigitOfSquareException")
    @Test(groups = "lastDigit")
    public Object[][] dataForLastDigitOfSquareException() {
        return new Object[][]{
                {222},
                {-130},
                {1000},
                {-330}
        };
    }

    @Parameters({"number"})
    @Test(groups = "lastDigit",
            dataProvider = "dataForLastDigitOfSquareException",
            expectedExceptions = NumberFormatException.class)
    public void testGetLastDigitOfSquareException(int number) {
        try {
            numberService.getLastDigitOfSquare(number);
        } catch (NumberFormatException ex) {
            System.out.println(ex);
            throw ex;
        }
    }

    @DataProvider(name = "dataForCheckForTwoEven")
    @Test(groups = "twoEven")
    public Object[][] dataForCheckForTwoEven() {
        return new Object[][]{
                {true, new int[]{2, 4, 1, 3}},
                {false, new int[]{6, 7, 9, 11}},
                {true, new int[]{-12, 14, -16, 23, 27}},
                {false, new int[]{-33, 23, -35, -37, -39, -41}}
        };
    }

    @Parameters({"expectedResult", "numbers"})
    @Test(groups = "twoEven",
            dataProvider = "dataForCheckForTwoEven")
    public void testCheckForTwoEven(boolean expectedResult, int[] numbers) {
        boolean actualResult = numberService.checkForTwoEven(numbers);
        assertEquals(actualResult, expectedResult);
    }

    @DataProvider(name = "dataForCheckForTwoEvenEception")
    @Test(groups = "twoEven")
    public Object[][] dataForCheckForTwoEvenEception() {
        return new Object[][]{
                {new int[]{200, 4, 1, 3}},
                {new int[]{6, -777, 999, 11}},
                {new int[]{-122, 14, -164, 23, 27}},
                {new int[]{-33, 233, -35, -37, -393, -41}}
        };
    }

    @Parameters({"numbers"})
    @Test(groups = "twoEven",
            dataProvider = "dataForCheckForTwoEvenEception",
            expectedExceptions = NumberFormatException.class)
    public void testCheckForTwoEvenEception(int[] numbers) {
        try {
            numberService.checkForTwoEven(numbers);
        } catch (NumberFormatException ex) {
            System.out.println(ex);
            throw ex;
        }
    }

    @DataProvider(name = "dataForTestIsPerfect")
    @Test(groups = "perfect")
    public Object[][] dataForTestIsPerfect() {
        return new Object[][]{
                {6, true},
                {9, false},
                {496, true},
                {222, false}
        };
    }

    @Parameters({"number", "expectedResult"})
    @Test(groups = "perfect", dataProvider = "dataForTestIsPerfect")
    public void testIsPerfect(int number, boolean expectedResult) {
        boolean actualResult = numberService.isPerfect(number);
        assertEquals(actualResult, expectedResult);
    }

    @DataProvider(name = "dataForTestIsPerfectException")
    @Test(groups = "perfect")
    public Object[][] dataForTestIsPerfectException() {
        return new Object[][]{
                {-6},
                {-9},
                {0},
                {-28}
        };
    }

    @Parameters({"number"})
    @Test(groups = "perfect",
            dataProvider = "dataForTestIsPerfectException",
            expectedExceptions = NumberFormatException.class)
    public void testIsPerfectException(int number) {
        try {
            numberService.isPerfect(number);
        } catch (NumberFormatException ex) {
            System.out.println(ex);
            throw ex;
        }
    }
}