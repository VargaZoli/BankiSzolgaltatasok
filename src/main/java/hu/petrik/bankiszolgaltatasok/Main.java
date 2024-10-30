package hu.petrik.bankiszolgaltatasok;

public class Main {
    public static void main(String[] args) {
        Tulajdonos tulajdonos = new Tulajdonos("Teszt Elek");
        Bank bank = new Bank();

        Szamla megtakaritasiSzamla = bank.szamlaNyitas(tulajdonos, 0);
        megtakaritasiSzamla.befizet(10000);

        Szamla hitelSzamla = bank.szamlaNyitas(tulajdonos, 50000);
        hitelSzamla.befizet(20000);

        System.out.println("Össz egyenleg: " + bank.getOsszEgyenleg(tulajdonos));
        System.out.println("Legnagyobb egyenlegű számla: " + bank.getLegnagyobbEgyenleguSzamla(tulajdonos).getEgyenleg());
        System.out.println("Össz hitelkeret: " + bank.getOsszHitelkeret());
    }
}
