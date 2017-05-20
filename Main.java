

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Main {

   public static ArrayList<Medlem> medlemmer;


    public static void main(String[] args) {


        medlemmer = new ArrayList<Medlem>();


        //Menu.OpretMedlem();
        // SaveMedlemmer();


        LoadMedlemmer();

        while (1 == 1) {


            Medlem m = Login();


            if (m.getFormand()) {
                System.out.println("Du er logget ind som formand: " + m.getFornavn() + " " + m.getEfternavn());
                Menu.formandMenu();
            }
            SaveMedlemmer();


        }
    }



    public static void LoadMedlemmer(){
        try
        {
            FileInputStream fileIn = new FileInputStream("medlemmer.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            medlemmer = (ArrayList<Medlem>) in.readObject();
            in.close();
            fileIn.close();
        }
        catch(IOException i){
            i.printStackTrace();
            return;

        }
        catch(ClassNotFoundException c){
            System.out.println("Medlemsklassen ikke fundet. Kontakt support.");
            c.printStackTrace();
            return;

        }

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




    public static Medlem Login(){

        Medlem m = CheckMedlemsID();

        Scanner console = new Scanner(System.in);


        for (int forsøg = 1; forsøg <= 3; forsøg++)
        {

            System.out.println("Indtast kode:");

            int kode = 0;

            try
            {
                kode = parseInt(console.next());
            }

            catch(NumberFormatException e)
            {
            }

            if (kode == m.getKode())
            {

                break;

            }
            else
                {
                System.out.println("Forkert kode. Du har brugt " + forsøg + " ud af 3 forsøg");
                if (forsøg == 3)
                {
                    System.out.println("Medlems ID er spærret. Kontakt venligst support");
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
