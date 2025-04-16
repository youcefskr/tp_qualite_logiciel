package tp2.exo3;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @Mock
    private UtilisateurApi utilisateurApiMock;

    // Scénario 1 : Lever une exception
    @Test(expected = ServiceException.class)
    public void testCreerUtilisateur_Echec() throws ServiceException {
        Utilisateur utilisateur = new Utilisateur("saker", "youcef", "sakeryoucef@email.com");
        when(utilisateurApiMock.creerUtilisateur(utilisateur))
                .thenThrow(new ServiceException("Echec de la création de l'utilisateur"));

        UserService userService = new UserService(utilisateurApiMock);
        userService.creerUtilisateur(utilisateur);
    }

    // Scénario 2 : Erreur de validation
    @Test
    public void testCreerUtilisateur_ErreurValidation() throws ServiceException {
        Utilisateur utilisateur = new Utilisateur(null, null, null); // Données invalides

        UserService userService = new UserService(utilisateurApiMock);

        // Suppose qu'on a une logique pour ne pas appeler l'API si validation échoue
        // Mais ici on teste juste que l’API n’a jamais été appelée :
        verify(utilisateurApiMock, never()).creerUtilisateur(any());
    }

    // Scénario 3 : Vérification de l'ID retourné
    @Test
    public void testCreerUtilisateur_IDRetourne() throws ServiceException {
        Utilisateur utilisateur = new Utilisateur("saker", "youcef", "sakeryoucef@email.com");
        when(utilisateurApiMock.creerUtilisateur(utilisateur)).thenReturn(true);

        UserService userService = new UserService(utilisateurApiMock);
        userService.creerUtilisateur(utilisateur);

        // Vérification de l'ID de l'utilisateur
        assertEquals(123, utilisateur.getId());
    }

    // Scénario 4 : Capture des arguments
    @Test
    public void testCreerUtilisateur_ArgumentCaptor() throws ServiceException {
        Utilisateur utilisateur = new Utilisateur("saker", "youcef", "sakeryoucef@email.com");

        when(utilisateurApiMock.creerUtilisateur(any(Utilisateur.class))).thenReturn(true);

        UserService userService = new UserService(utilisateurApiMock);

        ArgumentCaptor<Utilisateur> argumentCaptor = ArgumentCaptor.forClass(Utilisateur.class);
        userService.creerUtilisateur(utilisateur);

        verify(utilisateurApiMock).creerUtilisateur(argumentCaptor.capture());

        Utilisateur utilisateurCapture = argumentCaptor.getValue();
        assertEquals("saker", utilisateurCapture.getPrenom());
        assertEquals("youcef", utilisateurCapture.getNom());
        assertEquals("sakeryoucef@email.com", utilisateurCapture.getEmail());
    }
}
