
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Integer.parseInt;


public class Main {
   
private Medlem m;
   private static ArrayList<Medlem> medlemmer;
   //Start methoden
    public static void main(String[] args) {
  
       
       LoadMedlemmer();

       Login();

    }
      //methoden her loader alle medlemmer ind i en arraylist gennem objectinputstream
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
            API.Rollanimation("Medlemsklassen ikke fundet. Kontakt support.");
            c.printStackTrace();
            return;

        }

    }
   //Methoden her gemmer alle medlemmer til en file ved hjælp af obejctoutputstream så den nemt kan loades ind igen
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
            API.Rollanimation("Indtast medlems ID:");
            String ID = console.next();
            m = CheckMedlemsID(ID);
        if (m == null)
        {
        API.Rollanimation("Medlems ID ikke fundet!");
        }
        }
        while(m == null);
        for (int forsøg = 1; forsøg <= 3; forsøg++)
        {
            API.Rollanimation("Indtast kode:");

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
                API.Rollanimation("Forkert kode.","","Du har brugt " + forsøg + " ud af 3 forsøg");
                if (forsøg == 3)
                {
                    API.Rollanimation("Medlems ID er spærret. Kontakt support");
                }
            }


        }





    }
   //Tjekker hele arraylisten igennem efter det medlemsID som vi kigger efter.
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
