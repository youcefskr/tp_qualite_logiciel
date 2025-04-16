package tp1.exo1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class PalindromeCorrectionTest {

    @Test
    void testNullThrows() {
        assertThrows(NullPointerException.class,
                () -> PalindromeCorrection.isPalindrome(null),
                "Une chaîne null doit lever NullPointerException");
    }


    @Test
    void testEmptyString() {
        assertTrue(PalindromeCorrection.isPalindrome(""),
                "La chaîne vide doit être considérée comme palindrome");
    }


    @Test
    void testSingleCharacter() {
        assertTrue(PalindromeCorrection.isPalindrome("a"),
                "Une seule lettre doit être palindrome");
    }


    @Test
    void testOddLengthPalindrome() {
        assertTrue(PalindromeCorrection.isPalindrome("kayak"),
                "'kayak' est un palindrome");
    }


    @Test
    void testEvenLengthPalindrome() {
        assertTrue(PalindromeCorrection.isPalindrome("abccba"),
                "'abccba' est un palindrome");
    }


    @Test
    void testPalindromeWithSpacesAndCase() {
        String s = "Esope reste ici et se repose";
        assertTrue(PalindromeCorrection.isPalindrome(s),
                "Doit ignorer espaces et majuscules");
    }


    @Test
    void testNonPalindrome() {
        assertFalse(PalindromeCorrection.isPalindrome("bonjour"),
                "'bonjour' n'est pas un palindrome");
    }
}