

class CommandeConcreteCopie implements Commande{ 
    private String donneesCopiees   =   null;
    private int indexDebutCopie     =   0;
    private int indexFinCopie       =   0;
    private Recepteur recepteur     =   null;
    private String contenuPrecedent =   null;
     public CommandeConcreteCopie(Recepteur recepteur , int indexDebutCopie ,int indexFinCopie ) {
        this.indexDebutCopie = indexDebutCopie;        
        this.indexFinCopie = indexFinCopie;
        this.recepteur = recepteur;
     }
     
     public void lancer() {
        contenuPrecedent = recepteur.getContenu();
        donneesCopiees = contenuPrecedent.substring(indexDebutCopie,indexFinCopie);
        recepteur.copier(donneesCopiees);
        System.out.println("Copie du texte : \"" +donneesCopiees + "\" depuis : " + recepteur.getNom());
     }
     
     public String getDonneesCopiees() {
        return donneesCopiees;
     }
}
