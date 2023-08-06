import java.util.ArrayList;

public class Klient {
    private String ID_Klient;
    private String emri;
    private String mbiemri;
    private int viti_lindjes;
    private String nr_cel;
    private ArrayList<String> monedhat = new ArrayList<>();

    public Klient() {
    }

    public Klient(String ID_Klient, String emri, String mbiemri, int viti_lindjes, String nr_cel) {
        this.ID_Klient = ID_Klient;
        this.emri = emri;
        this.mbiemri = mbiemri;
        this.viti_lindjes = viti_lindjes;
        this.nr_cel = nr_cel;
        System.out.printf("Klienti %s %s u regjistrua me sukses.\n", emri, mbiemri);


    }

    public String getID_Klient() {
        return ID_Klient;
    }

    public String getEmri() {
        return emri;
    }

    public String getMbiemri() {
        return mbiemri;
    }

    public ArrayList<String> getMonedhat() {
        return monedhat;
    }

    public int getViti_lindjes() {
        return viti_lindjes;
    }

    public String getNr_cel() {
        return nr_cel;
    }

    public void addMonedhat(String monedha) {
        this.monedhat.add(monedha);
    }
}
