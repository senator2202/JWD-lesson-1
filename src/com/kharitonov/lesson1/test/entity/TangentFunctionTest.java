package com.kharitonov.lesson1.test.entity;

import com.kharitonov.lesson1.entity.TangentFunction;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TangentFunctionTest {
    TangentFunction tangent;

    @BeforeTest
    private void init() {
        tangent = new TangentFunction();
    }

    @Test(groups = "signature")
    public void testGetSignature() {
        String actualResult = tangent.getSignature();
        Assert.assertEquals(actualResult, "tg(x)");
    }

    @DataProvider(name = "dataForValue")
    @Test(groups = "value")
    public Object[][] dataForValue() {
        return new Object[][]{
                {0, 0},
                {1, 1.55741},
                {-1, -1.55741},
                {20, 2.237161}
        };
    }

    @Parameters({"x", "expectedResult"})
    @Test(groups = "value", dataProvider = "dataForValue")
    public void testGetValue(double x, double expectedResult) {
        double actualResult = tangent.getValue(x);
        Assert.assertEquals(actualResult, expectedResult, 0.001);
    }
}