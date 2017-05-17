
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Integer.parseInt;


public class Main {
   
private Medlem m;


    public static void main(String[] args) {
     
       medlemmer = new ArrayList<Medlem>();
       
       LoadMedlemmer();

       Login();

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






    public static void Login(){
        Medlem m = null;
        Scanner console = new Scanner(System.in);
        do
        {
            System.out.println("Indtast medlems ID:");
            String ID = console.next();
            m = CheckMedlemsID(ID);
        if (m == null)
        {
        System.out.println("Medlems ID ikke fundet!");
        }
        }
        while(m == null);
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
                    System.out.println("Medlems ID er spærret. Kontakt support");
                }
            }


        }





    }

    public static Medlem CheckMedlemsID(String ID)
    {
        for (Medlem m : medlemmer)
        {
            String id = m.getID();
            if (id.equals(ID))
            {
                return m;
            }

        }
        return null;
    }
}
