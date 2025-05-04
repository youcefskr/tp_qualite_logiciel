package tp2.ex4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class JeuTest {

    @Test
    public void testJeuFermeDeclencheException() {

        Banque banqueMock = mock(Banque.class);
        Jeu jeu = new Jeu(banqueMock);
        jeu.fermer();
        Joueur joueurMock = mock(Joueur.class);
        De de1 = mock(De.class);
        De de2 = mock(De.class);
        assertThrows(JeuFermeException.class, () -> {
            jeu.jouer(joueurMock, de1, de2);
        });
    }

    @Test
    public void testJoueurInsolvableAucunLancer() throws Exception {
        Banque banqueMock = mock(Banque.class);
        Joueur joueurMock = mock(Joueur.class);
        De de1 = mock(De.class), de2 = mock(De.class);
        Jeu jeu = new Jeu(banqueMock);
        when(joueurMock.mise()).thenReturn(100);
        doThrow(new DebitImpossibleException()).when(joueurMock).debiter(100);
        jeu.jouer(joueurMock, de1, de2);
        verify(joueurMock).debiter(100);
        verifyNoInteractions(de1, de2);
        verifyNoInteractions(banqueMock);
    }

    @Test
    public void testGagnantEtBanqueNonSolvableFermeJeu() throws Exception {
        Banque banqueMock = mock(Banque.class);
        Joueur joueurMock = mock(Joueur.class);
        De de1 = mock(De.class), de2 = mock(De.class);

        when(joueurMock.mise()).thenReturn(50);
        when(de1.lancer()).thenReturn(3);
        when(de2.lancer()).thenReturn(4);
        when(banqueMock.est_solvable()).thenReturn(false);

        Jeu jeu = new Jeu(banqueMock);
        jeu.jouer(joueurMock, de1, de2);

        verify(joueurMock).crediter(100);
        assertFalse(jeu.estOuvert());
    }

    @Test
    public void testGagnantAvecBanqueConcreteInsuffisanteFermeJeu() throws Exception {
        BanqueConcrete banque = new BanqueConcrete(80, 100);
        Joueur joueurMock = mock(Joueur.class);
        De de1 = mock(De.class), de2 = mock(De.class);

        when(joueurMock.mise()).thenReturn(40);
        when(de1.lancer()).thenReturn(3);
        when(de2.lancer()).thenReturn(4);
        Jeu jeu = new Jeu(banque);
        jeu.jouer(joueurMock, de1, de2);

        verify(joueurMock).crediter(80);
        assertFalse(jeu.estOuvert());
    }
}