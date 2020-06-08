package test.kharitonov.lesson1.service;

import com.kharitonov.lesson1.entity.Circle;
import com.kharitonov.lesson1.entity.Square;
import com.kharitonov.lesson1.exception.TaskException;
import com.kharitonov.lesson1.service.ShapeService;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class ShapeServiceTest {
    private ShapeService shapeService;

    @BeforeTest(description = "shapeService initialization")
    private void init() {
        shapeService = new ShapeService();
    }

    @DataProvider(name = "dataForGetSquareSide")
    @Test(groups = "squareSide")
    public Object[][] dataForGetSquareSide() {
        return new Object[][]{
                {4, 2},
                {1.21, 1.1},
                {2.25, 1.5},
                {100, 10}
        };
    }

    @Parameters({"area", "expectedSide"})
    @Test(dataProvider = "dataForGetSquareSide",
            groups = "squareSide")
    public void testGetSquareSide(double area, double expectedSide) {
        try {
            double actualSide = shapeService.getSquareSide(area);
            assertEquals(actualSide, expectedSide, 0.0001);
        } catch (TaskException e) {
            System.out.println(e);
        }
    }

    @DataProvider(name = "dataForGetSquareSideException")
    @Test(groups = "squareSide")
    public Object[][] dataForGetSquareSideException() {
        return new Object[][]{
                {-4},
                {-1.21},
                {-2.25},
                {-100}
        };
    }

    @Parameters({"area"})
    @Test(dataProvider = "dataForGetSquareSideException", groups = "squareSide",
            expectedExceptions = AssertionError.class)
    public void testGetSquareSideException(double area) {
        try {
            shapeService.getSquareSide(area);
        } catch (TaskException ex) {
            System.out.println(ex);
            fail();
        }
    }

    @DataProvider(name = "dataForGetSquareScale")
    @Test(groups = "squareScale")
    public Object[][] dataForGetSquareScale() {
        return new Object[][]{
                {new Square(4), new Square(2), 4},
                {new Square(9.99), new Square(3.33), 9},
                {new Square(44.44), new Square(11.11), 16},
                {new Square(55), new Square(11), 25}
        };
    }

    @Parameters({"firstSquare", "secondSquare", "expectedScale"})
    @Test(dataProvider = "dataForGetSquareScale", groups = "squareScale")
    public void testGetSquareScale(Square firstSquare,
                                   Square secondSquare,
                                   double expectedScale) {
        try {
            double actualScale = shapeService.getSquareScale(firstSquare,
                    secondSquare);
            assertEquals(actualScale, expectedScale, 0.0001);
        } catch (TaskException e) {
            System.out.println(e);
        }
    }

    @DataProvider(name = "dataForGetSquareScaleException")
    @Test(groups = "squareScale")
    public Object[][] dataForGetSquareScaleException() {
        return new Object[][]{
                {new Square(-4), new Square(2)},
                {new Square(9.99), new Square(-3.33)},
                {new Square(-44.44), new Square(-11.11)},
                {new Square(0), new Square(11)}
        };
    }

    @Parameters({"firstSquare", "secondSquare"})
    @Test(dataProvider = "dataForGetSquareScaleException",
            groups = "squareScale",
            expectedExceptions = AssertionError.class)
    public void testGetSquareScaleException(Square firstSquare,
                                            Square secondSquare) {
        try {
            shapeService.getSquareScale(firstSquare,
                    secondSquare);
        } catch (TaskException ex) {
            System.out.println(ex);
            fail();
        }
    }

    @DataProvider(name = "dataForGetInscribedCircle")
    @Test(groups = "inscribedCircle")
    public Object[][] dataForInscribedCircle() {
        return new Object[][]{
                {new Square(4), new Circle(2)},
                {new Square(10.2), new Circle(5.1)},
                {new Square(40.4), new Circle(20.2)},
                {new Square(100.6), new Circle(50.3)}
        };
    }

    @Parameters({"square", "expectedCircle"})
    @Test(dataProvider = "dataForInscribedCircle", groups = "inscribedCircle")
    public void testGetInscribedCircle(Square square, Circle expectedCircle) {
        try {
            Circle actualCircle = shapeService.getInscribedCircle(square);
            assertEquals(actualCircle, expectedCircle);
        } catch (TaskException e) {
            System.out.println(e);
        }
    }

    @DataProvider(name = "dataForGetInscribedCircleException")
    @Test(groups = "inscribedCircle")
    public Object[][] dataForGetInscribedCircleException() {
        return new Object[][]{
                {new Square(-4)},
                {new Square(-10.2)},
                {new Square(-40.4)},
                {new Square(0)}
        };
    }

    @Parameters({"square"})
    @Test(dataProvider = "dataForGetInscribedCircleException",
            groups = "inscribedCircle",
            expectedExceptions = AssertionError.class)
    public void testGetInscribedCircleException(Square square) {
        try {
            shapeService.getInscribedCircle(square);
        } catch (TaskException ex) {
            System.out.println(ex);
            fail();
        }
    }

    @DataProvider(name = "dataForGetInscribedSquare")
    @Test(groups = "inscribedSquare")
    public Object[][] dataForGetInscribedSquare() {
        double coeff = 2 / Math.sqrt(2);
        return new Object[][]{
                {new Circle(25), new Square(25 * coeff)},
                {new Circle(1), new Square(coeff)},
                {new Circle(Math.sqrt(2)), new Square(2)},
                {new Circle(10), new Square(10 * coeff)}
        };
    }

    @Parameters({"circle", "expectedSquare"})
    @Test(groups = "inscribedSquare",
            dataProvider = "dataForGetInscribedSquare")
    public void testGetInscribedSquare(Circle circle, Square expectedSquare) {
        try {
            Square actualSquare = shapeService.getInscribedSquare(circle);
            assertEquals(actualSquare, expectedSquare);
        } catch (TaskException e) {
            System.out.println(e);
        }
    }

    @DataProvider(name = "dataForGetInscribedSquareException")
    @Test(groups = "inscribedSquare")
    public Object[][] dataForGetInscribedSquareException() {
        return new Object[][]{
                {new Circle(-25)},
                {new Circle(-1)},
                {new Circle(-Math.sqrt(2))},
                {new Circle(0)}
        };
    }

    @Parameters({"circle"})
    @Test(groups = "inscribedSquare",
            dataProvider = "dataForGetInscribedSquareException",
            expectedExceptions = AssertionError.class)
    public void testGetInscribedSquareException(Circle circle) {
        try {
            shapeService.getInscribedSquare(circle);
        } catch (TaskException ex) {
            System.out.println(ex);
            fail();
        }
    }

    @DataProvider(name = "dataForGetCircleArea")
    @Test(groups = "circleArea")
    public Object[][] dataForGetCircleArea() {
        return new Object[][]{
                {new Circle(2), Math.PI * 4},
                {new Circle(11), Math.PI * 121},
                {new Circle(25), Math.PI * 625},
                {new Circle(1), Math.PI}
        };
    }

    @Parameters({"circle", "expectedArea"})
    @Test(dataProvider = "dataForGetCircleArea", groups = "circleArea")
    public void testGetCircleArea(Circle circle, double expectedArea) {
        try {
            double actualArea = shapeService.getCircleArea(circle);
            assertEquals(actualArea, expectedArea, 0.0001);
        } catch (TaskException e) {
            System.out.println(e);
        }
    }

    @DataProvider(name = "dataForGetCircleAreaException")
    @Test(groups = "circleArea")
    public Object[][] dataForGetCircleAreaException() {
        return new Object[][]{
                {new Circle(-2)},
                {new Circle(0)},
                {new Circle(-25)},
                {new Circle(-1)}
        };
    }

    @Parameters({"circle"})
    @Test(dataProvider = "dataForGetCircleAreaException",
            groups = "circleArea",
            expectedExceptions = AssertionError.class)
    public void testGetCircleAreaException(Circle circle) {
        try {
            shapeService.getCircleArea(circle);
        } catch (TaskException ex) {
            System.out.println(ex);
            fail();
        }
    }

    @DataProvider(name = "dataForGetCircumference")
    @Test(groups = "circumference")
    public Object[][] dataForGetCircumference() {
        return new Object[][]{
                {new Circle(1), 2 * Math.PI},
                {new Circle(10), 20 * Math.PI},
                {new Circle(25), 50 * Math.PI},
                {new Circle(100), 200 * Math.PI}
        };
    }

    @Parameters({"circle", "expectedCircumference"})
    @Test(dataProvider = "dataForGetCircumference", groups = "circumference")
    public void testGetCircumference(Circle circle,
                                     double expectedCircumference) {
        try {
            double actualCircumference = shapeService.getCircumference(circle);
            assertEquals(actualCircumference, expectedCircumference,
                    0.0001);
        } catch (TaskException e) {
            System.out.println(e);
        }
    }

    @DataProvider(name = "dataForGetCircumferenceException")
    @Test(groups = "circumference")
    public Object[][] dataForGetCircumferenceException() {
        return new Object[][]{
                {new Circle(-1)},
                {new Circle(0)},
                {new Circle(-25)},
                {new Circle(-125.31)}
        };
    }

    @Parameters({"circle"})
    @Test(dataProvider = "dataForGetCircumferenceException",
            groups = "circumference",
            expectedExceptions = AssertionError.class)
    public void testGetCircumferenceException(Circle circle) {
        try {
            shapeService.getCircumference(circle);
        } catch (TaskException ex) {
            System.out.println(ex);
            fail();
        }
    }
}