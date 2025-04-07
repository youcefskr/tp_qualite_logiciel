package tp1.exo1;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PalindromeTest {
    @Test
    void testNullThrows() {
        assertThrows(NullPointerException.class,
                () -> Palindrome.isPalindrome(null),
                "Une chaîne null doit lever NullPointerException");
    }

    // Cas limite : chaîne vide est considérée comme palindrome
    @Test
    void testEmptyString() {
        assertTrue(Palindrome.isPalindrome(""),
                "La chaîne vide doit être considérée comme palindrome");
    }

    // Cas limite : une seule lettre
    @Test
    void testSingleCharacter() {
        assertTrue(Palindrome.isPalindrome("a"),
                "Une seule lettre doit être palindrome");
    }

    // Palindrome simple (longueur impaire)
    @Test
    void testOddLengthPalindrome() {
        assertTrue(Palindrome.isPalindrome("kayak"),
                "'kayak' est un palindrome");
    }

    // Palindrome simple (longueur paire)
    @Test
    void testEvenLengthPalindrome() {
        assertTrue(Palindrome.isPalindrome("abccba"),
                "'abccba' est un palindrome");
    }

    // Palindrome avec espaces et casse variée
    @Test
    void testPalindromeWithSpacesAndCase() {
        String s = "Esope reste ici et se repose";
        assertTrue(Palindrome.isPalindrome(s),
                "Doit ignorer espaces et majuscules");
    }

    // Non‑palindrome
    @Test
    void testNonPalindrome() {
        assertFalse(Palindrome.isPalindrome("bonjour"),
                "'bonjour' n'est pas un palindrome");
    }
}