package tp2.exo3;


public class UserService {
    private final UtilisateurApi utilisateurApi;

    public UserService(UtilisateurApi utilisateurApi) {
        this.utilisateurApi = utilisateurApi;
    }

    public void creerUtilisateur(Utilisateur utilisateur) throws ServiceException {
        boolean success = utilisateurApi.creerUtilisateur(utilisateur);
        if (success) {
            utilisateur.setId(123); // Simulons que l’API renvoie l’ID 123
        }
    }
}
