package com.company;

/**
 * Created by lampe on 16-05-2017.
 */
import java.util.Date;
import java.util.Random;

public class Medlem  implements java.io.Serializable {

    private String ID;
    private int Kode;
    private String Fornavn;
    private String Efternavn;
    private String Fødselsdato;
    private String Vejnavn;
    private String Vejnummer;
    private int Postnummer;
    private String By
    private int Telefonnummer;
    private Date SidsteBetalingsdato;
    private boolean MedlemsStatus;
    private boolean CheckKvinde;
    private boolean Formand;
    private boolean Bogholder;
    private boolean Træner;

    //her kommer get metoderne
    public String getID()
    {
        return ID;
    }
    public int getKode()
    {
        return Kode;
    }
    public String getFornavn()
    {
        return Fornavn;
    }
    public String getEfternavn()
    {
        return Efternavn;
    }
    public String getFødselsdato()
    {
        return Fødselsdato;
    }
    public String getVejnavn()
    {
        return Vejnavn;
    }
    public String getVejnummer()
    {
        return Vejnummer;
    }
    public int getPostnummer()
    {
        return Postnummer;
    }
    public String getBy
    {
        return By
    }
    public int getTelefonnummer()
    {
        return Telefonnummer;
    }
    public Date getSidsteBetalingsdato()
    {
        return SidsteBetalingsdato;
    }
    public boolean getMedlemsStatus()
    {
        return MedlemsStatus;
    }
    public boolean getCheckKvinde()
    {
        return CheckKvinde;
    }
    public boolean getFormand()
    {
        return Formand;
    }
    public boolean getBogholder()
    {
        return Bogholder;
    }
    public boolean getTræner()
    {
        return Træner;
    }

/* her kommer set metoderne */

    public void setID(String id)
    {
        ID = id;
    }
    public void setKode(int kode)
    {
        Kode = kode;
    }
    public void setFornavn(String fornavn)
    {
        Fornavn = fornavn;
    }
    public void setEfternavn(String efternavn)
    {
        Efternavn = efternavn;
    }
    public void setFødselsdato(String fødselsdato)
    {
        Fødselsdato = fødselsdato;
    }
    public void setVejnavn(String vejnavn)
    {
        Vejnavn = vejnavn;
    }
    public void setVejnummer(String vejnummer)
    {
        Vejnummer = vejnummer;
    }
    public void setPostnummer(int postnummer)
    {
        Postnummer = postnummer;
    }
    public void setBy(String by)
    {
        By = by;
    }
    public void setTelefonnummer(int telefonnummer)
    {
        Telefonnummer = telefonnummer;
    }
    public void setSidsteBetalingsdato(Date sidstebetalingsdato)
    {
        SidsteBetalingsdato = sidstebetalingsdato;
    }
    public void setMedlemsStatus(boolean medlemsstatus)
    {
        MedlemsStatus = medlemsstatus;
    }
    public void setCheckKvinde(boolean checkkvinde)
    {
        CheckKvinde = checkkvinde;
    }

    public void setFormand(boolean formand)
    {
        Formand = formand;
    }
    public void setBogholder(boolean bogholder)
    {
        Bogholder = bogholder;
    }
    public void setTræner(boolean træner)
    {
        Træner = træner;
    }

    public Medlem(int antalMedlemmer, String fornavn, String efternavn, String fødselsdato, String vejnavn, String vejnummer, int postnummer, String by, int telefonnummer, boolean checkkvinde)
    {
        ID = genID(antalMedlemmer);
        Kode = genKode();
        Fornavn = fornavn;
        Efternavn = efternavn;
        Fødselsdato = fødselsdato;
        Vejnavn = vejnavn;
        Vejnummer = vejnummer;
        Postnummer = postnummer;
        Telefonnummer = telefonnummer;
        CheckKvinde = checkkvinde;
        Date nu = new Date();
        SidsteBetalingsdato = nu;


    }

/* her genereres en kode for brugeren mellem 1000 og 9999 */

    public int genKode()
    {
        Random r = new Random();
        return (r.nextInt(8999)+1000);
    }

/* Her tilføjes bogstav til ID der indikere typen af bruger som enten formand, bogholder, træner eller medlem*/

    public String genID(int antalMedlemmer)
    {
        String genID2 = "";
        if(Formand)
        {
            genID2 += "F";
        }
        else if(Bogholder)
        {
            genID2 += "B";
        }
        else if(Træner)
        {
            genID2 += "T";
        }
        else
        {
            genID2 += "M";
        }
        genID2 += (antalMedlemmer + 1);
        return genID2;
    }
}
