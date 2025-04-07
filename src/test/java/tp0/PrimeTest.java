package tp0;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrimeTest {
    @Test
    void testIsPrimeWithPrimeNumbers()
    {
        assertTrue(Prime.isPrime(2), "2 doit être un nombre premier");
        assertTrue(Prime.isPrime(5), "5 doit être un nombre premier");
        assertTrue(Prime.isPrime(11), "5 doit être un nombre premier");
    }
    @Test
    void testIsPrimeWithNonPrimeNumbers() {
        assertFalse(Prime.isPrime(0), "0 n'est pas un nombre premier");
        assertFalse(Prime.isPrime(1), "1 n'est pas un nombre premier");
        assertFalse(Prime.isPrime(4), "4 n'est pas un nombre premier");
        assertFalse(Prime.isPrime(6), "6 n'est pas un nombre premier");
        assertFalse(Prime.isPrime(9), "9 n'est pas un nombre premier");
    }
    @Test
    void testIsPrimeWithNegativeNumbers() {
        assertFalse(Prime.isPrime(-1), "-1 n'est pas un nombre premier");
        assertFalse(Prime.isPrime(-5), "-5 n'est pas un nombre premier");
        assertFalse(Prime.isPrime(-10), "-10 n'est pas un nombre premier");
    }
    @Test
    void testIsPrimeWithLargePrimeNumber() {
        assertTrue(Prime.isPrime(97), "97 doit être un nombre premier");
    }

    @Test
    void testIsPrimeWithLargeNonPrimeNumber() {
        assertFalse(Prime.isPrime(100), "100 n'est pas un nombre premier");
    }

}