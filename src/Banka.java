import java.util.ArrayList;

public class Banka {
    private ArrayList<Klient> Klientet;
    private ArrayList<Llogari> Llogarite;
    private double[] INTERES = {5.6, 7.5, 3.8, 4.3};

    public Banka() {
        this.Klientet = new ArrayList<>();
        this.Llogarite = new ArrayList<>();
    }

    public void SHTOKLIENT(String ID_Klient, String emri, String mbiemri, int viti_lindjes, String nr_cel) {
        for (Klient c :
                Klientet) {
            if (c.getID_Klient().equals(ID_Klient)) {
                System.out.println("Klienti nuk mund të regjistrohet. ID nuk eshte unike.");
                return;
            }
        }
        if (!nr_cel.startsWith("067") && !nr_cel.startsWith("068") && !nr_cel.startsWith("069") && nr_cel.length() != 10) {
            System.out.println("Klienti nuk mun\nd të regjistrohet. Numri i telefonit nuk eshte i rregullt.");
            return;
        }
        if (!ID_Klient.startsWith("K0") || ID_Klient.length() != 7 || !ID_Klient.endsWith("A")) {
            System.out.println("Klienti nuk mund të regjistrohet. ID nuk eshte e rregullt.");
            return;
        }
        if (viti_lindjes < 1930 || viti_lindjes > 1995) {
            System.out.println("Klienti nuk mund të regjistrohet. Viti i lindjes nuk eshte i rregullt.");
            return;
        }
        Klientet.add(new Klient(ID_Klient, emri, mbiemri, viti_lindjes, nr_cel));
    }

    public void SHTOLLOGARI(String ID_Llogari, String ID_Klient, String monedha, int gjendja) {
        Klient tmp = new Klient();
        double interesi = 0;
        for (Llogari l : Llogarite){
            if (l.getID_Llogari().equals(ID_Llogari)){
                System.out.println("Llogaria nuk mund të regjistrohet. ID nuk eshte unike.");
                return;
            }
        }
        if (!ID_Llogari.startsWith("L0") && ID_Klient.length() != 8 && !ID_Klient.endsWith("Z")) {
            System.out.println("Llogaria nuk mund të regjistrohet. ID nuk eshte e rregullt.");
            return;
        }
        for (Klient c : Klientet) {
            if (c.getID_Klient().equals(ID_Klient)) {
                System.out.println("Llogaria nuk mund të regjistrohet. ID e klientit nuk ekziston.");
                return;
            }
        }
        if (!monedha.equals("ALL") && !monedha.equals("USD") && !monedha.equals("GBP") && !monedha.equals("EUR")) {
            System.out.println("Llogaria nuk mund të regjistrohet. \n" +
                    "Monedha nuk eshte e rregullt.");
            return;
        }
        if (gjendja < 0) {
            System.out.println("Llogaria nuk mund të regjistrohet. \n" +
                    "Gjendja nuk mund te jete negative.");
            return;
        }
        if (tmp.getMonedhat().contains(monedha)) {
            System.out.println("Llogaria nuk mund të regjistrohet. Klienti nuk mund te kete me shume se nje llogari me te njejten monedhe.");
        }
        switch (monedha) {
            case "USD" -> interesi = INTERES[0];
            case "ALL" -> interesi = INTERES[1];
            case "GBP" -> interesi = INTERES[2];
            case "EUR" -> interesi = INTERES[3];
        }
        Llogarite.add(new Llogari(tmp, ID_Llogari, monedha, gjendja, interesi));
    }

    public void TERHIQ(String ID_Llogari, int sasia) {
        Llogari tmp = new Llogari();
        for (Llogari l : Llogarite) {
            if (l.getID_Llogari().equals(ID_Llogari)) {
                tmp = l;
            }
        }
        if (tmp.getID_Klient() == null) {
            System.out.println("Terheqja nuk mund te kryhet. ID e llogarise nuk ekziston.");
            return;
        }
        if (tmp.getGjendja() < sasia) {
            System.out.println("Terheqja nuk mund te kryhet. Gjendja nuk eshte e mjaftueshme.");
            return;
        }
        if (sasia < 0) {
            System.out.println("Terheqja nuk mund te kryhet. Sasia nuk mund te jete negative.");
            return;
        }
        Llogari.terhiq(tmp, sasia);
    }

    public void DEPOZITO(String ID_Llogari, int sasia) {
        Llogari tmp = new Llogari();
        for (Llogari l : Llogarite) {
            if (l.getID_Llogari().equals(ID_Llogari)) {
                Llogari.depozito(l, sasia);
                return;
            }
        }
        if (tmp.getID_Klient() == null) {
            System.out.println("Depozitimi nuk mund te kryhet. ID e llogarise nuk ekziston.");
            return;
        }
        if (sasia < 0) {
            System.out.println("Depozitimi nuk mund te kryhet. Sasia nuk mund te jete negative.");

        }

    }

    public void TRANSFERO(String ID_D, String ID_M, int sasia) {
        Llogari dh = new Llogari();
        Llogari m = new Llogari();
        for (Llogari l :
                Llogarite) {
            if (ID_D.equals(l.getID_Llogari())) {
                dh = l;
                continue;
            }
            if (ID_M.equals(l.getID_Llogari())) {
                m = l;
            }
        }
        if (dh.getID_Llogari() == null) {
            System.out.println("Transferta nuk mund te kryhet. ID e llogarise transferuese nuk ekziston.");
            return;
        }
        if (m.getID_Llogari() == null) {
            System.out.println("Transferta nuk mund te kryhet. ID e llogarise pritese nuk ekziston.");
            return;
        }
        if (!dh.getMonedha().equals(m.getMonedha())) {
            System.out.println("Transferta nuk mund te kryhet. Llogarite nuk jane ne te njejten monedhe.");
            return;
        }
        if (dh.getGjendja() < sasia) {
            System.out.println("Transferta nuk mund te kryhet. Gjendja e llogarise transferuese nuk mjafton.");
            return;
        }
        String monedha = dh.getMonedha();
        Llogari.transfero(dh, m, sasia, monedha);
    }

    public void PERFITOINTERES(String ID_Llogari) {
        for (Llogari l :
                Llogarite) {
            if (ID_Llogari.equals(l.getID_Llogari())) {
                Llogari.perfito(l);
                return;
            }
        }
        System.out.println("Interesi nuk mund te perfitohet. ID e llogarise nuk ekziston.");
    }

    public void NDRYSHOINTERES(String monedha, double x) {
        switch (monedha) {
            case "USD" -> INTERES[0] = x;
            case "ALL" -> INTERES[1] = x;
            case "GBP" -> INTERES[2] = x;
            case "EUR" -> INTERES[3] = x;
            default -> System.out.println("Interesi nuk mund te ndryshohet. Monedha nuk eshte e rregullt.");
        }
        if (x <= 0 || x >= 20) {
            System.out.println("Interesi nuk mund te ndryshohet. Vlera e re nuk eshte e pranueshme.");
            return;
        }
        System.out.printf("Interesi i monedhes %s u be %f%%", monedha, x);
    }

    public void LISTOKLIENTET() {
        int i = 1;
        System.out.print("""
                =====================
                  Lista e klienteve
                =====================
                """);
        for (Klient c :
                Klientet) {
            System.out.printf("\n[Klienti %d]\n", i);
            System.out.printf("%s %s\n%d\n%s", c.getEmri(), c.getMbiemri(), c.getViti_lindjes(), c.getNr_cel());
            int j = 1;
            for (Llogari l : Llogarite) {
                if (l.getPronari() == c) {
                    System.out.printf("\n\t[Llogari %d]\n\t%s\n\t%s\n\t%d", j, l.getID_Llogari(), l.getMonedha(), l.getGjendja());
                    j++;
                }
            }
            i++;
        }
    }

    public void FSHIJKLIENT(String ID_Klienti) {
        for (Klient c : Klientet) {
            if (ID_Klienti.equals(c.getID_Klient())) {
                if (c.getMonedhat().isEmpty()) {
                    System.out.printf("Klienti %s %s u fshi me sukses.", c.getEmri(), c.getMbiemri());
                    Klientet.remove(c);
                    return;
                }
                System.out.println("Klienti nuk mund te fshihet. Ai ka llogari te hapura.");
            }
        }
        System.out.println("Klienti nuk mund te fshihet. ID nuk ekziston.");
    }

    public void FSHIJLLOGARI(String ID_Llogari) {
        for (Llogari l : Llogarite) {
            if (ID_Llogari.equals(l.getID_Llogari())) {
                if (l.getGjendja() == 0) {
                    System.out.printf("Llogaria ne %s e klientit %s %s u fshi me sukses.",
                            l.getMonedha(), l.getPronari().getEmri(), l.getPronari().getMbiemri());
                    Llogarite.remove(l);
                    return;
                }
                System.out.println("Llogaria nuk mund te fshihet. Gjendja nuk eshte zero.");
            }
        }
        System.out.println("Llogaria nuk mund te fshihet. ID nuk ekziston.");
    }
}
