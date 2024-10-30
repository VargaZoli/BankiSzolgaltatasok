package hu.petrik.bankiszolgaltatasok;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Szamla> szamlak = new ArrayList<>();

    public Szamla szamlaNyitas(Tulajdonos tulajdonos, double hitelkeret) {
        if (hitelkeret < 0) {
            throw new IllegalArgumentException("A hitelkeret nem lehet negatív!");
        }

        Szamla szamla;
        if (hitelkeret == 0) {
            szamla = new MegtakaritasiSzamla(tulajdonos);
        } else {
            szamla = new HitelSzamla(tulajdonos, hitelkeret);
        }

        szamlak.add(szamla);
        return szamla;
    }

    public double getOsszEgyenleg(Tulajdonos tulajdonos) {
        return szamlak.stream()
                .filter(s -> s.getTulajdonos().equals(tulajdonos))
                .mapToDouble(Szamla::getEgyenleg)
                .sum();
    }

    public Szamla getLegnagyobbEgyenleguSzamla(Tulajdonos tulajdonos) {
        return szamlak.stream()
                .filter(s -> s.getTulajdonos().equals(tulajdonos))
                .max((s1, s2) -> Double.compare(s1.getEgyenleg(), s2.getEgyenleg()))
                .orElse(null);
    }

    public double getOsszHitelkeret() {
        return szamlak.stream()
                .filter(s -> s instanceof HitelSzamla)
                .mapToDouble(s -> ((HitelSzamla) s).getHitelkeret())
                .sum();
    }
}
