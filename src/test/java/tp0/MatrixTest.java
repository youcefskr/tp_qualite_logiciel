package tp0;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatrixTest {

    @Test
    void testAddvalidMatrix() {
        Matrix a = new Matrix(2);
        Matrix b = new Matrix(2);

        a.set(0, 0, 1); a.set(0, 1, 2);
        a.set(1, 0, 3); a.set(1, 1, 4);

        b.set(0, 0, 5); b.set(0, 1, 6);
        b.set(1, 0, 7); b.set(1, 1, 8);

        a.add(b);

        assertEquals(6,  a.get(0, 0));
        assertEquals(8,  a.get(0, 1));
        assertEquals(10, a.get(1, 0));
        assertEquals(12, a.get(1, 1));
    }
    @Test
    void testAddNullThrows() {
        Matrix a = new Matrix(3);
        assertThrows(NullPointerException.class, () -> a.add(null));
    }
    @Test
    void testAddSizeMismatchThrows() {
        Matrix a = new Matrix(2);
        Matrix b = new Matrix(3);
        assertThrows(IllegalArgumentException.class, () -> a.add(b));
    }
    @Test
    void testMultiplyValidMatrices() {
        Matrix a = new Matrix(2);
        Matrix b = new Matrix(2);

        // a = [1 2; 3 4]
        a.set(0, 0, 1); a.set(0, 1, 2);
        a.set(1, 0, 3); a.set(1, 1, 4);

        // b = [2 0; 1 2]
        b.set(0, 0, 2); b.set(0, 1, 0);
        b.set(1, 0, 1); b.set(1, 1, 2);

        a.multiply(b);

        // résultat attendu = [1*2+2*1, 1*0+2*2; 3*2+4*1, 3*0+4*2] = [4,4;10,8]
        assertEquals(4,  a.get(0, 0));
        assertEquals(4,  a.get(0, 1));
        assertEquals(10, a.get(1, 0));
        assertEquals(8,  a.get(1, 1));
    }

    @Test
    void testMultiplyNullThrows() {
        Matrix a = new Matrix(2);
        assertThrows(NullPointerException.class, () -> a.multiply(null));
    }

    @Test
    void testMultiplySizeMismatchThrows() {
        Matrix a = new Matrix(2);
        Matrix b = new Matrix(3);
        assertThrows(IllegalArgumentException.class, () -> a.multiply(b));
    }

    @Test
    void testTransposeSquareMatrix() {
        Matrix m = new Matrix(3);
        int counter = 1;
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                m.set(i, j, counter++);  // m = [1,2,3;4,5,6;7,8,9]

        m.transpose();

        // résultat attendu = [1,4,7;2,5,8;3,6,9]
        assertEquals(1, m.get(0, 0));
        assertEquals(4, m.get(0, 1));
        assertEquals(7, m.get(0, 2));
        assertEquals(2, m.get(1, 0));
        assertEquals(5, m.get(1, 1));
        assertEquals(8, m.get(1, 2));
        assertEquals(3, m.get(2, 0));
        assertEquals(6, m.get(2, 1));
        assertEquals(9, m.get(2, 2));
    }

    @Test
    void testToStringFormat() {
        Matrix m = new Matrix(2);
        m.set(0, 0, 1);
        m.set(0, 1, 2);
        m.set(1, 0, 3);
        m.set(1, 1, 4);

        String expected =
                "[1, 2]\n" +
                        "[3, 4]\n";

        assertEquals(expected, m.toString());
    }

}