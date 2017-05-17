import java.util.Scanner;
import java.util.stream.Collector;

import static java.lang.Integer.parseInt;

/**
 * Created by lampe on 17-05-2017.
 */
public class Menu {

    public static void formandMenu() {


        boolean done = false;

        while (!done) {

            API.Rollanimation("Vælg følgende:", "1: Opret medlem", "2: Slet medlem", "3: Rediger medlem");


            Scanner console = new Scanner(System.in);

            String s = console.next();

            char c = s.charAt(0);

            if (Character.getNumericValue(c) == 1) {
                OpretMedlem();
                done = true;
            }
            if (Character.getNumericValue(c) == 2) {
                // SletMedlem();
                done = true;
            }
            if (Character.getNumericValue(c) == 3) {
                //RedigerMedlem();
                done = true;

            }
        }
    }

    public static void OpretMedlem(){
        System.out.println("Fornavn(e):");

        Scanner console = new Scanner(System.in);
        String fornavn = console.nextLine();
        System.out.println("Efternavn:");
        String efternavn = console.nextLine();
        String vejnavn = console.nextLine();
        System.out.println("Vej nr.:");
        String vejnr = console.nextLine();
        System.out.println("Post nr.:");

        int postnr = 0;

        while(postnr == 0) {
            try {
                postnr = parseInt(console.next());
            } catch (NumberFormatException n) {
                System.out.println("Postnummer må ikke indeholde bogstaver.");
                postnr = 0;
            }
        }

        System.out.println("By:");
        String by = console.nextLine();



        int tlfnr = 0;


     while(tlfnr == 0) {
         System.out.println("Tlf nr (uden mellemrum):");
         try {
             tlfnr = parseInt(console.next());
         } catch (NumberFormatException n) {
             System.out.println("Tlf nr må ikke indeholde bogstaver eller mellemrum.");
             tlfnr = 0;
         }
     }
        boolean done = false;
        boolean CheckKvinde;
        while (!done) {
            API.Rollanimation("Køn:", "1: mand","2: kvinde");
          

            String s = console.next();


            char c = s.charAt(0);

            if (Character.getNumericValue(c) == 1) {
                CheckKvinde = false;
                done = true;
            }
            if (Character.getNumericValue(c) == 2) {
                CheckKvinde = true;
                done = true;
            }

        }

        done = false;
        String fødselsdato = "";

        while(!done)

        {

            System.out.println("Fødselsdag (DD-MM-ÅÅÅÅ)");
            String datePattern = "\\d{2}-\\d{2}-\\d{4}";
            fødselsdato = console.next();
            done = fødselsdato.matches(datePattern);
        }



        done = false;
        boolean elite;
        while (!done) {
            API.Rollanimation("Elite:", "1: Ja", "2: Nej");

            String s = console.next();


            char c = s.charAt(0);

            if (Character.getNumericValue(c) == 1) {
                elite = true;
                done = true;
            }
            if (Character.getNumericValue(c) == 2) {
                elite = false;
                done = true;
            }



            Medlem m1 = Main.medlemmer.get(Main.medlemmer.size() - 1);
            String ID = m1.getID();
            int IDmax = parseInt(ID.substring(1,ID.length()));





            Medlem m2 = new Medlem(IDmax, fornavn, efternavn, fødselsdato, vejnavn, vejnr, postnr, tlfnr, )

        }








    }

}
