public class Llogari {
    private String ID_Llogari;
    private String ID_Klient;
    private String monedha;
    private int gjendja;
    private Klient pronari;
    private double interesi;
    public Llogari() {

    }

    public Llogari(Klient pronari, String ID_Llogari, String monedha, int gjendja, double interesi) {

        this.ID_Llogari = ID_Llogari;
        this.ID_Klient = pronari.getID_Klient();
        this.monedha = monedha;
        this.gjendja = gjendja;
        this.pronari = pronari;
        this.pronari.addMonedhat(monedha);
        this.interesi = interesi;
        System.out.printf("Llogaria ne %s me gjendje %d e klientit %s %s u regjistrua me sukses.\n", monedha, gjendja, pronari.getEmri(), pronari.getMbiemri());

    }

    public static void terhiq(Llogari llogaria, int sasia) {
        int gj = llogaria.getGjendja();
        String m = llogaria.getMonedha();
        String em = llogaria.pronari.getEmri() + " " + llogaria.pronari.getMbiemri();
        gj -= sasia;
        llogaria.setGjendja(gj);
        System.out.printf("Klienti %s terhoqi %d %s me sukses. Gjendja e mbetur: %d %s.\n", em, sasia, m, gj, m);
    }
    public static void depozito(Llogari llogaria, int sasia) {
        int gj = llogaria.getGjendja();
        String m = llogaria.getMonedha();
        String em = llogaria.pronari.getEmri() + " " + llogaria.pronari.getMbiemri();
        gj += sasia;
        llogaria.setGjendja(gj);
        System.out.printf("Klienti %s depozitoi %d %s me sukses. Gjendja e re: %d %s.\n", em, sasia, m, gj, m);
    }
    public static void transfero(Llogari dh, Llogari m, int sasia, String monedha){
        String dh_em=dh.pronari.getEmri()+" "+dh.pronari.getMbiemri();
        String m_em=m.pronari.getEmri()+" "+m.pronari.getMbiemri();
        dh.setGjendja(dh.getGjendja()-sasia);
        m.setGjendja(m.getGjendja()+sasia);
        System.out.printf("Klienti %s i transferoi klientit %s %d %s me sukses.\n",dh_em,m_em,sasia, monedha);
    }

    public static void perfito(Llogari p){
        p.setGjendja((int) (p.getGjendja()+ (p.getGjendja()*p.getInteresi()/100)));
        System.out.printf("Klienti %s %s perftoi interes ne llogarine ne %s. Gjendja e re: %d\n",
                p.pronari.getEmri(),p.pronari.getMbiemri(), p.getMonedha(),p.getGjendja());
    }

    public Klient getPronari() {
        return pronari;
    }
    public String getID_Llogari() {
        return ID_Llogari;
    }
    public String getID_Klient() {
        return ID_Klient;
    }
    public String getMonedha() {
        return monedha;
    }
    public int getGjendja() {
        return gjendja;
    }
    public double getInteresi() {
        return interesi;
    }
    public void setGjendja(int gjendja) {
        this.gjendja = gjendja;
    }
}

