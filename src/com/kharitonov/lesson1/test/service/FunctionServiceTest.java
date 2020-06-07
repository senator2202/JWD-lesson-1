package com.kharitonov.lesson1.test.service;

import com.kharitonov.lesson1.entity.MyFunction;
import com.kharitonov.lesson1.entity.TangentFunction;
import com.kharitonov.lesson1.service.FunctionService;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.*;

public class FunctionServiceTest {
    FunctionService functionService;

    @BeforeTest
    private void init() {
        functionService = new FunctionService();
    }

    @DataProvider(name = "dataForMyFunctionValue")
    @Test(groups = "functionValue")
    public Object[][] dataForMyFunctionValue() {
        MyFunction myFunction = new MyFunction();
        return new Object[][]{
                {myFunction, 0.0, -1.0 / 6.0},
                {myFunction, 2.0, 1.0 / 2.0},
                {myFunction, 3.0, 9.0},
                {myFunction, 5.0, -1.0}
        };
    }

    @Parameters({"function", "x", "expectedResult"})
    @Test(dataProvider = "dataForMyFunctionValue", groups = "functionValue")
    public void testGetMyFunctionValue(MyFunction function, double x,
                                       double expectedResult) {
        double actualResult = functionService.getMyFunctionValue(function, x);
        assertEquals(actualResult, expectedResult);
    }

    @DataProvider(name = "dataForMyFunctionValueException")
    @Test(groups = "functionValue")
    public Object[][] dataForMyFunctionValueException() {
        MyFunction myFunction = new MyFunction();
        return new Object[][]{
                {myFunction, -11.0},
                {myFunction, 22.0},
                {myFunction, 333.0},
                {myFunction, -15.0}
        };
    }

    @Parameters({"function", "x"})
    @Test(dataProvider = "dataForMyFunctionValueException",
            groups = "functionValue",
            expectedExceptions = NumberFormatException.class)
    public void testGetMyFunctionValueException(MyFunction function, double x) {
        try {
            functionService.getMyFunctionValue(function, x);
        } catch (NumberFormatException ex) {
            System.out.println(ex);
            throw ex;
        }
    }

    @DataProvider(name = "dataForMyFunctionSignature")
    @Test(groups = "functionSignature")
    public Object[][] dataForMyFunctionSignature() {
        MyFunction myFunction = new MyFunction();
        return new Object[][]{
                {myFunction, 3.0, MyFunction.SIGNATURE_A},
                {myFunction, 2.9, MyFunction.SIGNATURE_B},
                {myFunction, -9.9, MyFunction.SIGNATURE_B},
                {myFunction, 9.9, MyFunction.SIGNATURE_B}
        };
    }

    @Parameters({"myFunction", "x", "expectedResult"})
    @Test(groups = "functionSignature",
            dataProvider = "dataForMyFunctionSignature")
    public void testGetMyFunctionSignature(MyFunction myFunction,
                                           double x,
                                           String expectedResult) {
        String actualResult = functionService.
                getMyFunctionSignature(myFunction, x);
        assertEquals(actualResult, expectedResult);
    }

    @DataProvider(name = "dataForMyFunctionSignatureException")
    @Test(groups = "functionSignature")
    public Object[][] dataForMyFunctionSignatureException() {
        MyFunction myFunction = new MyFunction();
        return new Object[][]{
                {myFunction, 33.0},
                {myFunction, 22.9},
                {myFunction, -19.9},
                {myFunction, 99.9}
        };
    }

    @Parameters({"myFunction", "x"})
    @Test(groups = "functionSignature",
            dataProvider = "dataForMyFunctionSignatureException",
            expectedExceptions = NumberFormatException.class)
    public void testGetMyFunctionSignatureException(MyFunction myFunction,
                                                    double x) {
        try {
            functionService.getMyFunctionSignature(myFunction, x);
        } catch (NumberFormatException ex) {
            System.out.println(ex);
            throw ex;
        }
    }

    @DataProvider(name = "dataForTangentValue")
    @Test(groups = "tangentValue")
    public Object[][] dataForTangentValue() {
        TangentFunction tangent = new TangentFunction();
        return new Object[][]{
                {tangent, 1.1, Math.tan(1.1)},
                {tangent, 0.2, Math.tan(0.2)},
                {tangent, -1.3, Math.tan(-1.3)}
        };
    }

    @Parameters({"tangentFunction", "x", "expectedResult"})
    @Test(groups = "tangentValue", dataProvider = "dataForTangentValue")
    public void testGetTangentValue(TangentFunction tangent, double x,
                                    double expectedResult) {
        double actualValue = functionService.getTangentValue(tangent, x);
        assertEquals(actualValue, expectedResult);
    }

    @DataProvider(name = "dataForTangentValueException")
    @Test(groups = "tangentValue")
    public Object[][] dataForTangentValueException() {
        TangentFunction tangent = new TangentFunction();
        return new Object[][]{
                {tangent, 11.1},
                {tangent, 100.2},
                {tangent, -110.3}
        };
    }

    @Parameters({"tangentFunction", "x"})
    @Test(groups = "tangentValue",
            dataProvider = "dataForTangentValueException",
            expectedExceptions = NumberFormatException.class)
    public void testGetTangentValueException(TangentFunction tangent, double x) {
        try {
            functionService.getTangentValue(tangent, x);
        } catch (NumberFormatException ex) {
            System.out.println(ex);
            throw ex;
        }
    }

    @DataProvider(name = "dataForTangentValues")
    @Test(groups = "tangentValues")
    public Object[][] dataForTangentValues() {
        TangentFunction tangent = new TangentFunction();
        HashMap<Double, Double> xAndValues1 = new HashMap<>();
        HashMap<Double, Double> xAndValues2 = new HashMap<>();
        HashMap<Double, Double> xAndValues3 = new HashMap<>();
        xAndValues1.put(0.0, 0.0);
        xAndValues2.put(3.0, Math.tan(3.0));
        xAndValues2.put(4.0, Math.tan(4.0));
        xAndValues2.put(5.0, Math.tan(5.0));
        xAndValues3.put(-4.0, Math.tan(-4.0));
        xAndValues3.put(-3.0, Math.tan(-3.0));
        xAndValues3.put(-2.0, Math.tan(-2.0));
        return new Object[][]{
                {tangent, 0, 0, 1, xAndValues1},
                {tangent, 3, 5, 1, xAndValues2},
                {tangent, -4, -2, 1, xAndValues3}
        };
    }

    @Parameters({"tangentFunction", "rangeStart",
            "rangeEnd", "step", "expectedResult"})
    @Test(groups = "tangentValues", dataProvider = "dataForTangentValues")
    public void testGetTangentValues(TangentFunction tangent,
                                     double rangeStart,
                                     double rangeEnd,
                                     double step,
                                     Map<Double, Double> expectedResult) {
        HashMap<Double, Double> actualResult =
                (HashMap<Double, Double>) functionService.
                        getTangentValues(tangent, rangeStart, rangeEnd, step);
        assertEquals(actualResult, expectedResult);
    }

    @DataProvider(name = "dataForTangentValuesException")
    @Test(groups = "tangentValues")
    public Object[][] dataForTangentValuesException() {
        TangentFunction tangent = new TangentFunction();
        return new Object[][]{
                {tangent, -11, 0, 1},
                {tangent, 13, 15, 0.5},
                {tangent, -14, 12, 1.5}
        };
    }

    @Parameters({"tangentFunction", "rangeStart",
            "rangeEnd", "step"})
    @Test(groups = "tangentValues",
            dataProvider = "dataForTangentValuesException",
            expectedExceptions = NumberFormatException.class)
    public void testGetTangentValuesException(TangentFunction tangent,
                                              double rangeStart,
                                              double rangeEnd,
                                              double step) {
        try {
            functionService.getTangentValues(tangent, rangeStart,
                    rangeEnd, step);
        } catch (NumberFormatException ex) {
            System.out.println(ex);
            throw ex;
        }
    }
}