import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Banka bank = new Banka();
        String comm;
        do {
            comm = input.next();
            if (comm.equals("SHTOKLIENT")){
                bank.SHTOKLIENT(input.next(),input.next(),input.next(),input.nextInt(),input.next());
            }
            if (comm.equals("SHTOLLOGARI")){
                bank.SHTOLLOGARI(input.next(),input.next(),input.next(),input.nextInt());
            }
            if (comm.equals("TERHIQ")){
                bank.TERHIQ(input.next(), input.nextInt());
            }
            if (comm.equals("DEPOZITO")){
                bank.DEPOZITO(input.next(), input.nextInt());
            }
            if (comm.equals("TRANSFERO")){
                bank.TRANSFERO(input.next(), input.next(),input.nextInt());
            }
            if (comm.equals("PERFITOINTERES")){
                bank.PERFITOINTERES(input.next());
            }
            if (comm.equals("NDRYSHOINTERES")){
                bank.NDRYSHOINTERES(input.next(), input.nextDouble());
            }
            if (comm.equals("LISTOKLIENTET")){
                bank.LISTOKLIENTET();
            }
            if (comm.equals("FSHIJKLIENT")){
                bank.FSHIJKLIENT(input.next());
            }
            if (comm.equals("FSHIJLLOGARI")){
                bank.FSHIJLLOGARI(input.next());
            }
        }while (!comm.equals("exit"));
    }
}
