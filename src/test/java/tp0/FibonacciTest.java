package tp0;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciTest {
    @BeforeEach
    void setUp() {

    }

    @Test
    void testFibonacciOfZero() {
        assertEquals(0, Fibonacci.fibonacci(0), "F(0) doit être 0");
    }
    @Test
    void testFibonacciOfOne() {
        assertEquals(1, Fibonacci.fibonacci(1), "F(1) doit être 1");
    }
    @Test
    void testFibonacciOfSmallNumbers()
    {
        assertEquals(1, Fibonacci.fibonacci(2), "F(2) doit être 1");
        assertEquals(2, Fibonacci.fibonacci(3), "F(3) doit être 2");
        assertEquals(3, Fibonacci.fibonacci(4), "F(4) doit être 3");
        assertEquals(5, Fibonacci.fibonacci(5), "F(5) doit être 5");
    }
    @Test
    void testFibonacciOfLargerNumbers() {
        assertEquals(13, Fibonacci.fibonacci(7), "F(7) doit être 13");
        assertEquals(21, Fibonacci.fibonacci(8), "F(8) doit être 21");
    }
    @Test
    void testFibonacciOfNegativeNumber() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> Fibonacci.fibonacci(-5));
        assertEquals("n must be positive", exception.getMessage(), "Une exception doit être levée pour n < 0");
    }
}