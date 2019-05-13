package com.kodilla.testing.shape;

import org.junit.*;

public class ShapeCollectorTestSuite {
    private static int testCounter = 0;

    @BeforeClass
    public static void beforeAllTests(){
        System.out.println("This is beginning of tests.");
    }

    @AfterClass
    public static void afterAllTests(){
        System.out.println("All tests are finished");
    }

    @Before
    public void beforeEveryTest(){
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @Test
    public void testAddFigure(){
        //Given
        ShapeCollector collector = new ShapeCollector();
        Shape figure = new Circle(1);
        //When
        collector.addFigure(figure);
        //Then
        Assert.assertEquals(1,collector.getFigureQuantity());
    }

    @Test
    public void testRemoveNotExistingShape(){
        //Given
        ShapeCollector collector = new ShapeCollector();
        Shape figure = new Circle(1);
        //When
        boolean result = collector.removeFigure(figure);
        //Then
        Assert.assertFalse(result);
    }

    @Test
    public void testRemoveShape(){
        //Given
        ShapeCollector collector = new ShapeCollector();
        Shape figure = new Circle(1);
        collector.addFigure(figure);
        //When
        boolean result = collector.removeFigure(figure);
        //Then
        Assert.assertTrue(result);
        Assert.assertEquals(0,collector.getFigureQuantity());
    }

    @Test
    public void testGetFigure(){
        //Given
        ShapeCollector collector = new ShapeCollector();
        Shape figure = new Circle(1);
        collector.addFigure(figure);
        //When
        Shape retrievedFigure = collector.getFigure(0);
        //Then
        Assert.assertEquals(figure,retrievedFigure);
    }
}
