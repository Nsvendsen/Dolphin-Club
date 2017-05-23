import java.io.IOException;
import java.util.Scanner;
import java.util.stream.Collector;

import static java.lang.Integer.parseInt;

public class Menu {

    public static void formandMenu() {



        boolean menu = true;

        while (menu) {

            boolean done = false;

            while (!done) {



                API.Rollanimation("Vælg følgende:", "1: Opret medlem", "2: Slet medlem", "3: Rediger medlem", "4: Log af");


                Scanner console = new Scanner(System.in);

                String s = console.next();

                char c = s.charAt(0);

                if (Character.getNumericValue(c) == 1 && s.length() == 1) {
                    OpretMedlem(false);
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

                    for (int i = 1; i < 20; i++) {
                        System.out.println();
                    }
                    System.out.println("Du er nu logget af");
                    done = true;
                    menu = false;

                }
            }


        }
    }

    public static void bogholderMenu() {

        API.Rollanimation("Vælg følgende:", "1: Sene betalinger", "2: Register betaling", "3: Log af");
        Scanner console = new Scanner(System.in);

        String s = console.next();

        char c = s.charAt(0);
        if (Character.getNumericValue(c) == 3 && s.length() == 1) {

            for (int i = 1; i < 20; i++) {
                System.out.println();
            }
            System.out.println("Du er nu logget af");
        }else{
            System.out.println("Kommer i en senere version.");
        }
    }

    public static void trænerMenu() {

        API.Rollanimation("Vælg følgende:", "1: Top 5", "2: Register resultat", "3: Log af");

        Scanner console = new Scanner(System.in);

        String s = console.next();

        char c = s.charAt(0);
        if (Character.getNumericValue(c) == 3 && s.length() == 1) {

            for (int i = 1; i < 20; i++) {
                System.out.println();
            }
            System.out.println("Du er nu logget af");
        }else{
            System.out.println("Kommer i en senere version.");
        }
    }

    public static void eliteMenu(Medlem m) {

        API.Rollanimation("Vælg følgende:", "1: Register prioritet af træner", "2: Register resultat", "3: Log af");

        Scanner console = new Scanner(System.in);

        String s = console.next();

        char c = s.charAt(0);
        if (Character.getNumericValue(c) == 1 && s.length() == 1) {
                m.setTrænerPrioritet(redigerPrioritet());
            
        }else if (Character.getNumericValue(c) == 2 && s.length() == 1) {
                m.setBedsteResultat(redigerResultat());
            
        }else if (Character.getNumericValue(c) == 3 && s.length() == 1) {

            for (int i = 1; i < 20; i++) {
                System.out.println();
            }
            System.out.println("Du er nu logget af");
        }else{
            System.out.println("Kommer i en senere version.");
        }
    }
    
    public static String redigerPrioritet(){
        Scanner console = new Scanner(System.in);
        System.out.println("Første prioritet:");
        String s = console.nextLine();
        System.out.println("Anden prioritet:");
        s = s+console.nextLine();
        System.out.println("Tredje prioritet:");
        s = s+console.nextLine();
        return s;

    }
    
    public static String redigerResultat(){
        Scanner console = new Scanner(System.in);
        String s = "";
        boolean done = false;
        while (!done){
            System.out.println("Indtast din tid i formattet hh:mm:ss");
            s = console.nextLine();
            String[] ssplit = s.split(":");
                if (ssplit.length != 3){
                    System.out.println("Du har ikke indtastet en korrekt tid");
                }else{
                    done = true;
                }
        }
        done = false;
        while (!done){
            System.out.println("Indtast hvornår tiden var sat i formattet dd/mm/yy");
            s = s+" "+console.nextLine();
            String[] ssplit = s.split("/");
                if (ssplit.length != 3){
                    System.out.println("Du har ikke indtastet en korrekt tid");
                }else{
                    done = true;
                }
        }
        
        return s;

    }
    

    public static void OpretMedlem(boolean firstRun){

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
        int IDmax = 1000;


        if(!firstRun) {
            Medlem m1 = Main.medlemmer.get(Main.medlemmer.size() - 1);
            String ID = m1.getID();
            IDmax = parseInt(ID.substring(1, ID.length()));
        }
        
        System.out.println();

        Medlem nyt = null;
        if (elite){
            String aktivdisciplin = redigerAktivDisciplin();
            nyt = (Medlem)new Elite(IDmax, fornavn, efternavn, fødselsdato, vejnavn, vejnr, postnr, by, tlfnr, CheckKvinde, aktivdisciplin);
            System.out.println("Elitemedlem er oprettet");
        }else{
            nyt = new Medlem(IDmax, fornavn, efternavn, fødselsdato, vejnavn, vejnr, postnr, by, tlfnr, CheckKvinde);
            System.out.println("Medlem er oprettet");
        }

        if(firstRun){
            nyt.setFormand(true);
            String ID = nyt.getID();
            ID = ID.replace('M','F');
            nyt.setID(ID);
        }
        System.out.println();

        System.out.println(nyt);

        System.out.println("ID: " + nyt.getID());
        System.out.println("Kode: " + nyt.getKode());

        Main.medlemmer.add(nyt);
        Main.SaveMedlemmer();
    }

    public static String redigerAktivDisciplin(){
        Scanner console = new Scanner(System.in);
        System.out.println("Aktiv disciplin:");

        return console.nextLine();

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
            System.out.println("Medlem er slettet!");
            done = true;
        } else if (s.equals("n") || s.equals("N")){
            done = true;

            }

        }


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
                return true;
            }
            if (Character.getNumericValue(c) == 2 && s.length() == 1)
            {
                return false;
            }

        }


    }

    public static String RedigerMedlemsfunktion()
    {
        Scanner console = new Scanner(System.in);


        while (1 == 1)
        {

            API.Rollanimation("Medlemsstatus:", "1: Formand","2: Bogholder","3: Træner","4: Elite");
            String s = console.nextLine();


            char c = s.charAt(0);

            if (Character.getNumericValue(c) == 1 && s.length() == 1)
            {
                return "Formand";
            }
            if (Character.getNumericValue(c) == 2 && s.length() == 1)
            {
                return "Bogholder";
            }
            if (Character.getNumericValue(c) == 3 && s.length() == 1)
            {
                return "Træner";
            }
            if (Character.getNumericValue(c) == 4 && s.length() == 1)
            {
                return "Elite";
            }

        }
    }



    public static void RedigerMedlem() {

        Main.PrintMedlemsliste();
        System.out.println();
        Medlem rediger = Main.CheckMedlemsID();
        boolean menu = true;

        while (menu) {
            System.out.println(rediger);
            System.out.println();
            System.out.println("Vælg at redigere:");
            System.out.println("1: Fornavn, 2: Efternavn, 3: Vejnavn, 4: Vejnummer, 5: Postnummer, 6: By, 7: Telefonnummer");
            System.out.println("8: Medlemsfunktion, 9: Medlemsstatus, 10: Fødselsdato, 11: Gå tilbage");

            Scanner console = new Scanner(System.in);
            boolean done = true;

            do {
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
                    case 8:
                        String funktion = RedigerMedlemsfunktion();
                        if (funktion.equals("Formand")){
                            rediger.setFormand(true);
                            String rID = rediger.getID();
                            String ID = "F" + rID.substring(1, rID.length());
                           rediger.setID(ID);

                        }
                        if (funktion.equals("Bogholder")){
                            rediger.setBogholder(true);
                            String rID = rediger.getID();
                            String ID = "B" + rID.substring(1, rID.length());
                            rediger.setID(ID);

                        }
                        if (funktion.equals("Træner")){
                            rediger.setTræner(true);
                            String rID = rediger.getID();
                            String ID = "T" + rID.substring(1, rID.length());
                            rediger.setID(ID);

                        }
                        break;
                    case 9:
                        boolean status = RedigerMedlemsstatus();
                        rediger.setMedlemsStatus(status);
                        break;
                    case 10:
                        String fødselsdato = RedigerFødselsdato();
                        rediger.setFødselsdato(fødselsdato);
                        break;
                    case 11:
                        menu = false;
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


