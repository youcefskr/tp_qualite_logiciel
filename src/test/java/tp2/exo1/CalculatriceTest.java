package tp2.exo1;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class CalculatriceTest {

    @Mock
    private Calculatrice calculatrice;

    @Test
    public void testAdditionner() {
        when(calculatrice.additionner(2, 3)).thenReturn(5);
        int resultat = calculatrice.additionner(2, 3);
        assertEquals(5, resultat);
        verify(calculatrice).additionner(2, 3);
        verifyNoMoreInteractions(calculatrice);


    }
}
