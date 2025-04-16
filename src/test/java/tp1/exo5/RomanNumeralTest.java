package tp1.exo5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RomanNumeralTest {

    @Test
    void testSimpleNumbers() {
        assertEquals("I", RomanNumeral.toRoman(1));
        assertEquals("II", RomanNumeral.toRoman(2));
        assertEquals("III", RomanNumeral.toRoman(3));
        assertEquals("V", RomanNumeral.toRoman(5));
        assertEquals("X", RomanNumeral.toRoman(10));
    }

    @Test
    void testSubtractiveNotation() {
        assertEquals("IV", RomanNumeral.toRoman(4));
        assertEquals("IX", RomanNumeral.toRoman(9));
        assertEquals("XL", RomanNumeral.toRoman(40));
        assertEquals("XC", RomanNumeral.toRoman(90));
        assertEquals("CD", RomanNumeral.toRoman(400));
        assertEquals("CM", RomanNumeral.toRoman(900));
    }

    @Test
    void testComplexNumbers() {
        assertEquals("MCMXCIV", RomanNumeral.toRoman(1994));
        assertEquals("MMXXIV", RomanNumeral.toRoman(2024));
        assertEquals("MMMCMXCIX", RomanNumeral.toRoman(3999));
    }

    @Test
    void testInvalidLowValue() {
        assertThrows(IllegalArgumentException.class, () -> RomanNumeral.toRoman(0));
        assertThrows(IllegalArgumentException.class, () -> RomanNumeral.toRoman(-5));
    }

    @Test
    void testInvalidHighValue() {
        assertThrows(IllegalArgumentException.class, () -> RomanNumeral.toRoman(4000));
    }
}
