package tp2.ex4;

public class BanqueConcrete implements Banque {
    private int fonds;
    private final int minimum;

    public BanqueConcrete(int fondsInitial, int seuilMinimum) {
        this.fonds = fondsInitial;
        this.minimum = seuilMinimum;
    }

    public void crediter(int somme) {
        fonds += somme;
    }

    public void debiter(int somme) {
        fonds -= somme;
    }

    public boolean est_solvable() {
        return fonds >= minimum;
    }
}
