
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
    private int position            =   0;
    
    public CommandeConcreteColler (Recepteur recepteur, String contenuAColler, int position) {
        this.recepteur      =   recepteur;
        this.contenuAColler =   contenuAColler;
        this.position       =   position;
    }
    
    public void lancer() {
        contenuPrecedent = recepteur.getContenu();
        recepteur.copier(contenuAColler);
        if (position > contenuPrecedent.length()){
            position = contenuPrecedent.length();
        }
        recepteur.coller(position);
        System.out.println("Donnees collées dans - "+ recepteur.getNom()+ "- position - " + position );
    }
       public String getDonneesCollees() {
        return contenuAColler;
    }
    public void annulerColler() {
        recepteur.setContent(contenuPrecedent);
    }
    
}