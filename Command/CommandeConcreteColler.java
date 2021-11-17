
/**
 * Décrivez votre classe CommandeConcreteColler ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class CommandeConcreteColler implements Commande{
    private Recepteur recepteur     =   null;
    private String contenuAColler   =   null;
    private String contenuPrecedent =   null;
    
    public CommandeConcreteColler (Recepteur recepteur, String contenuAColler) {
        this.recepteur=recepteur;
        this.contenuAColler=contenuAColler;
    }
    
    public void lancer() {
        contenuPrecedent = recepteur.getContenu();
        recepteur.copier(contenuAColler);
        recepteur.coller();
        System.out.println("Donnees collées dans "+ recepteur.getNom() +" nouveau contenu : "+recepteur.getContenu());
    }
    
    public void annulerColler() {
        recepteur.setContent(contenuPrecedent);
    }
}