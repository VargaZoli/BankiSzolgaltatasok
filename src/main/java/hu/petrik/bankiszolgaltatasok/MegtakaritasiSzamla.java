package hu.petrik.bankiszolgaltatasok;

public class MegtakaritasiSzamla extends Szamla {
    private double kamat;
    private static double alapKamat = 1.1;

    public MegtakaritasiSzamla(Tulajdonos tulajdonos) {
        super(tulajdonos);
        this.kamat = alapKamat;
    }

    public double getKamat() {
        return kamat;
    }

    public void setKamat(double kamat) {
        this.kamat = kamat;
    }

    public static double getAlapKamat() {
        return alapKamat;
    }

    public static void setAlapKamat(double alapKamat) {
        MegtakaritasiSzamla.alapKamat = alapKamat;
    }

    @Override
    public boolean kivesz(double osszeg) {
        if (this.egyenleg - osszeg >= 0) {
            this.egyenleg -= osszeg;
            return true;
        } else {
            return false;
        }
    }

    public void kamatJovaIras() {
        this.egyenleg *= this.kamat;
    }
}
