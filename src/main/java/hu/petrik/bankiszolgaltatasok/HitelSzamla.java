package hu.petrik.bankiszolgaltatasok;

public class HitelSzamla extends Szamla {
    private final double hitelkeret;

    public HitelSzamla(Tulajdonos tulajdonos, double hitelkeret) {
        super(tulajdonos);
        this.hitelkeret = hitelkeret;
    }

    public double getHitelkeret() {
        return hitelkeret;
    }

    @Override
    public boolean kivesz(double osszeg) {
        if (this.egyenleg - osszeg >= -hitelkeret) {
            this.egyenleg -= osszeg;
            return true;
        } else {
            return false;
        }
    }
}
