package test.kharitonov.lesson1.validator;

import com.kharitonov.lesson1.entity.Point;
import com.kharitonov.lesson1.validator.PointValidator;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import static org.testng.Assert.*;

public class PointValidatorTest {
    private final PointValidator pointValidator = new PointValidator();

    @Test(groups = "point")
    public void testValidatePointTrue() {
        boolean actual = pointValidator.validatePoint(new Point(3, 4));
        assertEquals(actual, true);
    }


    @Test(groups = "point")
    public void testValidatePointFalse() {
        boolean actual = pointValidator.validatePoint(new Point(13, 4));
        assertEquals(actual, false);
    }

    @DataProvider(name = "dataForValidatePoint")
    @Test(groups = "point")
    public Object[][] dataForValidatePoint() {
        return new Object[][]{
                {-5.2, 4.4, true},
                {0, -10, true},
                {-10, 12, false},
                {0, 0, true},
                {-100.2, 200, false}
        };
    }

    @Parameters({"x", "y", "expected"})
    @Test(dataProvider = "dataForValidatePoint", groups = "point")
    public void testValidatePoint(double x, double y, boolean expected) {
        boolean actual = pointValidator.validatePoint(new Point(x, y));
        assertEquals(actual, expected);
    }

    @Test(groups = "x")
    public void testValidateXTrue() {
        boolean actual = pointValidator.validateX(5);
        assertEquals(actual, true);
    }

    @Test(groups = "x")
    public void testValidateXFalse() {
        boolean actual = pointValidator.validateX(-55);
        assertEquals(actual, false);
    }

    @DataProvider(name = "dataForValidateX")
    @Test(groups = "x")
    public Object[][] dataForValidateX() {
        return new Object[][]{
                {-5.2, true},
                {0, true},
                {12, false},
                {0, true},
                {-100.2, false}
        };
    }

    @Parameters({"x", "expected"})
    @Test(dataProvider = "dataForValidateX", groups = "x")
    public void testValidateX(double x, boolean expected) {
        boolean actual = pointValidator.validateX(x);
        assertEquals(actual, expected);
    }

    @Test(groups = "range")
    public void testGetXRange() {
        String actual = pointValidator.getXRange();
        String expected = "[-10.0;10.0]";
        assertEquals(actual, expected);
    }

    @Test(groups = "range")
    public void testGetYRange() {
        String actual = pointValidator.getYRange();
        String expected = "[-10.0;10.0]";
        assertEquals(actual, expected);
    }
}