package question1;


public class Contributeur extends Cotisant{
  private int solde;
  
  public Contributeur(String nom, int somme){
    super(nom);
    if (somme < 0){
          throw new RuntimeException("nombre n�gatif !!!");
        }
        
    solde = somme;
  }
  
  /**
   * retourne le solde d'un contributeur
   * @return entier
   */
  public int solde(){
    return this.solde;
  }
  
  /**
   * retourne le nombre de cotisant (donc 1)
   * @return entier
   */
  public int nombreDeCotisants(){
    return 1;
  }
  
    public void debit(int somme) throws SoldeDebiteurException{
      if (somme > solde){
            throw new SoldeDebiteurException();
        }
             if (somme < 0){
          throw new RuntimeException("nombre n�gatif !!!");
        }
        solde -= somme;
    }
    
    /**
     * throws RuntimeException new RuntimeException("nombre n�gatif !!!");
     */
  public  void credit(int somme){
      if (somme < 0){
          throw new RuntimeException("nombre n�gatif !!!");
        }
        solde += somme;

    }
    
    /**
     * throws RuntimeException new RuntimeException("nombre n�gatif !!!");
     */
  public void affecterSolde(int somme){
    if(somme < 0) throw new RuntimeException("nombre n�gatif !!!");
    try{
      debit(solde()); credit(somme);// mode �l�gant ... 
    }catch(SoldeDebiteurException sde){ 
      // exception peu probable
      this.solde = somme; // mode efficace ...
    }
  }
  
  public <T> T accepter(Visiteur<T> visiteur){
    return visiteur.visite(this);
  }
  
  /**
   * retourne le contributeur sous forme de string contenant son nom et son solde
   * @return String
   */
  public String toString(){
    return "<Contributeur : " + nom + "," + solde + ">";
  }

}
