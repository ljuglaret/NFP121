
/**
 * Décrivez votre classe CommandeConcreteCouper ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class CommandeConcreteCouper implements Commande{ 
    private Recepteur recepteur     =   null;
    private String contenuPrecedent =   null;
    private int startIndex          =   0;
    private int endIndex            =   0;
    private String donneesCoupees   =   null;
 
    public CommandeConcreteCouper(Recepteur recepteur, int startIndex, int endIndex) {
        this.recepteur = recepteur;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }
    
    public void lancer() {
        contenuPrecedent = recepteur.getContenu();
        recepteur.couper(startIndex, endIndex);
        donneesCoupees = contenuPrecedent.substring(startIndex, endIndex);
        System.out.println("Coupe du texte : \"" +donneesCoupees + "\" depuis : " + recepteur.getNom());
    }
    
    public String getCutData() {
        return donneesCoupees;
    }
    
    public void annulerCouper() {
        recepteur.setContent(contenuPrecedent);
    }
 
}