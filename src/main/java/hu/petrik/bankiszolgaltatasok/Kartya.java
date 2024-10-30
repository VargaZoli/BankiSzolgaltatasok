package hu.petrik.bankiszolgaltatasok;

public class Kartya extends BankiSzolgaltatas {
    private final Szamla szamla;
    private final String kartyaszam;

    public Kartya(Tulajdonos tulajdonos, Szamla szamla, String kartyaszam) {
        super(tulajdonos);
        this.szamla = szamla;
        this.kartyaszam = kartyaszam;
    }

    public String getKartyaszam() {
        return kartyaszam;
    }

    public Szamla getSzamla() {
        return szamla;
    }

    public boolean vasarlas(double osszeg) {
        return szamla.kivesz(osszeg);
    }
}
