import java.util.Date;

public class Medlem {

   private String ID;
   private String Kode;
   private String Fornavn;
   private String Efternavn;
   private String Fødselsdato;
   private String Vejnavn;
   private String Vejnummer;
   private int Postnummer;
   private int Telefonnummer;
   private Date SidsteBetalingsdato;
   private boolean MedlemsStatus;
   private boolean CheckKvinde;
   
   //her kommer get metoderne
   public String getID()
   {
      return ID;
   }
   public String getKode()
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

/* her kommer set metoderne */

   public void setID(String id)
   { 
      ID = id; 
   }
   public void setKode(String kode)
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
/*private String ID;
   private String Kode;
   private String Fornavn;
   private String Efternavn;
   private String Fødselsdato;
   private String Vejnavn;
   private String Vejnummer;
   private int Postnummer;
   private int Telefonnummer;
   private Date SidsteBetalingsdato;
   private boolean MedlemsStatus;
   private boolean CheckKvinde;
*/
   public Medlem(String fornavn, String efternavn, String fødselsdato, String vejnavn, String vejnummer, int postnummer, int telefonnummer, 
   Date sidstebetalingsdato, boolean medlemsstatus, boolean checkkvinde)
   {
      Fornavn = fornavn;
      Efternavn = efternavn;
      Fødselsdato = fødselsdato;
      Vejnavn = vejnavn;
      Vejnummer = vejnummer;
      Postnummer = postnummer;
      Telefonnummer = telefonnummer;
      SidsteBetalingsdato = sidstebetalingsdato;
      MedlemsStatus = medlemsstatus;
      CheckKvinde = checkkvinde;
   }
}
