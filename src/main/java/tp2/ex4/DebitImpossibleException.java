package tp2.ex4;

public class DebitImpossibleException extends Exception {
    public DebitImpossibleException() {
        super("Débit impossible - joueur insolvable");
    }
}
