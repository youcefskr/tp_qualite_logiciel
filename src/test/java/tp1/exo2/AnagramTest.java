package tp1.exo2;



import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AnagramTest {

    // Null inputs → exception
    @Test
    void testNullInputs() {
        assertThrows(NullPointerException.class, () -> Anagram.isAnagram(null, "abc"));
        assertThrows(NullPointerException.class, () -> Anagram.isAnagram("abc", null));
    }

    // Empty strings → sont des anagrammes
    @Test
    void testEmptyStrings() {
        assertTrue(Anagram.isAnagram("", ""), "Deux chaînes vides sont anagrammes");
    }

    // Longueurs différentes → false
    @Test
    void testDifferentLengths() {
        assertFalse(Anagram.isAnagram("a", "ab"), "Chaînes de longueurs différentes ne sont pas anagrammes");
    }

    // Anagrammes simples
    @Test
    void testSimpleAnagrams() {
        assertTrue(Anagram.isAnagram("chien", "niche"));
        assertTrue(Anagram.isAnagram("rail", "lair"));
    }

    // Non‑anagrammes
    @Test
    void testNonAnagrams() {
        assertFalse(Anagram.isAnagram("bonjour", "jourbonn"), "Mêmes lettres mais effectif différent");
        assertFalse(Anagram.isAnagram("test", "tost"));
    }

    // Espaces et casse ignorés
    @Test
    void testWithSpacesAndCase() {
        assertTrue(Anagram.isAnagram("Listen", "Silent"));
        assertTrue(Anagram.isAnagram("Conversation", "Voices rant on"));
    }

    // Caractères hors a–z (si on devait les gérer, mais ici on s’en tient à a–z)
    @Test
    void testNonAlphabeticCharacters() {
        // Par construction le code ne gère pas ces cas :
        // on peut vérifier qu'il lève ArrayIndexOutOfBounds
        assertThrows(ArrayIndexOutOfBoundsException.class,
                () -> Anagram.isAnagram("a1", "1a"));
    }
}
