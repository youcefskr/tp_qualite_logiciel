package tp1.exo5;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class RomanNumeralCorrectionTest {






    @Test
    void testSimpleNumbers() {
        assertEquals("I", RomanNumeralCorrection.toRoman(1));
        assertEquals("II", RomanNumeralCorrection.toRoman(2));
        assertEquals("III", RomanNumeralCorrection.toRoman(3));
        assertEquals("V", RomanNumeralCorrection.toRoman(5));
        assertEquals("X", RomanNumeralCorrection.toRoman(10));
    }

    @Test
    void testSubtractiveNotation() {
        assertEquals("IV", RomanNumeralCorrection.toRoman(4));
        assertEquals("IX", RomanNumeralCorrection.toRoman(9));
        assertEquals("XL", RomanNumeralCorrection.toRoman(40));
        assertEquals("XC", RomanNumeralCorrection.toRoman(90));
        assertEquals("CD", RomanNumeralCorrection.toRoman(400));
        assertEquals("CM", RomanNumeralCorrection.toRoman(900));
    }

    @Test
    void testComplexNumbers() {
        assertEquals("MCMXCIV", RomanNumeralCorrection.toRoman(1994));
        assertEquals("MMXXIV", RomanNumeralCorrection.toRoman(2024));
        assertEquals("MMMCMXCIX", RomanNumeralCorrection.toRoman(3999));
    }

    @Test
    void testInvalidLowValue() {
        assertThrows(IllegalArgumentException.class, () -> RomanNumeralCorrection.toRoman(0));
        assertThrows(IllegalArgumentException.class, () -> RomanNumeralCorrection.toRoman(-5));
    }

    @Test
    void testInvalidHighValue() {
        assertThrows(IllegalArgumentException.class, () -> RomanNumeralCorrection.toRoman(4000));
    }
}
