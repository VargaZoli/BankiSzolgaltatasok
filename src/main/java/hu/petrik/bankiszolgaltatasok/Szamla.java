package hu.petrik.bankiszolgaltatasok;

public abstract class Szamla extends BankiSzolgaltatas {
    protected double egyenleg;

    public Szamla(Tulajdonos tulajdonos) {
        super(tulajdonos);
        this.egyenleg = 0;
    }

    public double getEgyenleg() {
        return egyenleg;
    }

    public void befizet(double osszeg) {
        this.egyenleg += osszeg;
    }


    public abstract boolean kivesz(double osszeg);


    public Kartya ujKartya(String kartyaszam) {
        return new Kartya(this.getTulajdonos(), this, kartyaszam);
    }
}
