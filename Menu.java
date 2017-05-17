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
        String efternavn = console.next();
        String vejnavn = console.nextLine();
        System.out.println("Vej nr.:");
        String vejnr = console.next();
        System.out.println("Post nr.:");
        try
        {
            int postnr = parseInt(console.next());
        }
        catch(NumberFormatException n){
            System.out.println("Postnummer indeholder ikke bogstaver. Husk at redigerer medlem efter oprettelse for at rette fejl");
        }

        System.out.println("By:");
        String by = console.nextLine();

        System.out.println("Tlf nr (uden mellemrum):");




        try
        {
            int tlfnr = parseInt(console.next());
        }
        catch(NumberFormatException n){
            System.out.println("Tlf nr indeholder ikke bogstaver. Husk at redigerer medlem efter oprettelse for at rette fejl");
        }
        boolean done = false;
        boolean kvinde;
        while (!done) {
            System.out.println("Køn:");
            System.out.println("1: mand");
            System.out.println("2: kvinde");

            String s = console.next();


            char c = s.charAt(0);

            if (Character.getNumericValue(c) == 1) {
                kvinde = false;
                done = true;
            }
            if (Character.getNumericValue(c) == 2) {
                kvinde = true;
                done = true;
            }

        }


        System.out.println("Fødselsdag (DD-MM-ÅÅÅÅ)");
        String føldselsdag = console.next();






    }

}
