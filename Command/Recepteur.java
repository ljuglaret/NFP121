import java.util.Stack;

/**
 * Décrivez votre classe Recepteur ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Recepteur
{
    private StringBuilder contenu;
    private String donneesEnMemoire;
    private String nom;
    
    public Recepteur(String nom , String init) {
        this.nom  = nom;
        contenu = new StringBuilder(init);
     }
     
    public String getContenu() {
        return contenu.toString();
    }
 
    public void copier(String  donneesEnMemoire){
        this.donneesEnMemoire = donneesEnMemoire;
    }
     
    public void couper(int debut, int fin){
        this.donneesEnMemoire = contenu.substring(debut , fin);
        contenu = contenu.delete(debut , fin);
    }
     
    public void coller(int position){
        String gauche = contenu.substring(0,position);
        String droite = contenu.substring(position , contenu.length());
        contenu = new StringBuilder ("");
        contenu.append(gauche + donneesEnMemoire + droite);
    }
     
    public void setContent(String content) {
        this.contenu = new StringBuilder(content);
    }
    
    public String getNom(){
        return nom;
    }
}
