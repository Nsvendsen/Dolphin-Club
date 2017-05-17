public class Elite extends Member {
  
  public Elite(int antalMedlemmer, String fornavn, String efternavn, String fødselsdato, String vejnavn, String vejnummer, int postnummer, int telefonnummer, 
   Date sidstebetalingsdato, boolean medlemsstatus, boolean checkkvinde, boolean formand, boolean bogholder,String disciplin,String prioritet,long resultat)
   {
      ID = genIDE(antalMedlemmer);
      Kode = genKode();
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
      Formand = formand;
      Bogholder = bogholder;
      Træner = træner;
      aktivDisciplin = disciplin;
      trænerPrioritet = prioritet;
      bedsteResultat = resultat;
   }

   public String genIDE(int antalMedlemmer)
   {
      String genID2 = "E";
      genID2 += (antalMedlemmer + 1);
      return genID2;
   }
  
  private String aktivDisciplin;
  private String trænerPrioritet;
  private long bedsteResultat;
  
  //Get metoder
  public String getAktivDisciplin(){
  return aktivDisciplin;
  }
  
  public String getTrænerPrioritet(){
  return trænerPrioritet;
  }
  
  public long getBedsteResultat(){
  return bedsteResultat;
  }
  
  //Set metoder
  public void setAktivDisciplin(String disciplin){
  aktivDisciplin = disciplin;
  }
  
  public void setTrænerPrioritet(String prioritet){
  trænerPrioritet = prioritet;
  }
  
  public void setBedsteResultat(long resultat){
  bedsteResultat = resultat;
  }

}
