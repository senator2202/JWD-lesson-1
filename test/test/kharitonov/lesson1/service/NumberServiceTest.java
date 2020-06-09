package test.kharitonov.lesson1.service;

import com.kharitonov.lesson1.exception.TaskException;
import com.kharitonov.lesson1.service.NumberService;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

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
        try {
            int actualResult = numberService.getLastDigitOfSquare(number);
            assertEquals(actualResult, expectedResult);
        } catch (TaskException e) {
            fail(e.getMessage());
        }
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
            expectedExceptions = TaskException.class)
    public void testGetLastDigitOfSquareException(int number)
            throws TaskException {
        numberService.getLastDigitOfSquare(number);
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
        try {
            boolean actualResult = numberService.checkForTwoEven(numbers);
            assertEquals(actualResult, expectedResult);
        } catch (TaskException e) {
            fail(e.getMessage());
        }
    }

    @DataProvider(name = "dataForCheckForTwoEvenException")
    @Test(groups = "twoEven")
    public Object[][] dataForCheckForTwoEvenException() {
        return new Object[][]{
                {new int[]{200, 4, 1, 3}},
                {new int[]{6, -777, 999, 11}},
                {new int[]{-122, 14, -164, 23, 27}},
                {new int[]{-33, 233, -35, -37, -393, -41}}
        };
    }

    @Parameters({"numbers"})
    @Test(groups = "twoEven",
            dataProvider = "dataForCheckForTwoEvenException",
            expectedExceptions = TaskException.class)
    public void testCheckForTwoEvenException(int[] numbers)
            throws TaskException {
        numberService.checkForTwoEven(numbers);
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
        try {
            boolean actualResult = numberService.isPerfect(number);
            assertEquals(actualResult, expectedResult);
        } catch (TaskException e) {
            fail(e.getMessage());
        }
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
            expectedExceptions = TaskException.class)
    public void testIsPerfectException(int number) throws TaskException {
        numberService.isPerfect(number);
    }
}