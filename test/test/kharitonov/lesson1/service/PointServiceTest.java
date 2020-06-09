package test.kharitonov.lesson1.service;

import com.kharitonov.lesson1.entity.Point;
import com.kharitonov.lesson1.exception.TaskException;
import com.kharitonov.lesson1.service.PointService;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class PointServiceTest {
    PointService pointService;

    @BeforeTest
    private void init() {
        pointService = new PointService();
    }

    @DataProvider(name = "dataForClosestPoint")
    @Test
    public Object[][] dataForClosestPoint() {
        return new Object[][]{
                {new Point(1, -1), new Point(4, 9), 1},
                {new Point(-5, -7), new Point(-2, -3), 2},
                {new Point(4, 4), new Point(-4, -4), 0}
        };
    }

    @Parameters({"firstPoint", "secondPoint", "expectedResult"})
    @Test(dataProvider = "dataForClosestPoint")
    public void testDefineClosestPoint(Point firstPoint,
                                       Point secondPoint,
                                       int expectedResult) {
        try {
            int actualResult = pointService.defineClosestPoint(firstPoint,
                    secondPoint);
            assertEquals(actualResult, expectedResult);
        } catch (TaskException e) {
            fail(e.getMessage());
        }
    }

    @DataProvider(name = "dataForClosestPointException")
    @Test
    public Object[][] dataForClosestPointException() {
        return new Object[][]{
                {new Point(11, -1.1), new Point(4, 9)},
                {new Point(-5, -7), new Point(-22.2, -3)},
                {new Point(44.2, 4), new Point(-4, -44.2)}
        };
    }

    @Parameters({"firstPoint", "secondPoint"})
    @Test(dataProvider = "dataForClosestPointException",
            expectedExceptions = TaskException.class)
    public void testDefineClosestPointException(Point firstPoint,
                                                Point secondPoint)
            throws TaskException {
        pointService.defineClosestPoint(firstPoint,
                secondPoint);
    }
}