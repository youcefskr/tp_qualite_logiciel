package tp2.ex4;

public class JeuFermeException extends RuntimeException {
    public JeuFermeException() {
        super("Le jeu est fermé");
    }
}
