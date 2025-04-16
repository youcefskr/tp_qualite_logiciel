package tp1.exo4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


public class QuadraticEquationTest {

    @Test
    void testNoRealRoots() {
        assertNull(QuadraticEquation.solve(1, 2, 5));
    }

    @Test
    void testOneRealRoot() {
        double[] result = QuadraticEquation.solve(1, 2, 1);
        assertArrayEquals(new double[]{-1.0}, result);
    }

    @Test
    void testTwoRealRoots() {
        double[] result = QuadraticEquation.solve(1, -3, 2);
        assertArrayEquals(new double[]{2.0, 1.0}, result);
    }

    @Test
    void testInvalidAThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> QuadraticEquation.solve(0, 2, 1));
    }
}
