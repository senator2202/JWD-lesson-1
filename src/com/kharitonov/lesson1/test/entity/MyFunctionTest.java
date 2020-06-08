package com.kharitonov.lesson1.test.entity;

import com.kharitonov.lesson1.entity.MyFunction;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MyFunctionTest {
    MyFunction myFunction = new MyFunction();

    @BeforeTest
    private void init() {
        myFunction = new MyFunction();
    }

    @DataProvider(name = "dataForSignature")
    public Object[][] dataForSignature() {
        return new Object[][]{
                {-10, "1/(x^3-6)"},
                {0, "1/(x^3-6)"},
                {3, "-x^2+3*x+9"},
                {25, "-x^2+3*x+9"}
        };
    }

    @Parameters({"x", "expectedResult"})
    @Test(dataProvider = "dataForSignature", groups = "signature")
    public void testGetSignature(double x, String expectedResult) {
        String actualResult = myFunction.getSignature(x);
        Assert.assertEquals(actualResult, expectedResult);
    }

    @DataProvider(name = "dataForValue")
    @Test(groups = "value")
    public Object[][] dataForValue() {
        return new Object[][]{
                {0, -0.166667},
                {1, -0.2},
                {3, 9},
                {5, -1}
        };
    }

    @Parameters({"x", "expectedResult"})
    @Test(dataProvider = "dataForValue", groups = "value")
    public void testGetValue(double x, double expectedResult) {
        double actualResult = myFunction.getValue(x);
        Assert.assertEquals(actualResult, expectedResult, 0.000001);
    }
}