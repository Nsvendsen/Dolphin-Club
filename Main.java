import java.util.ArrayList;
import java.util.Scanner;

public class Main {
private Medlem m;

    public static void main(String[] args) {
        ArrayList<Medlem> medlemmer = new ArrayList<Medlem>();

        Medlem m = new Medlem();
        medlemmer.add(m);
        medlemmer.add(m);

       Login(medlemmer);

    }

    public void LoadMedlemmer(){

    }


    public static void Login(ArrayList<Medlem> medlemmer){
        Medlem m = null;
        Scanner console = new Scanner(System.in);
        do{
            System.out.println("Indtast medlems ID");

        String ID = console.next();
        m = CheckMedlemsID(medlemmer, ID);
        if (m == null){
        System.out.println("Medlems ID ikke fundet!");}
        }
        while(m == null);

        for (int forsøg = 1; forsøg <= 3; forsøg++){
            System.out.println("Indtast kode");
            int kode = console.nextInt();
            if (kode == m.getKode()){
                break;

            }
            else{
                System.out.println("Forkert password. " + forsøg + ". forsøg ud af 3.");
                if (forsøg == 3){
                    System.out.println("Medlems ID er lukket. Kontakt support");
                }
            }


        }





    }

    public static Medlem CheckMedlemsID(ArrayList<Medlem> medlemmer, String ID){
        for (Medlem m : medlemmer){
            String id = m.getID();
            if (id.equals(ID)){
                return m;
            }

        }
        return null;
    }
}
