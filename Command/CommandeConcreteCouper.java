
/**
 * Décrivez votre classe CommandeConcreteCouper ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class CommandeConcreteCouper implements Commande{ 
    private Recepteur recepteur     =   null;
    private String donneesCoupees   =   null;
    private String contenuPrecedent =   null;
    private int indexDebutCoupe     =   0;
    private int indexFinCoupe       =   0;
 
    public CommandeConcreteCouper(Recepteur recepteur, int indexDebutCoupe, int indexFinCoupe) {
        this.recepteur          =   recepteur;
        this.indexDebutCoupe    =   indexDebutCoupe;
        this.indexFinCoupe      =   indexFinCoupe;
    }
    
    public void lancer() {
        contenuPrecedent = recepteur.getContenu();
        recepteur.couper(indexDebutCoupe, indexFinCoupe);
        donneesCoupees = contenuPrecedent.substring(indexDebutCoupe, indexFinCoupe);
        System.out.println("Coupe du texte : \"" +donneesCoupees + "\" depuis : " + recepteur.getNom());
    }
    
    public String getDonneesCoupees() {
        return donneesCoupees;
    }
    
    public void annulerCouper() {
        recepteur.setContent(contenuPrecedent);
    }
 
}