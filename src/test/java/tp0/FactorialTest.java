package tp0;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FactorialTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void testFactorialOfZero() {
        assertEquals(1, Factorial.factorial(0), "0! doit être égal à 1");
    }
    @Test
    void testFactorialOfOne() {
        assertEquals(1, Factorial.factorial(1), "1! doit être égal à 1");
    }

    @Test
    void testFactorialOfSmallNumbers() {
        assertEquals(2, Factorial.factorial(2), "2! doit être égal à 2");
        assertEquals(6, Factorial.factorial(3), "3! doit être égal à 6");
        assertEquals(24, Factorial.factorial(4), "4! doit être égal à 24");
        assertEquals(120, Factorial.factorial(5), "5! doit être égal à 120");
    }
    @Test
    void testFactorialOfLargeNumber() {
        assertEquals(3628800, Factorial.factorial(10), "10! doit être égal à 3 628 800");
    }

    @Test
    void testFactorialWithNegativeNumber() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> Factorial.factorial(-5));
        assertEquals("n must be positive", exception.getMessage(), "Une exception doit être levée pour n < 0");
    }
}