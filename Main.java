
import static java.lang.Integer.parseInt;

public class Main {
private Medlem m;
   private static ArrayList<Medlem> medlemmer;

    public static void main(String[] args) {
     medlemmer = new ArrayList<Medlem>();

        Medlem m = new Medlem();
        medlemmer.add(m);
        medlemmer.add(m);

       Login();

    }

    public void LoadMedlemmer(){

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
