package tp0;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {
    private Stack stack;
    @BeforeEach
    @Test
    void setUp() {
        stack = new Stack();
    }

    @Test
    void testPush() {

        stack.push(45);
        stack.push(42);
        assertEquals(42, stack.peek(), "L'élément au sommet doit être 42 après un push()");
        assertEquals(2, stack.size(), "La taille doit être 1 après un push()");
    }

    @Test
    void testPop() {
        stack.push(55);
        stack.push(42);
        assertEquals(42, stack.pop(), "pop() doit retourner l'élément ajouté (42)");
        assertEquals(1, stack.size(), "La taille doit être 1 après un push()");
    }


    @Test
    void testPeek() {
        stack.push(99);
        stack.push(42);
        assertEquals(42, stack.peek(), "peek() doit retourner l'élément au sommet (42) sans le retirer");
        assertEquals(2, stack.size(), "La taille de la pile ne doit pas changer après un peek()");
    }


    @Test
    void testIsEmpty() {
        stack.push(99);
        stack.pop();
        assertTrue(stack.isEmpty(), "La pile doit être vide après l'initialisation");
    }
    @Test
    void testIsEmptyAfterPush() {
        stack.push(10);
        assertFalse(stack.isEmpty(), "La pile ne doit pas être vide après un push()");
    }
    @Test
    void testSizeStackIsEmpty() {
        assertEquals(0, stack.size(), "La taille doit être 0 après l'initialisation");
    }
    @Test
    void testSizeAfterPush() {
        stack.push(10);
        assertEquals(1, stack.size(), "La taille doit être 1 après un push()");
    }
}