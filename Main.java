

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Main {

   public static ArrayList<Medlem> medlemmer;


    public static void main(String[] args) {


        medlemmer = new ArrayList<Medlem>();
        Medlem m = null;


     //   Menu.OpretMedlem();
     //   SaveMedlemmer();

    boolean firstRun = LoadMedlemmer();

        if (firstRun){

            System.out.println("Velkommen til Dolphi. Indtast det bruger ID og kode der følger med manualen,");
            System.out.println("for at oprette dig selv som formand med administrator rettigheder.");
            System.out.println("Husk at gemme ny kode og nyt bruger ID");

            m = Login(true);


            Menu.OpretMedlem(true);
        }


        while (1 == 1) {


            m = Login(false);
if(!m.getSpærret()) {

    if (m.getFormand()) {
        System.out.println("Du er logget ind som formand: " + m.getFornavn() + " " + m.getEfternavn());
        Menu.formandMenu();
    } else if (m.getBogholder()) {
        System.out.println("Du er logget ind som bogholder: " + m.getFornavn() + " " + m.getEfternavn());
        Menu.bogholderMenu();
    } else if (m.getTræner()) {
        System.out.println("Du er logget ind som træner: " + m.getFornavn() + " " + m.getEfternavn());
        Menu.trænerMenu();
    } else if (m instanceof Elite) {
        System.out.println("Du er logget ind som elitemedlem: " + m.getFornavn() + " " + m.getEfternavn());
        Menu.eliteMenu(m);
    } else {
        System.out.println("Du er logget ind som medlem: " + m.getFornavn() + " " + m.getEfternavn());
        System.out.println("Goddag, og velkommen til.");
        System.out.println("Hav en god svømmetur.");
        System.out.println("Vandet er nu 27 grader varmt.");
        SaveMedlemmer();


    }

}
    }
    }




    public static boolean LoadMedlemmer(){
        boolean firstRun = false;
        try
        {
            FileInputStream fileIn = new FileInputStream("medlemmer.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            medlemmer = (ArrayList<Medlem>) in.readObject();
            in.close();
            fileIn.close();
        }
        catch(IOException i){
            firstRun = true;


        }
        catch(ClassNotFoundException c){
           firstRun = true;


        }

        return firstRun;

    }

    public static void SaveMedlemmer(){
        try {
            FileOutputStream fileOut = new FileOutputStream("medlemmer.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(medlemmer);
            out.close();
            fileOut.close();
        }
        catch(IOException i){
            i.printStackTrace();
        }

    }




    public static Medlem Login(boolean firstRun){

        Scanner console = new Scanner(System.in);
        Medlem m = null;
        int kode = 0;

        if (firstRun) {
            String ID = "DEFAULTID01";
            boolean done = false;

            while (!done) {
                System.out.println("Indtast bruger ID:");
                if (ID.equals(console.nextLine())) {
                    done = true;
                }else{
                    System.out.println("Forkert bruger ID!");
                }
            }
            done = false;
            while (!done) {
                System.out.println("Indtast kode:");
                try {
                    kode = parseInt(console.next());
                } catch (NumberFormatException e) {
                }
                if (kode == 1203) {
                    done = true;
                }else{
                    System.out.println("Forkert kode!");
                }

            }
        }else {

            m = CheckMedlemsID();


            if (m.getSpærret()) {
                System.out.println("Medlems ID er spærret. Kontakt venligst support!.");
            } else {


                for (int forsøg = 1; forsøg <= 3; forsøg++) {


                    System.out.println("Indtast kode:");


                    try {
                        kode = parseInt(console.next());
                    } catch (NumberFormatException e) {
                    }

                    if (kode == m.getKode()) {

                        break;

                    }

                    System.out.println("Forkert kode. Du har brugt " + forsøg + " ud af 3 forsøg");
                    if (forsøg == 3) {

                        m.setSpærret(true);
                        System.out.println("Medlems ID er spærret. Kontakt venligst support!");
                    }
                }


            }
        }

        return m;





    }

    public static Medlem CheckMedlemsID()
    {
        boolean done = false;

        Scanner console = new Scanner(System.in);
        while (!done)
        {
            System.out.println("Indtast medlems ID:");
            String ID = console.next();
            for (Medlem m : medlemmer)
            {
                String id = m.getID();
                if (id.equals(ID))
                {
                    return m;
                }

            }
            System.out.println("Medlems ID er ikke fundet!");

        }
      return null;

    }

    public static void PrintMedlemsliste(){
        for (Medlem m : medlemmer){
            System.out.println(m.getID() + " " + m.getFornavn() + " " + m.getEfternavn());
        }
    }
}
