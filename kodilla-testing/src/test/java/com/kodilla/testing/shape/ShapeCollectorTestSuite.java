package com.kodilla.testing.shape;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class ShapeCollectorTestSuite {
    private static int testCounter = 0;

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Testing ShapeCollector class.");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("Testing ShapeCollector finished.");
    }

    @BeforeEach
    public void before() {
        testCounter++;
        System.out.println("Testing case: " + testCounter);
    }

    @Nested
    @DisplayName("Testing add and remove case.")
    class TestAddAndRemove {

        @Test
        void testAddFigure() {
            //Given
            Shape shape = new Circle("Circle", 5.0);
            ShapeCollector shapeCollector = new ShapeCollector();

            //When
            shapeCollector.addFigure(shape);

            //Then
            assertEquals(shape, shapeCollector.getFigure(0));
        }

        @Test
        void testRemoveFigure() {
            //Given
            Shape shape = new Circle("Circle", 5.0);
            ShapeCollector shapeCollector = new ShapeCollector();
            shapeCollector.addFigure(shape);

            //When
            boolean result = shapeCollector.removeFigure(shape);

            //Then
            assertTrue(result);
        }
    }

    @Nested
    @DisplayName("Testing getFigure() and showFigures()")
    class TestDisplayFigures {

        @Test
        void testGetFigure() {
            //Given
            Shape shape = new Square("Square", 10.0);
            ShapeCollector shapeCollector = new ShapeCollector();
            shapeCollector.addFigure(shape);

            //When
            Shape tempShape;
            tempShape = shapeCollector.getFigure(0);

            //Then
            assertEquals(shape, tempShape);
        }

        @Test
        void testShowFigures() {
            //Given
            Shape shape = new Square("Square", 10.0);
            ShapeCollector shapeCollector = new ShapeCollector();
            shapeCollector.addFigure(shape);

            //When
            String result = shapeCollector.showFigures();

            //Then
            assertEquals(shape.getShapeName(), result);
        }
    }
}
