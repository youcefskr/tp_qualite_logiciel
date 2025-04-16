package tp1.exo6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzTestCorrectionTest {
    @Test
    void testFizzBuzz() {
        assertEquals("FizzBuzz", FizzBuzzTestCorrection.fizzBuzz(15));
        assertEquals("FizzBuzz", FizzBuzzTestCorrection.fizzBuzz(30));
    }

    @Test
    void testFizzOnly() {
        assertEquals("Fizz", FizzBuzzTestCorrection.fizzBuzz(3));
        assertEquals("Fizz", FizzBuzzTestCorrection.fizzBuzz(6));
    }

    @Test
    void testBuzzOnly() {
        assertEquals("Buzz", FizzBuzzTestCorrection.fizzBuzz(5));
        assertEquals("Buzz", FizzBuzzTestCorrection.fizzBuzz(10));
    }

    @Test
    void testOtherNumbers() {
        assertEquals("1", FizzBuzzTestCorrection.fizzBuzz(1)); // Ce test échouera car la méthode lance une exception si n <= 1
        assertEquals("2", FizzBuzzTestCorrection.fizzBuzz(2));
        assertEquals("4", FizzBuzzTestCorrection.fizzBuzz(4));
    }

    @Test
    void testInvalidInput() {
        assertThrows(IllegalArgumentException.class, () -> FizzBuzzTestCorrection.fizzBuzz(0));
        assertThrows(IllegalArgumentException.class, () -> FizzBuzzTestCorrection.fizzBuzz(-3));
    }

}