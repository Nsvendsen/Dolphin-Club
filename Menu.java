

import java.util.Scanner;
import java.util.stream.Collector;

import static java.lang.Integer.parseInt;


public class Menu {

    public static void formandMenu() {


        boolean done = false;

        while (!done) {

            API.Rollanimation("Vælg følgende:", "1: Opret medlem", "2: Slet medlem", "3: Rediger medlem", "4: Log af");


            Scanner console = new Scanner(System.in);

            String s = console.next();

            char c = s.charAt(0);

            if (Character.getNumericValue(c) == 1 && s.length() == 1) {
                OpretMedlem();
                done = true;
            }
            if (Character.getNumericValue(c) == 2 && s.length() == 1) {
                SletMedlem();
                done = true;
            }
            if (Character.getNumericValue(c) == 3 && s.length() == 1) {
                RedigerMedlem();
                done = true;


            }
            if (Character.getNumericValue(c) == 4 && s.length() == 1) {
                System.out.println("Du er nu logget af");
                Main.Login();
                done = true;

            }
        }
    }

    public static void OpretMedlem(){

        String fornavn = RedigerFornavn();
        String efternavn = RedigerEfternavn();
        String vejnavn = RedigerVejNavn();
        String vejnr = RedigerVejnr();
        int postnr = RedigerPostnr();
        String by = RedigerBy();
        int tlfnr = RedigerTlfnr();
        boolean CheckKvinde = RedigerKøn();
        String fødselsdato = RedigerFødselsdato();
        boolean elite = RedigerElite();


      Medlem m1 = Main.medlemmer.get(Main.medlemmer.size() - 1);
        String ID = m1.getID();
        int IDmax = parseInt(ID.substring(1,ID.length()));


        Medlem nyt = new Medlem(IDmax, fornavn, efternavn, fødselsdato, vejnavn, vejnr, postnr, by, tlfnr, CheckKvinde);

        System.out.println("Medlem er oprettet");

        System.out.println();

        System.out.println(nyt);

        System.out.println("ID: " + nyt.getID());
        System.out.println("Kode: " + nyt.getKode());

       Main.medlemmer.add(nyt);
        Main.SaveMedlemmer();

        formandMenu();

    }

    public static void SletMedlem(){
        Main.PrintMedlemsliste();
        System.out.println();
        Medlem slet = Main.CheckMedlemsID();
        System.out.println(slet);

        Scanner console = new Scanner(System.in);
        boolean done = false;

        while(!done){
        System.out.println("Slet medlem j/n?");
        String s = console.nextLine();

        if (s.equals("j") || s.equals("J")){
            Main.medlemmer.remove(slet);
            Main.SaveMedlemmer();
            System.out.println("Medlemmet er slettet!");
            done = true;
        }
        else if (!s.equals("n") && !s.equals("N")){
            System.out.println("tast j/n");
            done = true;
        }
        }

        formandMenu();

    }

    public static String RedigerFornavn(){
        Scanner console = new Scanner(System.in);
        System.out.println("Fornavn(e):");

        return console.nextLine();

    }

    public static String RedigerEfternavn(){
        Scanner console = new Scanner(System.in);
        System.out.println("Efternavn:");

        return console.nextLine();
    }

    public static String RedigerVejNavn(){
        Scanner console = new Scanner(System.in);
        System.out.println("Vejnavn:");

        return console.nextLine();

    }

    public static String RedigerVejnr(){
        Scanner console = new Scanner(System.in);
        System.out.println("Vej nr.:");

        return console.nextLine();
    }

    public static int RedigerPostnr(){
        Scanner console = new Scanner(System.in);
        int postnr = 0;

        while(postnr == 0) {
            System.out.println("Post nr.:");
            try {
                postnr = parseInt(console.nextLine());
            } catch (NumberFormatException n) {
                System.out.println("Postnummer må ikke indeholde bogstaver.");
                postnr = 0;
            }

            if (postnr < 1000 || postnr > 9999) {
                System.out.println("Postnummer skal være på 4 cifre");
                postnr = 0;


            }
        }

        return postnr;

    }

    public static String RedigerBy(){
        Scanner console = new Scanner(System.in);
        System.out.println("By:");

        return console.nextLine();
    }

    public static int RedigerTlfnr(){
        Scanner console = new Scanner(System.in);
        int tlfnr = 0;

        while(tlfnr == 0) {
            System.out.println("Tlf nr (uden mellemrum):");
            try {
                tlfnr = parseInt(console.nextLine());
            } catch (NumberFormatException n) {
                System.out.println("Tlf nr må ikke indeholde bogstaver eller mellemrum.");
                tlfnr = 0;

            }
            if (tlfnr < 10000000 || tlfnr > 99999999){
                System.out.println("Tlf nr skal være på 8 cifre");
                tlfnr = 0;
            }
        }

        return tlfnr;
    }

    public static boolean RedigerKøn(){
        Scanner console = new Scanner(System.in);


        while (1 == 1) {
            API.Rollanimation("Køn:", "1: mand","2: kvinde");


            String s = console.next();


            char c = s.charAt(0);

            if (Character.getNumericValue(c) == 1 && s.length() == 1) {
                return false;
            }
            if (Character.getNumericValue(c) == 2 && s.length() == 1) {
                return true;
            }

        }


    }

    public static String RedigerFødselsdato(){
        Scanner console = new Scanner(System.in);
        boolean done = false;
        String fødselsdato = "";

        while(!done)

        {

            System.out.println("Fødselsdag (DD-MM-ÅÅÅÅ)");
            String datePattern = "\\d{2}-\\d{2}-\\d{4}";
            fødselsdato = console.next();
            done = fødselsdato.matches(datePattern);
        }

        return fødselsdato;

    }

    public static boolean RedigerElite(){
        Scanner console = new Scanner(System.in);

        while (1 == 1) {
            API.Rollanimation("Elite:", "1: Ja", "2: Nej");

            String s = console.next();


            char c = s.charAt(0);

            if (Character.getNumericValue(c) == 1 && s.length() == 1) {
                return true;
            }
            if (Character.getNumericValue(c) == 2 && s.length() == 1) {
                return false;
            }


        }

    }

   public static boolean RedigerMedlemsstatus()
   {
        Scanner console = new Scanner(System.in);


        while (1 == 1) 
        {
            API.Rollanimation("Medlemsstatus:", "1: Aktiv","2: Passiv");


            String s = console.next();


            char c = s.charAt(0);

            if (Character.getNumericValue(c) == 1 && s.length() == 1) 
            {
                return false;
            }
            if (Character.getNumericValue(c) == 2 && s.length() == 1) 
            {
                return true;
            }

        }


    }

    public static String RedigerMedlemsfunktion(){
        return "Formand";
    }



    public static void RedigerMedlem() {

        Main.PrintMedlemsliste();
        System.out.println();
        Medlem rediger = Main.CheckMedlemsID();

        while (1 == 1) {
            System.out.println(rediger);
            System.out.println();
            System.out.println("Vælg at redigere:");
            System.out.println("1: Fornavn, 2: Efternavn, 3: Vejnavn, 4: Vejnummer, 5: Postnummer, 6: By, 7: Telefonnummer");
            System.out.println("8: Medlemsfunktion, 9: Medlemsstatus, 10: Fødselsdato, 11: Gå tilbage");

            Scanner console = new Scanner(System.in);
            boolean done = true;

            do {
                done = true;
                int valgt = 0;


                try {
                    valgt = parseInt(console.next());
                } catch (NumberFormatException e) {

                }


                switch (valgt) {
                    case 1:
                        String fornavn = RedigerFornavn();
                        rediger.setFornavn(fornavn);
                        break;
                    case 2:
                        String efternavn = RedigerEfternavn();
                        rediger.setEfternavn(efternavn);
                        break;
                    case 3:
                        String vejnavn = RedigerVejNavn();
                        rediger.setVejnavn(vejnavn);
                        break;
                    case 4:
                        String vejnr = RedigerVejnr();
                        rediger.setVejnummer(vejnr);
                        break;
                    case 5:
                        int postnr = RedigerPostnr();
                        rediger.setPostnummer(postnr);
                        break;
                    case 6:
                        String by = RedigerBy();
                        rediger.setBy(by);
                        break;
                    case 7:
                        int tlfnr = RedigerTlfnr();
                        rediger.setTelefonnummer(tlfnr);
                        break;
                    case 11:
                        formandMenu();
                        break;
                    default:
                        System.out.println("Ikke gyldigt valg (tast 1-11)");
                        done = false;
                        break;
                }
                Main.SaveMedlemmer();

            } while (!done);





        }
    }




    }





