package tp1.exo2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnagramCorrectionTest {
    @Test
    void testNullInputs() {
        assertThrows(NullPointerException.class, () -> AnagramCorrection.isAnagram(null, "abc"));
        assertThrows(NullPointerException.class, () -> AnagramCorrection.isAnagram("abc", null));
    }

    // Empty strings → sont des anagrammes
    @Test
    void testEmptyStrings() {
        assertTrue(AnagramCorrection.isAnagram("", ""), "Deux chaînes vides sont anagrammes");
    }

    // Longueurs différentes → false
    @Test
    void testDifferentLengths() {
        assertFalse(AnagramCorrection.isAnagram("a", "ab"), "Chaînes de longueurs différentes ne sont pas anagrammes");
    }

    // Anagrammes simples
    @Test
    void testSimpleAnagrams() {
        assertTrue(AnagramCorrection.isAnagram("chien", "niche"));
        assertTrue(AnagramCorrection.isAnagram("rail", "lair"));
    }

    // Non‑anagrammes
    @Test
    void testNonAnagrams() {
        assertFalse(AnagramCorrection.isAnagram("bonjour", "jourbonn"), "Mêmes lettres mais effectif différent");
        assertFalse(AnagramCorrection.isAnagram("test", "tost"));
    }

    // Espaces et casse ignorés
    @Test
    void testWithSpacesAndCase() {
        assertTrue(AnagramCorrection.isAnagram("Listen", "Silent"));
        assertTrue(AnagramCorrection.isAnagram("Conversation", "Voices rant on"));
    }

    // Caractères hors a–z (si on devait les gérer, mais ici on s’en tient à a–z)
    @Test
    void testNonAlphabeticCharacters() {
        // Par construction le code ne gère pas ces cas :
        // on peut vérifier qu'il lève ArrayIndexOutOfBounds
        assertThrows(ArrayIndexOutOfBoundsException.class,
                () -> AnagramCorrection.isAnagram("a1", "1a"));
    }
}