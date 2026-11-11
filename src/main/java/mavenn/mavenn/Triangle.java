package mavenn.mavenn;

public class Triangle {

    public enum TriangleType {
        EQUILATERAL,
        ISOSCELES,
        SCALENE,
        INVALID
    }

    /**
     * Determines the type of triangle given three side lengths.
     */
    public TriangleType classify(double a, double b, double c) {
        // Validate side lengths
        if (a <= 0 || b <= 0 || c <= 0) {
            return TriangleType.INVALID;
        }

        // Triangle Inequality Theorem
        if (a + b <= c || a + c <= b || b + c <= a) {
            return TriangleType.INVALID;
        }

        // Classify triangle
        if (a == b && b == c) {
            return TriangleType.EQUILATERAL;
        } else if (a == b || b == c || a == c) {
            return TriangleType.ISOSCELES;
        } else {
            return TriangleType.SCALENE;
        }
    }
}