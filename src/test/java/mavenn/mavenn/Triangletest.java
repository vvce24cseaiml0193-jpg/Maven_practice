package mavenn.mavenn;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Triangletest {

    private Triangle triangle;

    @BeforeEach
    void setUp() {
        triangle = new Triangle();
    }

    @Test
    void testEquilateralTriangle() {
        assertEquals(Triangle.TriangleType.EQUILATERAL, triangle.classify(5, 5, 5));
    }

    @Test
    void testIsoscelesTriangle() {
        assertEquals(Triangle.TriangleType.ISOSCELES, triangle.classify(5, 5, 3));
        assertEquals(Triangle.TriangleType.ISOSCELES, triangle.classify(5, 3, 5));
        assertEquals(Triangle.TriangleType.ISOSCELES, triangle.classify(3, 5, 5));
    }

    @Test
    void testScaleneTriangle() {
        assertEquals(Triangle.TriangleType.SCALENE, triangle.classify(3, 4, 5));
    }

    @ParameterizedTest
    @CsvSource({
        "0, 4, 5",      // Zero side
        "-1, 4, 5",     // Negative side
        "1, 2, 3",      // Degenerate triangle (a + b = c)
        "1, 2, 4",      // Violation of triangle inequality (a + b < c)
        "10, 2, 3"      // Violation of triangle inequality
    })
    void testInvalidTriangles(double a, double b, double c) {
        assertEquals(Triangle.TriangleType.INVALID, triangle.classify(a, b, c));
    }
}