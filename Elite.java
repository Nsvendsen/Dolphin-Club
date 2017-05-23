
import java.util.Date;
public class Elite extends Medlem {

    private static final long serialVersionUID = 1L;



    public Elite(int antalMedlemmer, String fornavn, String efternavn, String fødselsdato, String vejnavn, String vejnummer, int postnummer, String by, int telefonnummer, boolean checkkvinde, String aktivDisciplin)
    {
        super(antalMedlemmer, fornavn, efternavn, fødselsdato, vejnavn, vejnummer,postnummer, by, telefonnummer, checkkvinde);
        setID(genID(antalMedlemmer));
        this.aktivDisciplin = aktivDisciplin;

    }

    public String genID(int antalMedlemmer)
    {
        String genID2 = "E";
        genID2 += (antalMedlemmer + 1);
        return genID2;
    }

    private String aktivDisciplin;
    private String trænerPrioritet;
    private String bedsteResultat;

    //Get metoder
    public String getAktivDisciplin(){
        return aktivDisciplin;
    }

    public String getTrænerPrioritet(){
        return trænerPrioritet;
    }

    public String getBedsteResultat(){
        return bedsteResultat;
    }

    //Set metoder
    public void setAktivDisciplin(String disciplin){
        aktivDisciplin = disciplin;
    }

    public void setTrænerPrioritet(String prioritet){
        trænerPrioritet = prioritet;
    }

    public void setBedsteResultat(String resultat){
        bedsteResultat = resultat;
    }

}
