package tp2.ex4;

public class Jeu {
    private Banque banque;
    private boolean ouvert = true;

    public Jeu(Banque banque) {
        this.banque = banque;
    }

    public void jouer(Joueur joueur, De de1, De de2) throws JeuFermeException {
        if (!ouvert) throw new JeuFermeException();

        int mise = joueur.mise();
        try {
            joueur.debiter(mise);
        } catch (DebitImpossibleException e) {
            return;
        }

        banque.crediter(mise);
        int score = de1.lancer() + de2.lancer();

        if (score == 7) {
            int gain = 2 * mise;
            joueur.crediter(gain);
            banque.debiter(gain);

            if (!banque.est_solvable()) {
                fermer();
            }
        }
    }

    public void fermer() {
        ouvert = false;
    }

    public boolean estOuvert() {
        return ouvert;
    }
}
