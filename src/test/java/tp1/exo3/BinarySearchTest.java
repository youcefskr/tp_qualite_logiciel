package tp1.exo3;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class BinarySearchTest {

    @Test
    void testNullArray() {
        assertThrows(NullPointerException.class, () -> BinarySearch.binarySearch(null, 5));
    }

    @Test
    void testEmptyArray() {
        assertEquals(-1, BinarySearch.binarySearch(new int[]{}, 5));
    }

    @Test
    void testSingleElementFound() {
        assertEquals(0, BinarySearch.binarySearch(new int[]{10}, 10));
    }

    @Test
    void testSingleElementNotFound() {
        assertEquals(-1, BinarySearch.binarySearch(new int[]{10}, 5));
    }

    @Test
    void testMultipleElementsFoundMiddle() {
        assertEquals(2, BinarySearch.binarySearch(new int[]{1, 3, 5, 7, 9}, 5));
    }

    @Test
    void testMultipleElementsFoundFirst() {
        assertEquals(0, BinarySearch.binarySearch(new int[]{1, 3, 5, 7, 9}, 1));
    }

    @Test
    void testMultipleElementsFoundLast() {
        assertEquals(4, BinarySearch.binarySearch(new int[]{1, 3, 5, 7, 9}, 9));
    }

    @Test
    void testNotFoundElement() {
        assertEquals(-1, BinarySearch.binarySearch(new int[]{1, 3, 5, 7, 9}, 6));
    }
}
